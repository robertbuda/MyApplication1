package com.example.robert.myapplication1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Robert on 2018-02-28.
 */

public class BroadcastRegAppActivity extends AppCompatActivity {

    private Button buttonBroadcastToApp;
    private Button buttonBroadcastRegister;
    private BroadcastReceiver broadcastFromApp;
    private BroadcastReceiver broadcastFromAppAfterTime;
    Context context = this;
    public String nameBroadcast = "SENDING";
    private String CHANNEL_ID = "1";
    private String textTitle = "Notofication Title Vol 1";
    private String textContent = "Text in Notification vol 2";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.broadcast_receiver1);

        buttonBroadcastToApp = findViewById(R.id.buttonBroadcast);
        buttonBroadcastRegister = findViewById(R.id.buttonBroadcastRegister);

        broadcastFromApp = new MyBroadcastAppReceiver();
        IntentFilter filter = new IntentFilter("SENDING");
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastFromApp, filter);

        buttonBroadcastToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BroadcastInAppActivity.class);
                startActivity(intent);
            }
        });

        buttonBroadcastRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastFromAppAfterTime = new MyBroadcastReceiverAfterTime();
                IntentFilter filter = new IntentFilter("OPEN_AFTER_10_SECONDS");
                LocalBroadcastManager.getInstance(context).registerReceiver(broadcastFromAppAfterTime, filter);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastFromApp);
    }
}
