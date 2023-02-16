package com.jkutkut.android_weather_report;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jkutkut.android_weather_report.api.RetrofitClient;
import com.jkutkut.android_weather_report.api.WeatherAPI;
import com.jkutkut.android_weather_report.api.WeatherReport;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String KEY = "11ce4328111023379e0fdc9d28c24a02";
    private static final String EXCLUDE = "minutely,hourly,daily,alerts,flags";
    private static final String LANG = "en";

    private EditText etxtLatitude;
    private EditText etxtLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        TextView txtvExamples = findViewById(R.id.txtvExamples);
        etxtLatitude = findViewById(R.id.etxtLatitude);
        etxtLongitude = findViewById(R.id.etxtLongitude);

        etxtLatitude.setText("40.7128");
        etxtLongitude.setText("-3.70");

        btnSend.setOnClickListener(v -> requestWeather());

        // Get examples from xml string-array
        String[] examples = getResources().getStringArray(R.array.loc_examples);
        txtvExamples.setText(String.join("\n", examples));

    }

    private void requestWeather() {
        String latitude = etxtLatitude.getText().toString();
        String longitude = etxtLongitude.getText().toString();

        if (latitude.isEmpty()) {
            etxtLatitude.setError("Latitude is required");
        } else if (longitude.isEmpty()) {
            etxtLongitude.setError("Longitude is required");
        } else {
            getWeather(latitude, longitude);
        }
    }

    private void getWeather(String latitude, String longitude) {
        Retrofit r = RetrofitClient.getClient(WeatherAPI.BASE_URL);
        WeatherAPI api = r.create(WeatherAPI.class);
        Call<WeatherReport> call = api.getWeather(
                KEY,
                latitude, longitude,
                EXCLUDE, LANG

        );

        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(@NonNull Call<WeatherReport> call, @NonNull Response<WeatherReport> response) {
                if (!response.isSuccessful()) {
                    Log.i("Result: ", "Error" + response.code());
                } else {
                    WeatherReport wr = response.body();
                    Intent i = new Intent(MainActivity.this, WeatherResultActivity.class);
                    Bundle b = new Bundle();
                    b.putParcelable(WeatherResultActivity.KEY_OBJ, wr);
                    i.putExtras(b);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherReport> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}