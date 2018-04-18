package com.example.robert.myapplication1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.robert.myapplication1.R;

/**
 * Created by Robert on 2018-02-27.
 */

public class BroadcastActivity extends AppCompatActivity {

    private Button buttonBroadcast;
    private BroadcastReceiver br;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_receiver1);
        buttonBroadcast = findViewById(R.id.buttonBroadcast);

        br = new MyBroadcastReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(br, filter);

            }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}


