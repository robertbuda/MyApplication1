package services;

import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.simpleworks.Snow;
import com.example.robert.myapplication1.StartActivity;

import timber.log.Timber;

/**
 * Created by Robert on 2018-03-09.
 */

public class ForegroundService extends Service {

    private boolean shouldRun = true;
    private int NOTIFICATION_CHANNEL_ID;
    private String NOTIFICATION_CHANNEL_NAME = "";

    private String CHANNEL_ID = "1";
    private String textTitle = "Notofication Title Vol 1";
    private String textContent = "Text in Notification vol 2";
    private int notificationId = 1;

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
        Timber.d("on Destroy");
        shouldRun = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.d("onStartCommand");
        startCounting();
        //showSimpleNotification();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startCounting(){
        Timber.d("startCounting");
        HandlerThread handlerThread = new HandlerThread("Background thread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (shouldRun && i <=10){
                    Timber.d(String.valueOf(i++));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                shouldRun = false;
                stopSelf();
            }
        });
    }

    private void showSimpleNotification() {
        Timber.d("showSimpleNotification");
        Intent intentNotification = new Intent(this, StartActivity.class);
        intentNotification.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentNotification, 0);

        Intent resultIntent = new Intent(this, Snow.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_call_made_black_24px)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, mBuilder.build());

        startForeground(notificationId, mBuilder.build());

    }

}
