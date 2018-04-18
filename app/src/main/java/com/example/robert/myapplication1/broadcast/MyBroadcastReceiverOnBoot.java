package com.example.robert.myapplication1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.robert.myapplication1.StartActivity;

/**
 * Created by Robert on 2018-02-28.
 */

public class MyBroadcastReceiverOnBoot extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiverOnBoot";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentBoot = new Intent(context, StartActivity.class);
        context.startActivity(intentBoot);

    }
}
