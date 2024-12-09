package com.example.agroclinic.loginActivities.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class CropsDataModel implements Parcelable {
    String imageUrl;
    String title;

    public CropsDataModel(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    protected CropsDataModel(Parcel in) {
        imageUrl = in.readString();
        title = in.readString();
    }

    public static final Creator<CropsDataModel> CREATOR = new Creator<CropsDataModel>() {
        @Override
        public CropsDataModel createFromParcel(Parcel in) {
            return new CropsDataModel(in);
        }

        @Override
        public CropsDataModel[] newArray(int size) {
            return new CropsDataModel[size];
        }
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(title);
    }
}
