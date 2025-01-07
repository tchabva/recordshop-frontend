package com.northcoders.recordshop.model;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.fragment.app.FragmentActivity;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.ui.fragments.home.HomeFragment;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public interface DeleteAlbumInterface {

    default AlertDialog deleteAlbumAlertDialog(
            FragmentActivity activity,
            MainActivityViewModel viewModel,
            Album album
    ){
        // 1. Instantiate an AlertDialog.Builder with its constructor.
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Add the buttons
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                viewModel.deleteAlbum(album.getId()); // Delete the album

                // Return back to the HomeFragment
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment, new HomeFragment())
                        .commit();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancels the dialog.
            }
        });
        // Set other dialog properties.
        builder.setMessage(R.string.dialog_delete_message)
                .setTitle(R.string.dialig_delete_album_title);

        // Create the AlertDialog.
        return builder.create();
    }
}