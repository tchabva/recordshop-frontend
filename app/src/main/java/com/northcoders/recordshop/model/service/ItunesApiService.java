package com.northcoders.recordshop.model.service;

import com.northcoders.recordshop.model.ItunesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesApiService {

    @GET("search?entity=album&country=gb&limit=1")
    Call<ItunesResponse> getAlbumArtworkUrl(@Query("term") String searchQuery);
}
