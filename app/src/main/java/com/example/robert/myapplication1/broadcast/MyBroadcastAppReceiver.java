package com.example.robert.myapplication1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Robert on 2018-02-28.
 */

public class MyBroadcastAppReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String text = "Broadcast in App Register and Receiver";

        Toast.makeText(context, text, Toast.LENGTH_LONG).show();

    }
}