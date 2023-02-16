package com.jkutkut.android_weather_report.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.jkutkut.android_weather_report.api.CurrentWeather;

public class CurrentWeatherWrapper implements Parcelable {
    private Integer time;
    private String summary;
    private String icon;
    private Double precipIntensity;
    private Double precipProbability;
    private Double temperature;
    private Double apparentTemperature;
    private Double dewPoint;
    private Double humidity;
    private Double pressure;
    private Double windSpeed;
    private Double windGust;
    private Integer windBearing;
    private Double cloudCover;
    private Double uvIndex;
    private Double visibility;
    private Double ozone;

    public CurrentWeatherWrapper(CurrentWeather cw) {
        this.time = cw.getTime();
        this.summary = cw.getSummary();
        this.icon = cw.getIcon();
        this.precipIntensity = cw.getPrecipIntensity();
        this.precipProbability = cw.getPrecipProbability();
        this.temperature = cw.getTemperature();
        this.apparentTemperature = cw.getApparentTemperature();
        this.dewPoint = cw.getDewPoint();
        this.humidity = cw.getHumidity();
        this.pressure = cw.getPressure();
        this.windSpeed = cw.getWindSpeed();
        this.windGust = cw.getWindGust();
        this.windBearing = cw.getWindBearing();
        this.cloudCover = cw.getCloudCover();
        this.uvIndex = cw.getUvIndex();
        this.visibility = cw.getVisibility();
        this.ozone = cw.getOzone();
    }

    protected CurrentWeatherWrapper(Parcel in) {
//        if (in.readByte() == 0) {
//            time = null;
//        } else {
//            time = in.readInt();
//        }
//        summary = in.readString();
//        icon = in.readString();
//        if (in.readByte() == 0) {
//            precipIntensity = null;
//        } else {
//            precipIntensity = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            precipProbability = null;
//        } else {
//            precipProbability = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            temperature = null;
//        } else {
//            temperature = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            apparentTemperature = null;
//        } else {
//            apparentTemperature = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            dewPoint = null;
//        } else {
//            dewPoint = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            humidity = null;
//        } else {
//            humidity = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            pressure = null;
//        } else {
//            pressure = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            windSpeed = null;
//        } else {
//            windSpeed = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            windGust = null;
//        } else {
//            windGust = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            windBearing = null;
//        } else {
//            windBearing = in.readInt();
//        }
//        if (in.readByte() == 0) {
//            cloudCover = null;
//        } else {
//            cloudCover = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            uvIndex = null;
//        } else {
//            uvIndex = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            visibility = null;
//        } else {
//            visibility = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            ozone = null;
//        } else {
//            ozone = in.readDouble();
//        }
        this.time = in.readInt();
        this.summary = in.readString();
        this.icon = in.readString();
        this.precipIntensity = in.readDouble();
        this.precipProbability = in.readDouble();
        this.temperature = in.readDouble();
        this.apparentTemperature = in.readDouble();
        this.dewPoint = in.readDouble();
        this.humidity = in.readDouble();
        this.pressure = in.readDouble();
        this.windSpeed = in.readDouble();
        this.windGust = in.readDouble();
        this.windBearing = in.readInt();
        this.cloudCover = in.readDouble();
        this.uvIndex = in.readDouble();
        this.visibility = in.readDouble();
        this.ozone = in.readDouble();
    }

    public static final Creator<CurrentWeatherWrapper> CREATOR = new Creator<CurrentWeatherWrapper>() {
        @Override
        public CurrentWeatherWrapper createFromParcel(Parcel in) {
            return new CurrentWeatherWrapper(in);
        }

        @Override
        public CurrentWeatherWrapper[] newArray(int size) {
            return new CurrentWeatherWrapper[size];
        }
    };

    public CurrentWeather unwrap() {
        CurrentWeather cw = new CurrentWeather();
        cw.setTime(this.time);
        cw.setSummary(this.summary);
        cw.setIcon(this.icon);
        cw.setPrecipIntensity(this.precipIntensity);
        cw.setPrecipProbability(this.precipProbability);
        cw.setTemperature(this.temperature);
        cw.setApparentTemperature(this.apparentTemperature);
        cw.setDewPoint(this.dewPoint);
        cw.setHumidity(this.humidity);
        cw.setPressure(this.pressure);
        cw.setWindSpeed(this.windSpeed);
        cw.setWindGust(this.windGust);
        cw.setWindBearing(this.windBearing);
        cw.setCloudCover(this.cloudCover);
        cw.setUvIndex(this.uvIndex);
        cw.setVisibility(this.visibility);
        cw.setOzone(this.ozone);
        return cw;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(this.time);
        dest.writeString(this.summary);
        dest.writeString(this.icon);
        dest.writeDouble(this.precipIntensity);
        dest.writeDouble(this.precipProbability);
        dest.writeDouble(this.temperature);
        dest.writeDouble(this.apparentTemperature);
        dest.writeDouble(this.dewPoint);
        dest.writeDouble(this.humidity);
        dest.writeDouble(this.pressure);
        dest.writeDouble(this.windSpeed);
        dest.writeDouble(this.windGust);
        dest.writeInt(this.windBearing);
        dest.writeDouble(this.cloudCover);
        dest.writeDouble(this.uvIndex);
        dest.writeDouble(this.visibility);
        dest.writeDouble(this.ozone);
    }
}
