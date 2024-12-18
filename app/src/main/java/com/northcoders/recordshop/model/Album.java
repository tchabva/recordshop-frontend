package com.northcoders.recordshop.model;

import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.northcoders.recordshop.BR;

import java.text.DecimalFormat;

public class Album extends BaseObservable {
    private long id;
    private String title;
    private String artist;
    private String genre;
    private String releaseDate;
    private int stock;
    private double price;
    private String artworkUrl;
    private String dateCreated;
    private String dateModified;

    public Album(long id, String title, String artist, String genre, String releaseDate, int stock, double price, String artworkUrl, String dateCreated, String dateModified) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.price = price;
        this.artworkUrl = artworkUrl;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public Album() {
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    @Bindable
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @BindingAdapter("android:text")
    public static void setPrice(TextView textView, Double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String stringPrice = df.format(price);
        textView.setText("£".concat(stringPrice));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Double getPrice(TextView textView){
        return Double.valueOf(textView.getText().toString().substring(1));
    }

    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @BindingAdapter("android:text")
    public static void setStock(TextView textView, Integer stock) {
        textView.setText(String.valueOf(stock));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer getStock(TextView textView){
        return Integer.valueOf(textView.getText().toString().substring(1));
    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public long getId() {
        return id;
    }

    @Bindable
    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
        notifyPropertyChanged(BR.artworkUrl);
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
}