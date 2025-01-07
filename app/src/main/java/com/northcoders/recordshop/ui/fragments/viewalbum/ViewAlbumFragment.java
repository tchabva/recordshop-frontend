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
import com.northcoders.recordshop.databinding.FragmentViewAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.fragments.addeditalbum.AddEditAlbumFragment;


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

        // Binding the FABs in the View
        editFAB = binding.editFab;
        backFAB = binding.backFab;

        // Loading the Album Artwork
        Glide.with(binding.albumArtwork.getContext())
                .load(album.getArtworkUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.holder_album_artwork)
                .into(binding.albumArtwork);

        // Binding the album to the view.
        binding.setAlbum(album);

        // Returns to the HomeFragment View
        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Implemented Edit Button to ViewAlbumActivty
        editFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), ViewAlbumActivity.class);
//
//                intent.putExtra(ALBUM_KEY, album);
//
//                getContext().startActivity(intent);

                Bundle bundle = new Bundle();
                bundle.putParcelable(ALBUM_KEY, album);

                AddEditAlbumFragment addEditAlbumFragment = new AddEditAlbumFragment();
                addEditAlbumFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment, addEditAlbumFragment)
                        .addToBackStack(null) // Allows for back navigation
                        .commit();
            }
        });
    }
}