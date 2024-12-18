package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandler {

    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddAlbumFABClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
