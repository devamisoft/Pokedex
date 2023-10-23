package com.devamisoft.pokedex.models;

public class Pokemon {
    private String name;
    private String url;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
