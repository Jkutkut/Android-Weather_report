package com.jkutkut.android_weather_report.api;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherReport implements Parcelable {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("currently")
    @Expose
    private CurrentWeather currentWeather;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public WeatherReport() {
    }

    protected WeatherReport(Parcel in) {
        System.err.println("********* Reading parcel *********");
        System.err.println("Start pos: " + in.dataPosition());
        latitude = in.readDouble();
        System.err.println("Read latitude " + latitude);
        longitude = in.readDouble();
        timezone = in.readString();
        System.err.println("********* Reading currently");
        System.err.println("Current pos: " + in.dataPosition());
        currentWeather = in.readParcelable(CurrentWeather.class.getClassLoader());
        System.err.println("Current pos: " + in.dataPosition());
        System.err.println("********* Read currently");
        System.err.println(currentWeather);
        offset = in.readInt();
        System.err.println("Last pos: " + in.dataPosition());
        System.err.println("********* Parcel read *********");
    }

    public static final Creator<WeatherReport> CREATOR = new Creator<WeatherReport>() {
        @Override
        public WeatherReport createFromParcel(Parcel in) {
            return new WeatherReport(in);
        }

        @Override
        public WeatherReport[] newArray(int size) {
            return new WeatherReport[size];
        }
    };

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public CurrentWeather getCurrently() {
        return currentWeather;
    }

    public void setCurrently(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    // Parcelable

    @Override
    public int describeContents() {
        // Bit masks for use with describeContents(): each bit represents a kind of
        // object considered to have potential special significance when marshalled.
        return 0x0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        System.err.println("********* Writing parcel *********");
        System.err.println("Start pos: " + dest.dataPosition());
        System.out.println("Writing latitude " + this.latitude + " to parcel");
        dest.writeValue(this.latitude);
        dest.writeValue(this.longitude);
        dest.writeString(this.timezone);
        System.err.println("Current is " + ((currentWeather == null) ? "null" : "not null"));
        System.err.println("Current pos (pre current): " + dest.dataPosition());
        dest.writeParcelable(this.currentWeather, flags);
        System.err.println("Current pos (post current): " + dest.dataPosition());
        dest.writeValue(this.offset);
        System.err.println("Last pos: " + dest.dataPosition());
        System.err.println("********* Parcel written *********");
    }
}