package com.example.agroclinic.loginActivities.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class HomeDataModel implements Parcelable {
    String imgUrl;
    String cropDesc;

    public HomeDataModel(String imgUrl, String cropDesc){
        this.imgUrl=imgUrl;
        this.cropDesc=cropDesc;
    }

    protected HomeDataModel(Parcel in) {
        imgUrl = in.readString();
        cropDesc = in.readString();
    }

    public static final Creator<HomeDataModel> CREATOR = new Creator<HomeDataModel>() {
        @Override
        public HomeDataModel createFromParcel(Parcel in) {
            return new HomeDataModel(in);
        }

        @Override
        public HomeDataModel[] newArray(int size) {
            return new HomeDataModel[size];
        }
    };

    public String getImgUrl(){
        return imgUrl;

    }
    public void setImgUrl(String imgUrl) {

        this.imgUrl = imgUrl;
    }

    public String getCropDesc(){
        return cropDesc;
    }

    public void setCropDesc(String cropDesc) {
        this.cropDesc = cropDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(imgUrl);
        dest.writeString(cropDesc);
    }
}
