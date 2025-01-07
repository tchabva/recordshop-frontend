package com.northcoders.recordshop.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.AlbumRepository;
import com.northcoders.recordshop.model.ArtworkUrl;

import java.util.List;
import java.util.function.Consumer;

public class MainActivityViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllInStockAlbums(){
        return albumRepository.getMutableLiveData();
    }

    public void addAlbum(Album album){
        albumRepository.addAlbum(album);
    }

    public void updateAlbum(long id,Album album){
        albumRepository.updateAlbum(id, album);
    }

    public void deleteAlbum(long id){
        albumRepository.deleteAlbum(id);
    }

    public LiveData<List<Album>> getAllAlbumsByArtistName(String artistName){
        return albumRepository.getAlbumsByArtistName(artistName);
    }

    public void getAlbumArtworkUrl(String searchQuery, Consumer<ArtworkUrl> itunesResponseConsumer){
        albumRepository.getAlbumArtworkUrl(searchQuery, itunesResponseConsumer);
    }
}

