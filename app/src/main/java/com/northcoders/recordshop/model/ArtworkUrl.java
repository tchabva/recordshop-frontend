package com.northcoders.recordshop.model;

public class ArtworkUrl {
    String artistName;
    String artworkUrl100;

    public ArtworkUrl(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public ArtworkUrl() {
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
