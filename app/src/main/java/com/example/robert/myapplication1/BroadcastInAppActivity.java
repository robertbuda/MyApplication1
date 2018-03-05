package com.example.robert.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Robert on 2018-02-28.
 */

public class BroadcastInAppActivity extends AppCompatActivity {

    private Button buttonBroadcastSender;
    private Button buttonBroadcastSenderAfterTime;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_broadcast_sender);

        buttonBroadcastSender = findViewById(R.id.buttonBroadcastSender);
        buttonBroadcastSenderAfterTime = findViewById(R.id.buttonBroadcastAfterTime);

        buttonBroadcastSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("SENDING");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

            }
        });

        buttonBroadcastSenderAfterTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("OPEN_AFTER_10_SECONDS");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

            }
        });





    }







}
