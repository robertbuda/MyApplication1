package com.example.robert.myapplication1;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import timber.log.Timber;

/**
 * Created by Robert on 2018-03-07.
 */

public class SecondIntentService extends IntentService {

    public SecondIntentService() {
        super("SecondIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for (int i = 0; i < 10; i++) {

            Timber.d(String.valueOf(i+1));

            Intent intentDownload = new Intent("DOWNLOAD");
            intentDownload.putExtra("NUMBER",i+1);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intentDownload);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
