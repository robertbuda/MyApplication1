package com.example.robert.myapplication1.retrofit;

import com.example.robert.myapplication1.SpaceX.CompanyInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.spacexdata.com/v2/";

    @GET("info")
    Call<CompanyInfo> getCompanyInfo();

    @GET("rockets")
    Call<List<Rocket>> getRocketsInfo();

}
