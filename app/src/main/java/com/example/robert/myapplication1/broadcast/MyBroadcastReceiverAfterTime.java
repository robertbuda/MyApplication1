package com.example.robert.myapplication1.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.robert.myapplication1.StartActivity;

/**
 * Created by Robert on 2018-03-01.
 */

public class MyBroadcastReceiverAfterTime extends BroadcastReceiver {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    @Override
    public void onReceive(Context context, Intent intent) {

        String text = "Wait 5 SECONDS";
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();

        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        Intent intent2 = new Intent(context, StartActivity.class );
        alarmIntent = PendingIntent.getActivity(context,0, intent2,0);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5000, alarmIntent);


    }
}
