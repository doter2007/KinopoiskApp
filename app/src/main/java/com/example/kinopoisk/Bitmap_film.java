package com.example.kinopoisk;

import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bitmap_film {
    private static final String TAG = "";
    public static Bitmap getImageBitmap(String filmId) {
        Bitmap bm = null;
        try {
            String url = String.format("https://kinopoiskapiunofficial.tech/api/v2.2/films/%s", filmId);
            URL aURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) aURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.addRequestProperty("accept", "application/json");
            conn.addRequestProperty("X-API-KEY", "3b4d0cb3-6d98-483e-ace8-73eb97f20e3c");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = "";
            while (reader.readLine() != null){
                response += reader.readLine();
            }

            JSONObject jsonObject = new JSONObject(response);
            String posterUrlProp = "posterUrl";
            String posterUrl = jsonObject.getString(posterUrlProp);



           /* BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();*/
        } catch (IOException | JSONException e) {
            Log.e(TAG, "Error getting bitmap", e);
        }
        return bm;
    }
}
