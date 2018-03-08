package com.example.robert.myapplication1;

import android.app.Application;

import java.util.TreeSet;

import timber.log.Timber;


/**
 * Created by Robert on 2018-03-07.
 */

public class SdaApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            Timber.plant(new MyDebugTree());
        }
    }
}
