package com.northcoders.recordshop.model.service;

import com.northcoders.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllInStockAlbums();

    @POST("albums/add")
    Call<Album> addAlbum(@Body Album album);

    @PUT("albums/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<String> deleteAlbum(@Path("id") long id);
}
