package com.example.kinopoisk;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Film {

    private String id;
    private String url;

    public Film(){}

    public Film(ImageView filmImage, String id, String url) {

        this.id = id;
        this.url = url;
    }

    public Bitmap getFilmImage() {
        return null;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setFilmImage(ImageView filmImage) {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
