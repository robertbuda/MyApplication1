package com.example.robert.myapplication1.simpleworks;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.simpleworks.Call;
import com.example.robert.myapplication1.simpleworks.Snow;

/**
 * Created by Robert on 2018-03-02.
 */

public class NotificationActivity extends AppCompatActivity {

    private String CHANNEL_ID = "1";
    private String textTitle = "Notofication Title Vol 1";
    private String textContent = "Text in Notification vol 2";
    private int notificationId = 1;
    private Button buttonNotification;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification);

        buttonNotification = (Button) findViewById(R.id.buttonNotofication);

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleNotification();
            }
        });
    }

    private void showSimpleNotification() {

        Intent intent = new Intent(this, Call.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent resultIntent = new Intent(this, Snow.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_call_made_black_24px)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_tag_faces_black_24px, getString(R.string.dalej),resultPendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, mBuilder.build());

    }

}
