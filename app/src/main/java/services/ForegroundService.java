package services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Button;

import com.example.robert.myapplication1.Call;
import com.example.robert.myapplication1.ForegroundActivity;
import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.Snow;

import timber.log.Timber;

/**
 * Created by Robert on 2018-03-09.
 */

public class ForegroundService extends Service {

    private boolean shouldRun;
    private int NOTIFICATION_CHANNEL_ID;
    private String NOTIFICATION_CHANNEL_NAME = "";

    private String CHANNEL_ID = "1";
    private String textTitle = "Notofication Title Vol 1";
    private String textContent = "Text in Notification vol 2";
    private int notificationId = 1;
    private Button buttonNotification;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        shouldRun = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        shouldRun = true;
        startCounting();
        showSimpleNotification();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startCounting(){
        HandlerThread handlerThread = new HandlerThread("Background thread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                shouldRun = true;
                int i = 1;
                while (shouldRun || i <=10){
                    Timber.d(String.valueOf(i++));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    stopSelf();
                }

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

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_call_made_black_24px)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, mBuilder.build());

        startForeground(notificationId, mBuilder.build());

    }

}
