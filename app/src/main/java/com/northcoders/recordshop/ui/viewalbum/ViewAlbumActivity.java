package com.northcoders.recordshop.ui.viewalbum;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityViewAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class ViewAlbumActivity extends AppCompatActivity {

    private ActivityViewAlbumBinding binding;
    private ViewAlbumClickHandler handler;
    private Album album;
    private ViewScreenState state;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_album);

        Album passedAlbum = getIntent().getParcelableExtra("album");

        album  = passedAlbum == null? new Album() : passedAlbum;

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_album);

        state = ViewScreenState.ADD_ALBUM;

        if (passedAlbum != null){
            binding.headerTextView.setText(R.string.edit_album);
            binding.submitButton.setText(R.string.update);
            binding.deleteButton.setVisibility(View.VISIBLE);
            state = ViewScreenState.UPDATE_ALBUM;
        }

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new ViewAlbumClickHandler(album, this, viewModel, state);

        binding.setAlbum(album);

        binding.setClickHandler(handler);
    }
}