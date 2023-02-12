package com.jkutkut.android_weather_report;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jkutkut.android_weather_report.model.RetrofitClient;
import com.jkutkut.android_weather_report.model.WeatherAPI;
import com.jkutkut.android_weather_report.model.WeatherReport;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://api.darksky.net/forecast/%s/%s,%s?exclude=minutely,hourly,daily,alerts,flags&lang=es";
    private static final String KEY = "11ce4328111023379e0fdc9d28c24a02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit r = RetrofitClient.getClient(WeatherAPI.BASE_URL);
        WeatherAPI api = r.create(WeatherAPI.class);
        Call<WeatherReport> call = api.getWeather(
            KEY, "37.8267", "-122.4233",
            "minutely,hourly,daily,alerts,flags", "en"
        );

        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(@NonNull Call<WeatherReport> call, @NonNull Response<WeatherReport> response) {
                if (!response.isSuccessful()) {
                    Log.i("Resultado: ", "Error" + response.code());
                } else {
                    WeatherReport wr = response.body();
                    System.err.println(wr);
//                    Intent i = new Intent(MainActivity.this, WeatherResult.class);
//                    i.putExtra(WeatherResult.KEY_OBJ, wr);
//                    startActivity(i);
                    // Send the wr object with bundle
                    Intent i = new Intent(MainActivity.this, WeatherResult.class);
                    Bundle b = new Bundle();
                    b.putSerializable(WeatherResult.KEY_OBJ, wr);
                    i.putExtras(b);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherReport> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
                System.err.println(t.toString());
            }
        });
    }
}