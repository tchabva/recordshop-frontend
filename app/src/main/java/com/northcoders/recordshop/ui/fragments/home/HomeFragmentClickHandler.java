package com.northcoders.recordshop.ui.fragments.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.viewalbum.ViewAlbumActivity;

public class HomeFragmentClickHandler {

    private final Context context;
    private final static String ALBUM_KEY = "album";

    public HomeFragmentClickHandler(Context context) {
        this.context = context;
    }

    public void onAlbumItemClicked(Album album){

        Intent intent = new Intent(context, ViewAlbumActivity.class);

        intent.putExtra(ALBUM_KEY, album);

        context.startActivity(intent);
    }

    public void onAddAlbumFABClicked(View view){

        Intent intent = new Intent(context, ViewAlbumActivity.class);

        Album album = null;

        intent.putExtra("album", album);

        context.startActivity(intent);
    }
}