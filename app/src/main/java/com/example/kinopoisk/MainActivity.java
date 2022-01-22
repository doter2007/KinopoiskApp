package com.example.kinopoisk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    private Gson gson;
    private ImageButton imageButton;
    public Bitmap_film bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new GsonBuilder().setLenient().create();
        imageButton = findViewById(R.id.imageButton);
        bmp = new Bitmap_film();
        imageButton.setImageBitmap(Bitmap_film.getImageBitmap("301"));


    }
}