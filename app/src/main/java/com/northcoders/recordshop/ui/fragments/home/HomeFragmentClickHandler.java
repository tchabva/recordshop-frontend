package com.northcoders.recordshop.ui.fragments.home;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.fragments.viewalbum.ViewAlbumFragment;

public class HomeFragmentClickHandler {

    private final FragmentActivity activity;
    private final static String ALBUM_KEY = "album";

    public HomeFragmentClickHandler(FragmentActivity activity) {
        this.activity = activity;
    }

    public void onAlbumItemClicked(Album album){

//        Intent intent = new Intent(context, ViewAlbumActivity.class);
//
//        intent.putExtra(ALBUM_KEY, album);
//
//        context.startActivity(intent);

        Bundle bundle = new Bundle();
        bundle.putParcelable(ALBUM_KEY, album);

        ViewAlbumFragment viewAlbumFragment = new ViewAlbumFragment();
        viewAlbumFragment.setArguments(bundle);

        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_fragment, viewAlbumFragment)
                .addToBackStack(null) // Allows for back navigation
                .commit();
    }

    public void onAddAlbumFABClicked(View view){

//        Intent intent = new Intent(activity, ViewAlbumActivity.class);
//
//        Album album = null;
//
//        intent.putExtra("album", album);
//
//        activity.startActivity(intent);
    }
}