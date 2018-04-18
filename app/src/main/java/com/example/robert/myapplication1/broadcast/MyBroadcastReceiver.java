package com.example.robert.myapplication1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Robert on 2018-02-27.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        String text = "Broadcast Receiver ...";

        Toast.makeText(context,text,Toast.LENGTH_LONG).show();


    }
}
