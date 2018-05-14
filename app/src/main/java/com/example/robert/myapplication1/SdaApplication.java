package com.example.robert.myapplication1;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.robert.myapplication1.dagger.AppComponent;
import com.example.robert.myapplication1.dagger.AppModule;
import com.example.robert.myapplication1.dagger.DaggerAppComponent;
import com.example.robert.myapplication1.dagger.DataModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class SdaApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + " *** " + element.getLineNumber();
                }
            });
        }

        // Room
        /*database = Room.databaseBuilder(this, SdaDatabase.class, "sda-room-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();*/

        // Realm
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        // Dager 2
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

   /* public static SdaDatabase getRoom() {
        return database;
    }*/
}

