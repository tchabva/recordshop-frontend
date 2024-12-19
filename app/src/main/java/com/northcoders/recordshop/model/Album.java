package com.northcoders.recordshop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.northcoders.recordshop.BR;

import java.text.DecimalFormat;
import java.util.Locale;

public class Album extends BaseObservable implements Parcelable {
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

    public Album(long id, String title, String artist, String genre, String releaseDate, int stock, double price, String artworkUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.price = price;
        this.artworkUrl = artworkUrl;
    }

    public Album() {
    }

    protected Album(Parcel in) {
        id = in.readLong();
        title = in.readString();
        artist = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        stock = in.readInt();
        price = in.readDouble();
        artworkUrl = in.readString();
        dateCreated = in.readString();
        dateModified = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String getDateModified() {
        return dateModified;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    @Bindable
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @BindingAdapter("android:text")
    public static void setPriceTextView(TextView textView, Double price) {
        DecimalFormat df = new DecimalFormat("0.00");
        String stringPrice = df.format(price);
        textView.setText("£".concat(stringPrice));
    }

    @BindingAdapter("android:text")
    public static void setPriceEditText(EditText editText, Double price) {
        if (price != null) {
            String formattedPrice = String.format(Locale.UK, "%.2f", price);
            if(!editText.getText().toString().equals(formattedPrice)){

                editText.setText(formattedPrice);
                editText.setSelection(editText.getText().length()-3);
            }
        }
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static Double getPrice(EditText editText) {
        String text = editText.getText().toString().trim();
        try {
            return text.isEmpty() ? 0.00 : Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.00;
        }
    }

    @Bindable
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @BindingAdapter("android:text")
    public static void setStockTextView(TextView textView, Integer stock) {
        textView.setText(String.valueOf(stock));
    }

    @BindingAdapter("android:text")
    public static void setStockEditText(EditText editText, Integer stock) {
        if (stock != null && !String.valueOf(stock).equals(editText.getText().toString())) {
            editText.setText(String.valueOf(stock));
            editText.setSelection(editText.getText().length());
        }
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static Integer getStock(EditText editText){
        String text = editText.getText().toString().trim();
        try {
            return text.isEmpty() ? 0 : Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeString(artist);
        parcel.writeString(genre);
        parcel.writeString(releaseDate);
        parcel.writeInt(stock);
        parcel.writeDouble(price);
        parcel.writeString(artworkUrl);
        parcel.writeString(dateCreated);
        parcel.writeString(dateModified);
    }
}