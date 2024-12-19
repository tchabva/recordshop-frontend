package com.northcoders.recordshop.ui.viewalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class ViewAlbumClickHandler {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public ViewAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButtonClicked(View view){

        if(album.getTitle() == null || album.getArtist() == null || album.getGenre() == null ||
        album.getReleaseDate() == null ||  album.getPrice() == null || album.getStock() == null ){
            Toast.makeText(
                    context,
                    "Only optional fields can be empty",
                    Toast.LENGTH_SHORT).show();
        }else {
            viewModel.addAlbum(album);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
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
