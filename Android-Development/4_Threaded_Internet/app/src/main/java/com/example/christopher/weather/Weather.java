package com.example.christopher.weather;

import android.graphics.Bitmap;

class Weather {

    private final String city;
    private final String country;
    private final String conditions;
    private final String description;
    private final String temp;
    private final String humidity;
    private final String wind;
    private final String date;
    private final Bitmap bitmap;

    Weather(String city, String country, String conditions, String description,
                   String temp, String humidity, String wind, String date, Bitmap bitmap) {
        this.city = city;
        this.country = country;
        this.conditions = conditions;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
        this.wind = wind;
        this.date = date;
        this.bitmap = bitmap;
    }

    String getCity() {
        return city;
    }

    String getCountry() {
        return country;
    }

    String getConditions() {
        return conditions;
    }

    String getDescription() {
        return description;
    }

    String getTemp() {
        return temp;
    }

    String getHumidity() {
        return humidity;
    }

    String getWind() {
        return wind;
    }

    String getDate() {
        return date;
    }

    Bitmap getBitmap() {
        return bitmap;
    }
}
