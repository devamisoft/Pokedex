package com.devamisoft.pokedex.models;

public class Pokemon {
    private int id;
    private String name;
    private String url;
    private String imageUrl;

    public int getId() {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

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




