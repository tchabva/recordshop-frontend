package com.northcoders.recordshop.ui.fragments.viewalbum;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentHomeBinding;
import com.northcoders.recordshop.databinding.FragmentViewAlbumBinding;
import com.northcoders.recordshop.model.Album;


public class ViewAlbumFragment extends Fragment {

    private FragmentViewAlbumBinding binding;
    private FloatingActionButton editFAB;
    private FloatingActionButton backFAB;
    private Album album;
    private final static String ALBUM_KEY = "album";


    public ViewAlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewAlbumBinding.inflate(inflater, container, false);

        if (getArguments() != null) {
            album = getArguments().getParcelable(ALBUM_KEY);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editFAB = binding.editFab;
        backFAB = binding.backFab;

        Glide.with(binding.albumArtwork.getContext())
                .load(album.getArtworkUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.holder_album_artwork)
                .into(binding.albumArtwork);

        binding.setAlbum(album);
    }
}