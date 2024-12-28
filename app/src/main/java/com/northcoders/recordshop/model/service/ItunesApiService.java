package com.northcoders.recordshop.model.service;

import com.northcoders.recordshop.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesApiService {

    @GET("search?entity=album&country=gb&limit=1")
    Call<Results> getAlbumArtworkUrl(@Query("term") String searchQuery);
}
