package com.northcoders.recordshop.ui.fragments.addeditalbum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.ArtworkUrl;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;
import java.util.function.Consumer;

public class AddEditAlbumFragmentClickHandler {

    private final Album album;
    private final FragmentActivity activity;
    private final MainActivityViewModel viewModel;
    private final AddEditScreenState state;

    public AddEditAlbumFragmentClickHandler(Album album, FragmentActivity activity, MainActivityViewModel viewModel, AddEditScreenState state) {
        this.album = album;
        this.activity = activity;
        this.viewModel = viewModel;
        this.state = state;
    }

    public void onSubmitButtonClicked(View view){

        switch (state) {
            case ADD_ALBUM:
                onAddButtonClicked();
                break;
            case UPDATE_ALBUM:
                onUpdateButtonClicked();
                break;
        }
    }

    private void onAddButtonClicked(){

        Album newAlbum = new Album(
                album.getId(),
                album.getTitle(),
                album.getArtist(),
                album.getGenre(),
                album.getReleaseDate(),
                album.getStock(),
                album.getPrice(),
                album.getArtworkUrl()
        );

        if(newAlbum.getTitle() == null || newAlbum.getArtist() == null || newAlbum.getGenre() == null ||
                newAlbum.getReleaseDate() == null ||  newAlbum.getPrice() == null || newAlbum.getStock() == null ){
            Toast.makeText(
                    activity,
                    "Fields cannot be empty",
                    Toast.LENGTH_SHORT).show();
        }else {

            String searchQuery = album.getArtist().trim().concat(" ").concat(album.getTitle());

            Consumer<ArtworkUrl> itunesResponseConsumer = artworkUrlResponse -> {

                if (artworkUrlResponse != null){
                    Log.i("Itunes Response Callback", artworkUrlResponse.getArtworkUrl100());
                    newAlbum.setArtworkUrl(artworkUrlResponse.getArtworkUrl100());
                }

                viewModel.addAlbum(newAlbum);
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);

            };

            viewModel.getAlbumArtworkUrl(searchQuery, itunesResponseConsumer);

        }
        Log.i("ADD Button", "Add Button Clicked");
    }

    private void onUpdateButtonClicked(){

        Album updatedAlbum = new Album(
                album.getId(),
                album.getTitle(),
                album.getArtist(),
                album.getGenre(),
                album.getReleaseDate(),
                album.getStock(),
                album.getPrice(),
                album.getArtworkUrl()
        );

        // If you try and return any Empty strings for these attributes, a Toast will appear
        if (Objects.equals(updatedAlbum.getTitle(), "") ||
                Objects.equals(updatedAlbum.getArtist(), "") ||
                Objects.equals(updatedAlbum.getGenre(), "") ||
                Objects.equals(updatedAlbum.getReleaseDate(), "")){

            Toast.makeText(activity, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            long albumId = album.getId();

            viewModel.updateAlbum(albumId, updatedAlbum);

//            Intent intent = new Intent(activity, MainActivity.class);
//            activity.startActivity(intent);
            activity.getSupportFragmentManager().popBackStack();

            Log.i("Update Button", "Update Button Clicked");
        }
    }

    public void onDeleteButtonClicked(View view){
        deleteAlbumAlertDialog().show();
    }

    public void onBackButtonClicked(View view){
        // TODO: Add functionality for a dialog to pop up if back is clicked for an edited album that has not been updated
        activity.getSupportFragmentManager().popBackStack();
    }

    private AlertDialog deleteAlbumAlertDialog(){
        // 1. Instantiate an AlertDialog.Builder with its constructor.
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        // Add the buttons.
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                viewModel.deleteAlbum(album.getId()); // Delete the album

                // Return back to the MainActivity
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
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