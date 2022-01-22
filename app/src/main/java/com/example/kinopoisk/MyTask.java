package com.example.kinopoisk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageButton;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyTask extends AsyncTask<String, Void, Film>{


    private static final String TAG = "";
    private final Gson gson;

    public MyTask( ImageButton imageButton, Gson gson) {
        this.gson = gson;
    }


    @Override
    protected Film doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String data = "", line;
                while ((line = bf.readLine()) != null) {
                    data += line;
                }
                System.out.println(data);
                Film[] fimls = gson.fromJson(data, Film[].class);
                return fimls[0];
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getCause() + " " + e.getMessage());
            }

            return null;

        }
    public static Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            ((URLConnection) conn).connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e(TAG, "Error getting bitmap", e);
        }
        return bm;
    }





}

