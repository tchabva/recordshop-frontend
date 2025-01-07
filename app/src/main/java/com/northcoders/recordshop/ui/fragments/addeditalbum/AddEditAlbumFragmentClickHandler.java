package com.northcoders.recordshop.ui.fragments.addeditalbum;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.ArtworkUrl;
import com.northcoders.recordshop.model.DeleteAlbumInterface;
import com.northcoders.recordshop.ui.fragments.home.HomeFragment;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;
import java.util.function.Consumer;

public class AddEditAlbumFragmentClickHandler implements DeleteAlbumInterface {

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

                    // Increasing the resolution of the image retrieved by the URL
                    String itunesArtworkUrl = artworkUrlResponse.getArtworkUrl100();

                    itunesArtworkUrl = itunesArtworkUrl.replace(
                            "100x100bb.jpg",
                            "1000x1000bb.jpg"
                    );

                    Log.i("Updated Artwork URL", itunesArtworkUrl);

                    newAlbum.setArtworkUrl(itunesArtworkUrl);
                }

                viewModel.addAlbum(newAlbum);

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment, new HomeFragment())
                        .commit();
            };

            /*
            NOTE: Ensures that the program will attempt to retrieve the artwork before posting an
                Album to the API
             */
            viewModel.getAlbumArtworkUrl(searchQuery, itunesResponseConsumer);

        }
        Log.i("ADD Button", "Add Button Clicked");
    }

    private void onUpdateButtonClicked(){

        // TODO use consumer to ensure the Response is valid prior to

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

            activity.getSupportFragmentManager().popBackStack();

            Log.i("Update Button", "Update Button Clicked");
        }
    }

    public void onDeleteButtonClicked(View view){
        AlertDialog deleteAlbumAlertDialog = deleteAlbumAlertDialog(
                activity,
                viewModel,
                album
        );

        deleteAlbumAlertDialog.show();
    }
}