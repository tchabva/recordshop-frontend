package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.recordshop.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {

    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddAlbumFABClicked(View view){
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}