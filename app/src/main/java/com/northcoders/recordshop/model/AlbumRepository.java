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
                Log.e("POST failure", t.getMessage());
            }
        });
    }

    public void updateAlbum(long id, Album album){

        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {

                Toast.makeText(
                        application.getApplicationContext(),
                        "Album updated",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Unable to update book",
                        Toast.LENGTH_SHORT).show();
                Log.e("PUT request", t.getMessage());
            }
        });
    }

    public void deleteAlbum(long id){

        Call<Void> call = albumApiService.deleteAlbum(id);


        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    Toast.makeText(
                            application.getApplicationContext(),
                            "Album Deleted",
                            Toast.LENGTH_SHORT).show();
                    Log.i("DELETE Request", "Album deleted");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Unable to delete book",
                        Toast.LENGTH_SHORT).show();
                Log.e("DELETE onFail", t.getMessage());
            }
        });
    }
}