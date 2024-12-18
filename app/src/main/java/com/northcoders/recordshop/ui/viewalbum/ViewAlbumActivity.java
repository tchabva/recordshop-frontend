package com.northcoders.recordshop.ui.viewalbum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityViewAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class ViewAlbumActivity extends AppCompatActivity {

    private ActivityViewAlbumBinding binding;
    private AddAlbumClickHandler handler;
    private Album album;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_album);

        Album passedAlbum = (Album) getIntent().getExtras().getSerializable("album");

        album  = passedAlbum == null? new Album() : passedAlbum;

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new AddAlbumClickHandler(album, this, viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(handler);
    }
}