package com.example.robert.myapplication1.dagger;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.preference.PreferenceManager;

import com.example.robert.myapplication1.PrefsManager;
import com.example.robert.myapplication1.room.StudentDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    @Provides
    @Singleton
    PrefsManager providePrefsManager(Context context) {
        return new PrefsManager(context);
    }




}
