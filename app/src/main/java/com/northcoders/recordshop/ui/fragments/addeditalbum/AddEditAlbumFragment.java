package com.northcoders.recordshop.ui.fragments.addeditalbum;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.FragmentAddEditAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;
import com.northcoders.recordshop.ui.viewalbum.ViewAlbumClickHandler;
import com.northcoders.recordshop.ui.viewalbum.ViewScreenState;


public class AddEditAlbumFragment extends Fragment {

    private FragmentAddEditAlbumBinding binding;
    private AddEditAlbumFragmentClickHandler handler;
    private MainActivityViewModel viewModel;
    private Album album;
    private ViewScreenState state;
    private final static String ALBUM_KEY = "album";

    public AddEditAlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Instantiate the ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddEditAlbumBinding.inflate(inflater, container, false);

        Album passedAlbum;

        if (getArguments() != null){
            passedAlbum = getArguments().getParcelable(ALBUM_KEY);
            state = ViewScreenState.UPDATE_ALBUM; // If album exists state is Update Album
        }else {
            passedAlbum = null;
            state = ViewScreenState.ADD_ALBUM; // If album is null state is Add Album
        }

        // If passedAlbum is null assign album to a new Album object, else assign the passedAlbum
        album = passedAlbum == null? new Album() : passedAlbum;

        handler = new AddEditAlbumFragmentClickHandler(album, getActivity(), viewModel, state);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (state == ViewScreenState.UPDATE_ALBUM){
            binding.headerTextView.setText(R.string.edit_album);
            binding.submitButton.setText(R.string.update);
            binding.deleteButton.setVisibility(View.VISIBLE);
            state = ViewScreenState.UPDATE_ALBUM;
        }

        binding.setAlbum(album);

        binding.setClickHandler(handler);
    }
}