package com.example.christopher.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

public class WeatherDownloadRunnable implements Runnable {

    private static final String TAG = "WeatherDownloadRunnable";

    private final MainActivity mainActivity;
    private final String city;
    private final boolean fahrenheit;

    private static final String weatherURL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String iconUrl = "https://openweathermap.org/img/w/";

    //////////////////////////////////////////////////////////////////////////////////
    // Sign up to get your API Key at:  https://home.openweathermap.org/users/sign_up
    private static final String yourAPIKey = "6bfc226f3d6885de5b239a8c33047524";
    //
    //////////////////////////////////////////////////////////////////////////////////

    WeatherDownloadRunnable(MainActivity mainActivity, String city, boolean fahrenheit) {
        this.mainActivity = mainActivity;
        this.city = city;
        this.fahrenheit = fahrenheit;
    }


    @Override
    public void run() {

        Uri.Builder buildURL = Uri.parse(weatherURL).buildUpon();

        buildURL.appendQueryParameter("q", city);
        buildURL.appendQueryParameter("units", (fahrenheit ? "imperial" : "metric"));
        buildURL.appendQueryParameter("appid", yourAPIKey);
        String urlToUse = buildURL.build().toString();
        Log.d(TAG, "doInBackground: " + urlToUse);

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlToUse);

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            if (connection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                handleResults(null);
                return;
            }

            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            Log.d(TAG, "doInBackground: " + sb.toString());

        } catch (Exception e) {
            Log.e(TAG, "doInBackground: ", e);
            handleResults(null);
            return;
        }
        handleResults(sb.toString());
    }

    public void handleResults(final String jsonString) {

        final Weather w = parseJSON(jsonString);
        mainActivity.runOnUiThread(() -> mainActivity.updateData(w));
    }

    private Weather parseJSON(String s) {

        try {
            JSONObject jObjMain = new JSONObject(s);

            // "weather" section
            JSONArray weather = jObjMain.getJSONArray("weather");
            JSONObject jWeather = (JSONObject) weather.get(0);
            String condition = jWeather.getString("main");
            String description = jWeather.getString("description");
            String icon = jWeather.getString("icon");
            InputStream input = new java.net.URL(iconUrl + icon + ".png").openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);

            // "main" section
            JSONObject jMain = jObjMain.getJSONObject("main");
            String temp = jMain.getString("temp");
            String humidity = jMain.getString("humidity");

            // "wind" section
            JSONObject jWind = jObjMain.getJSONObject("wind");
            String wind = jWind.getString("speed");

            // "dt" section
            long dt = jObjMain.getLong("dt");
            String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.getDefault()).format(new Date(dt * 1000));

            // "name" section
            String city = jObjMain.getString("name");

            // "sys" section
            JSONObject jSys = jObjMain.getJSONObject("sys");
            String country = jSys.getString("country");

            return new Weather(city, country, condition, description, temp, humidity, wind, date, bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
