package services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.ServiceActivity;

/**
 * Created by Robert on 2018-03-02.
 */

public class FirstIntentService extends IntentService {

    private View view;
    private String status = "";
    private int order = 0;
    private Button buttonS;

    public FirstIntentService() {
        super("FirstIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast toast = Toast.makeText(this, "START OF onCreate", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
        //status = "onCreate";
        //displayStatus();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast toast = Toast.makeText(this, "START OF onStartCommand", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        //buttonS = buttonS.findViewById(R.id.buttonStopServicee);
        //buttonS.setText("5 seconds to stop, or click now");
        //status = "onStartCommand";
        //displayStatus();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(this, "START OF onDestroy", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
        //status = "onDestroy";
        //displayStatus();
    }

    public void displayStatus(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        order++;
        String message = String.valueOf(order) + ": " + status;
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
