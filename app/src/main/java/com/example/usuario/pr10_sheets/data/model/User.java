package com.example.usuario.pr10_sheets.data.model;

import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable {
    private String name;
    private String phone;
    private String imageURL;
    private String url;

    public User() {
    }

    public User(String name, String phone, String imageURL, String url) {
        this.name = name;
        this.phone = phone;
        this.imageURL = imageURL;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.imageURL);
        dest.writeString(this.url);
    }


    protected User(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
        this.imageURL = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
