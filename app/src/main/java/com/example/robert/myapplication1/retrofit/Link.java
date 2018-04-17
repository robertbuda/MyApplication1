package com.example.robert.myapplication1.retrofit;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("mission_patch")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
