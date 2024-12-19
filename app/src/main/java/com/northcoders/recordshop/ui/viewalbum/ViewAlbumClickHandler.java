package com.northcoders.recordshop.ui.viewalbum;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class ViewAlbumClickHandler {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;
    private ViewScreenState state;

    public ViewAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel, ViewScreenState state) {
        this.album = album;
        this.context = context;
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
                    context,
                    "Fields cannot be empty",
                    Toast.LENGTH_SHORT).show();
        }else {
            viewModel.addAlbum(newAlbum);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
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

            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            long albumId = album.getId();

            viewModel.updateAlbum(albumId, updatedAlbum);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);

            Log.i("Update Button", "Update Button Clicked");
        }
    }

    public void onDeleteButtonClicked(View view){

        viewModel.deleteAlbum(album.getId());

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onBackButtonClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
