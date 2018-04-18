package com.example.robert.myapplication1.simpleworks;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.robert.myapplication1.R;

import services.ForegroundService;

/**
 * Created by Robert on 2018-03-09.
 */

public class ForegroundActivity extends AppCompatActivity {

    Button buttonForeground;
    Button buttonStopForeground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_foreground);

        buttonForeground = (Button) findViewById(R.id.buttonStartForegroundService);
        buttonStopForeground = (Button) findViewById(R.id.buttonStopForegroundService);

        buttonForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyForegroundService();
            }
        });

        buttonStopForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMyForegroundService();
            }
        });
    }

    public void startMyForegroundService() {
        Intent intent = new Intent(this, ForegroundService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    public void stopMyForegroundService() {
        Intent intent = new Intent(this, ForegroundService.class);
        stopService(intent);

    }



}