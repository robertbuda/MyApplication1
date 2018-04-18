package com.example.robert.myapplication1.retrofit;

import com.example.robert.myapplication1.SpaceX.CompanyInfo;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.internal.operators.flowable.FlowableAll;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://api.spacexdata.com/v2/";

    @GET("info")
    Flowable<CompanyInfo> getCompanyInfo();

    @GET("rockets")
    Flowable<List<Rocket>> getRocketsInfo();

    @GET("launches/?launch_year=2017&rocket_id=falcon9")
    Flowable<List<Rocket>> getRocketStartsInfo();

    @GET("launches")
    Single<List<Rocket>> getAllLaunchesForRocketId(@Query("rocket_id") String rocketId);

}
