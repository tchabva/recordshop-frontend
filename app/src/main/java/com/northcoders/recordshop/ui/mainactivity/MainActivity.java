package com.northcoders.recordshop.ui.mainactivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationBarView;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityMainBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.ItunesResponse;
import com.northcoders.recordshop.ui.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private MainActivityClickHandler handler;
    private SearchView titleSearchView;
    private ArrayList<Album> filteredAlbumList;
    private SearchView artistSearchView;
    private NavigationBarView bottomNavigation;
    private HomeFragment homeFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Binding the bottom Navigation View
        bottomNavigation = binding.bottomNavigationView;
        bottomNavigation.setOnItemSelectedListener(this);
        bottomNavigation.setSelectedItemId(R.id.home);

        // initialising the ViewModel
//        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
//
//        handler = new MainActivityClickHandler(this);
//
//        binding.setClickHandler(handler);
//
//        getAllInStockAlbums();
//
//        titleSearchView = binding.albumTitleSearchView;
//        titleSearchView.clearFocus();
//
//        artistSearchView = binding.albumArtistSearchView;
//        artistSearchView.clearFocus();
//
//        setSearchView();
//
//        viewModel.getAllAlbumsByArtistName("TC-EP");
//
//        ItunesResponse itunesResponse = viewModel.getAlbumAtworkUrl("TC-EP Ephemeral Emotions");
    }

//    private void setSearchView(){
//
//        titleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filterList(newText, artistSearchView.getQuery().toString());
//                return true;
//            }
//        });
//
//        artistSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filterList(titleSearchView.getQuery().toString(),newText);
//                return true;
//            }
//        });
//
//    }
//
//    private void filterList(String titleText, String artistText) {
//        filteredAlbumList = new ArrayList<>();
//
//        for (Album album : albumList) {
//            boolean matchesTitle = album.getTitle().toLowerCase().contains(titleText.toLowerCase());
//            boolean matchesArtist = album.getArtist().toLowerCase().contains(artistText.toLowerCase());
//
//            if (matchesTitle && matchesArtist) {
//                filteredAlbumList.add(album);
//            }
//        }
//
//        if (filteredAlbumList.isEmpty()) {
//            Toast.makeText(this, "No albums found!", Toast.LENGTH_SHORT).show();
//            albumAdapter.setFilteredList(filteredAlbumList);
//        } else {
//            albumAdapter.setFilteredList(filteredAlbumList);
//        }
//    }
//
//    private void getAllInStockAlbums() {
//        // Observe the changes in the album list
//        viewModel.getAllInStockAlbums().observe(this, new Observer<List<Album>>() {
//            @Override
//            public void onChanged(List<Album> albumsFromLiveData) {
//                albumList = (ArrayList<Album>) albumsFromLiveData;
//
//                displayAlbumsInRecyclerView();
//            }
//        });
//    }

//    // Sets up the RecyclerView
//    private void displayAlbumsInRecyclerView() {
//        recyclerView = binding.recyclerView;
//        albumAdapter = new AlbumAdapter(albumList, handler);
//        recyclerView.setAdapter(albumAdapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        albumAdapter.notifyDataSetChanged();
//    }
//
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_fragment, homeFragment)
                    .commit();
            return true;
        }

        return false;
    }
}