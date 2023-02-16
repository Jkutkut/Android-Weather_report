package com.jkutkut.android_weather_report;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkutkut.android_weather_report.api.WeatherReport;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class WeatherResultActivity extends AppCompatActivity {

    public static final String KEY_OBJ = "KEY_OBJ";

    private static final HashMap<String, Integer> imgs = new HashMap<String, Integer>() {{
        put("clear-day", R.drawable.clear_day);
        put("clear-night", R.drawable.clear_night);
        put("cloudy", R.drawable.cloudy);
        put("cloudy_night", R.drawable.cloudy_night);
        put("fog", R.drawable.fog);
        put("partly-cloudy", R.drawable.partly_cloudy);
        put("rain", R.drawable.rain);
        put("sleet", R.drawable.sleet);
        put("snow", R.drawable.snow);
        put("sunny", R.drawable.sunny);
        put("wind", R.drawable.wind);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_result);

        WeatherReport wr;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            wr = getIntent().getParcelableExtra(KEY_OBJ, WeatherReport.class);
        }
        else {
            wr = getIntent().getParcelableExtra(KEY_OBJ); // @deprecated
        }

        final TextView txtvCity = findViewById(R.id.txtvCity);
        final ImageView imgvWeather = findViewById(R.id.imgvWeather);
        final TextView txtvTime = findViewById(R.id.txtvTime);
        final TextView txtvDegree = findViewById(R.id.txtvDegree);
        final TextView txtvHumidityValue = findViewById(R.id.txtvHumidityValue);
        final TextView txtvRainValue = findViewById(R.id.txtvRainValue);
        final TextView txtvWeather = findViewById(R.id.txtvWeather);

        final Locale locale = new Locale("es", "ES");

        txtvCity.setText(wr.getTimezone());

        System.out.println(wr.getCurrently());
        if (wr.getCurrently() == null) {
            txtvWeather.setText("No weather data available");
            return;
        }
        Integer img = imgs.get(wr.getCurrently().getIcon());
        if (img == null)
            img = R.drawable.sunny;
        imgvWeather.setImageResource(img);
        txtvTime.setText(String.format(
            locale,
            "%1$tT %1$td/%1$tm/%1$tY",
            new Date(wr.getCurrently().getTime() * 1000L)
        ));
        txtvDegree.setText(String.format(
            locale,
            "%.0f",
            farenheitToCelsius(wr.getCurrently().getTemperature())
        ));
        txtvHumidityValue.setText(String.format(
            locale,
            "%.2f%%",
            wr.getCurrently().getHumidity()
        ));
        txtvRainValue.setText(String.format(
            locale,
            "%.2f%%",
            wr.getCurrently().getPrecipProbability()
        ));
        txtvWeather.setText(wr.getCurrently().getSummary());
    }

    private double farenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }
}