package com.northcoders.recordshop.ui.mainactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityMainBinding;
import com.northcoders.recordshop.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private MainActivityClickHandler handler;
    private SearchView searchView;
    private ArrayList<Album> filteredAlbumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // initialising the ViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        handler = new MainActivityClickHandler(this);

        binding.setClickHandler(handler);

        getAllInStockAlbums();

        searchView = binding.searchView;
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String newText) {
        filteredAlbumList = new ArrayList<>();

        for(Album album : albumList){
            // Filter conditions
            if(album.getTitle().toLowerCase().contains(newText.toLowerCase())){
                filteredAlbumList.add(album);
            }
        }

        if (filteredAlbumList.isEmpty()){
            Toast.makeText(this, "No albums found!", Toast.LENGTH_SHORT).show();
            albumAdapter.setFilteredList(filteredAlbumList);
        }else {
            albumAdapter.setFilteredList(filteredAlbumList);
        }
    }

    private void getAllInStockAlbums() {
        // Observe the changes in the album list
        viewModel.getAllInStockAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albumList = (ArrayList<Album>) albumsFromLiveData;

                displayAlbumsInRecyclerView();
            }
        });
    }

    // Sets up the RecyclerView
    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, handler);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }
}