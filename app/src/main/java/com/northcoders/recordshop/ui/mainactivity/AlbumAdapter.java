package com.northcoders.recordshop.ui.mainactivity;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.AlbumItemBinding;
import com.northcoders.recordshop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albumList;
    private MainActivityClickHandler clickHandler;

    public AlbumAdapter(List<Album> albumList, MainActivityClickHandler clickHandler) {
        this.albumList = albumList;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item,
                parent,
                false
        );

        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumItemBinding.setAlbum(album);

        String artworkUrl = album.getArtworkUrl();

        Glide.with(holder.imageView.getContext())
                .load(artworkUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.holder_album_artwork)
                .into(holder.imageView);

        holder.albumItemBinding.albumItemCard.setOnClickListener( view -> {
            holder.albumItemBinding.albumItemCard.setCardElevation(0);
            clickHandler.onAddAlbumFABClicked(album);
        });
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{

        private AlbumItemBinding albumItemBinding;
        private ImageView imageView;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
            this.imageView = albumItemBinding.albumArtwork;

        }

    }
}
