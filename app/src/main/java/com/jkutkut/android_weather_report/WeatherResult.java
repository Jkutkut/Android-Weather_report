package com.jkutkut.android_weather_report;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkutkut.android_weather_report.model.WeatherReport;

public class WeatherResult extends AppCompatActivity {

    public static final String KEY_OBJ = "KEY_OBJ";

    private TextView txtvCity;
    private ImageView imgvWeather;
    private TextView txtvTime;
    private TextView txtvDegree;
    private TextView txtvHumidityValue;
    private TextView txtvRainValue;
    private TextView txtvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_result);

        WeatherReport wr = (WeatherReport) getIntent().getSerializableExtra(KEY_OBJ);

        txtvCity = findViewById(R.id.txtvCity);
        imgvWeather = findViewById(R.id.imgvWeather);
        txtvTime = findViewById(R.id.txtvTime);
        txtvDegree = findViewById(R.id.txtvDegree);
        txtvHumidityValue = findViewById(R.id.txtvHumidityValue);
        txtvRainValue = findViewById(R.id.txtvRainValue);
        txtvWeather = findViewById(R.id.txtvWeather);

        txtvCity.setText(wr.getTimezone());
//        txtvTime.setText(wr.getCurrently().getTime());
//        txtvDegree.setText(wr.getCurrently().getTemperature() + "°");
//        txtvHumidityValue.setText(wr.getCurrently().getHumidity() + "%");
//        txtvRainValue.setText(wr.getCurrently().getPrecipProbability() + "%");
//        txtvWeather.setText(wr.getCurrently().getSummary());
    }
}