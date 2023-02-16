package com.jkutkut.android_weather_report.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.jkutkut.android_weather_report.api.CurrentWeather;
import com.jkutkut.android_weather_report.api.WeatherReport;

public class WeatherReportWrapper implements Parcelable {
    private Double latitude;
    private Double longitude;
    private String timezone;
    private CurrentWeatherWrapper currentWeather;
    private Integer offset;

    public WeatherReportWrapper(WeatherReport wr) {
        this.latitude = wr.getLatitude();
        this.longitude = wr.getLongitude();
        this.timezone = wr.getTimezone();
        this.currentWeather = new CurrentWeatherWrapper(wr.getCurrently());
        this.offset = wr.getOffset();
    }

    protected WeatherReportWrapper(Parcel in) {
//        if (in.readByte() == 0) {
//            latitude = null;
//        } else {
//            latitude = in.readDouble();
//        }
//        if (in.readByte() == 0) {
//            longitude = null;
//        } else {
//            longitude = in.readDouble();
//        }
//        timezone = in.readString();
//        currentWeather = in.readParcelable(CurrentWeatherWrapper.class.getClassLoader());
//        if (in.readByte() == 0) {
//            offset = null;
//        } else {
//            offset = in.readInt();
//        }
        System.err.println("*************** Reading from parcel ***************");
        System.err.println("Starting pos: " + in.dataPosition());
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.timezone = in.readString();
        this.currentWeather = in.readParcelable(CurrentWeatherWrapper.class.getClassLoader());
        this.offset = in.readInt();
        System.err.println("Ending pos: " + in.dataPosition());
        System.err.println("*************** Done reading from parcel ***************");
    }

    public static final Creator<WeatherReportWrapper> CREATOR = new Creator<WeatherReportWrapper>() {
        @Override
        public WeatherReportWrapper createFromParcel(Parcel in) {
            return new WeatherReportWrapper(in);
        }

        @Override
        public WeatherReportWrapper[] newArray(int size) {
            return new WeatherReportWrapper[size];
        }
    };

    public WeatherReport unwrap() {
        WeatherReport wr = new WeatherReport();
        wr.setLatitude(this.latitude);
        wr.setLongitude(this.longitude);
        wr.setTimezone(this.timezone);
        wr.setCurrently(this.currentWeather.unwrap());
        wr.setOffset(this.offset);
        return wr;
    }

    @Override
    public int describeContents() {
        return 0x0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        System.err.println("*************** Writing to parcel ***************");
        System.err.println("Starting pos: " + dest.dataPosition());
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.timezone);
        dest.writeParcelable(this.currentWeather, flags);
        dest.writeInt(this.offset);
        System.err.println("Ending pos: " + dest.dataPosition());
        System.err.println("*************** Done writing to parcel ***************");
    }
}
