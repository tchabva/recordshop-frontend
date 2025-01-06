package com.northcoders.recordshop.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentHomeBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.AlbumAdapter;
import com.northcoders.recordshop.ui.mainactivity.MainActivityClickHandler;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;

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


    }
}