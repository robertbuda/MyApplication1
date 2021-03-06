package com.example.robert.myapplication1.retrofit;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Rocket {

    public String id;
    public String name;
    public String type;

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATE_OUTPUT = "yyyy MM dd";


    @SerializedName("payload_weights")
    @Expose
    public List<PayloadWeight> payloadWeights = new ArrayList<>();

    public List<PayloadWeight> getPayloadWeights() {
        return payloadWeights;
    }

    public String description;

    @Expose(serialize = false)
    String blebleble;

    public String launch_year;
    //public String launch_date_local;

    @SerializedName("links")
    private Link link;
    public Link getLink() {
        return link;
    }

    @SerializedName("launch_date_local")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
