package com.example.robert.myapplication1;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import services.FirstIntentService;

/**
 * Created by Robert on 2018-03-02.
 */

public class ServiceActivity extends AppCompatActivity {

    private Button buttonService;
    private Button buttonStopService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service);
        buttonService = findViewById(R.id.buttonService);
        buttonStopService = findViewById(R.id.buttonStopServicee);


        buttonService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });

        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
            }
        });
    }

    public void startService(){
        Intent intent = new Intent(this, FirstIntentService.class);
        startService(intent);
    }

    public void stopService(){
        Intent intent = new Intent(this, FirstIntentService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
