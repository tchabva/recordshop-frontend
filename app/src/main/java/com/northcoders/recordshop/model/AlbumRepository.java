package com.northcoders.recordshop.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshop.model.service.AlbumApiService;
import com.northcoders.recordshop.model.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    private AlbumApiService albumApiService;

    public AlbumRepository(Application application) {
        this.application = application;
        this.albumApiService = RetrofitInstance.getService();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {

        Call<List<Album>> call = albumApiService.getAllInStockAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.i("GET request", t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public void addAlbum(Album album){

        Call<Album> call = albumApiService.addAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Album added to database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Unable to add Album to database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}