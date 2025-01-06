package com.northcoders.recordshop.ui.fragments;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentHomeBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.AlbumAdapter;
import com.northcoders.recordshop.ui.mainactivity.MainActivityClickHandler;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private FragmentHomeBinding binding;
    private MainActivityClickHandler handler;
    private SearchView titleSearchView;
    private ArrayList<Album> filteredAlbumList;
    private SearchView artistSearchView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialise the ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);

        // Initialise the ClickHandler
        handler = new MainActivityClickHandler(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

//        binding = DataBindingUtil.inflate(
//                inflater,
//                R.layout.fragment_home,
//                container,
//                false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setClickHandler(handler); // Assign the initialised ClickHandler

        // Binding the searchViews & clearing their focuses
        titleSearchView = binding.albumTitleSearchView;
        titleSearchView.clearFocus();
        artistSearchView = binding.albumArtistSearchView;
        artistSearchView.clearFocus();

        setSearchView();

        getAllInStockAlbums();
    }

    private void setSearchView(){

        titleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText, artistSearchView.getQuery().toString());
                return true;
            }
        });

        artistSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(titleSearchView.getQuery().toString(),newText);
                return true;
            }
        });

    }

    private void filterList(String titleText, String artistText) {
        filteredAlbumList = new ArrayList<>();

        for (Album album : albumList) {
            boolean matchesTitle = album.getTitle().toLowerCase().contains(titleText.toLowerCase());
            boolean matchesArtist = album.getArtist().toLowerCase().contains(artistText.toLowerCase());

            if (matchesTitle && matchesArtist) {
                filteredAlbumList.add(album);
            }
        }

        if (filteredAlbumList.isEmpty()) {
            Toast.makeText(getContext(), "No albums found!", Toast.LENGTH_SHORT).show();
            albumAdapter.setFilteredList(filteredAlbumList);
        } else {
            albumAdapter.setFilteredList(filteredAlbumList);
        }
    }

    private void getAllInStockAlbums() {
        // Observe the changes in the album list
        viewModel.getAllInStockAlbums().observe(getActivity(), new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albumList = (ArrayList<Album>) albumsFromLiveData;

                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, handler);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }
}