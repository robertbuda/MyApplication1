package services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Robert on 2018-03-02.
 */

public class FirstIntentService extends IntentService {


    private String status = "";
    private int order = 0;

    public FirstIntentService() {
        super("FirstIntentService");
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        status = "onHandleIntent";
        displayStatus();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        status = "onBind";
        displayStatus();
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        status = "onCreate";
        displayStatus();
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        status = "onStartCommand";
        displayStatus();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = "onDestroy";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
