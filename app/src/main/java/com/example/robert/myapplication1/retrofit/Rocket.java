package com.example.robert.myapplication1.retrofit;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

    public String id;
    public String name;
    public String type;
    @SerializedName("payload_weights")
    @Expose
    public List<PayloadWeight> payloadWeights = new ArrayList<>();

    public List<PayloadWeight> getPayloadWeights() {
        return payloadWeights;
    }

    public String description;

    @Expose(serialize = false)
    String blebleble;

    @Override
    public String toString() {
        return "Rocket{" +
                "payloadWeights=" + payloadWeights +
                '}';
    }
}
