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

        // Create Bundle to pass Album object
        Bundle bundle = new Bundle();
        bundle.putParcelable(ALBUM_KEY, album);

        // Instantiate the Fragment that is going to receive the Album object
        ViewAlbumFragment viewAlbumFragment = new ViewAlbumFragment();
        viewAlbumFragment.setArguments(bundle);

        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_fragment, viewAlbumFragment)
                .addToBackStack(null) // Allows for back navigation
                .commit();
    }
}