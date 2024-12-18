package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.content.Intent;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.viewalbum.ViewAlbumActivity;

public class MainActivityClickHandler {

    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddAlbumFABClicked(Album album){
        Intent intent = new Intent(context, ViewAlbumActivity.class);

            intent.putExtra("album", album);

        context.startActivity(intent);
    }
}