package com.northcoders.recordshop.model.service;

import com.northcoders.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllInStockAlbums();

    @GET("albums/add")
    Call<Album> addAlbum(@Body Album album);
}
