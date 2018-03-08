package com.example.robert.myapplication1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Robert on 2018-03-07.
 */

public class DownloadActivity extends AppCompatActivity {

    private Button buttonStartDownload;
    private ProgressBar progressBar;
    private BroadcastReceiver br;
    private int statusNumber;
    private int number;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_download);

        buttonStartDownload = (Button) findViewById(R.id.buttonDownload);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        br = new MyBroadcastReceiverDownload();
        IntentFilter filter = new IntentFilter("DOWNLOAD");
        LocalBroadcastManager.getInstance(this).registerReceiver(br,filter);

        buttonStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownloading();
            }
        });
    }

    /*@Override
    protected void onResume() {
        super.onResume();

        Intent intentReceive = new Intent("DOWNLOAD");
        statusNumber = (Integer) intentReceive.getExtras().getInt("NUMBER", 0);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setProgress(statusNumber);

    }*/

    public class MyBroadcastReceiverDownload extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {

            //statusNumber = (Integer) intentReceive.getExtras().getInt("NUMBER", 0);
            statusNumber = intent.getIntExtra("NUMBER", number);
            progressBar.setProgress(statusNumber);
        }
    }


    public void startDownloading(){
        Intent intent = new Intent(this, SecondIntentService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}
