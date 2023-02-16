package com.jkutkut.android_weather_report.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherAPI {
    String BASE_URL = "https://api.darksky.net/forecast/";

    @GET("{key}/{latitude},{longitude}")
    Call<WeatherReport> getWeather(
        @Path("key") String key,
        @Path("latitude") String latitude,
        @Path("longitude") String longitude,
        @Query("exclude") String exclude,
        @Query("lang") String lang
    );
}
