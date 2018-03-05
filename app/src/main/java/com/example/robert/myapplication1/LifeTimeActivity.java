package com.example.robert.myapplication1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Robert on 2018-02-21.
 */

public class LifeTimeActivity extends AppCompatActivity {


    String status = "";
    int order = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_lifetime);

        status = "onCreate";
        displayStatus();

    }

    @Override
    protected void onStart() {
        super.onStart();
        status = "onStart";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        status = "onRestoreInstanceState";
        displayStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        status = "onResume";
        displayStatus();
    }

    @Override
    protected void onPause() {
        super.onPause();
        status = "onPause";
        displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        status = "onSaveInstanceState";
        displayStatus();
    }

    @Override
    protected void onStop() {
        super.onStop();
        status = "onStop";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        status = "onRestart";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        status = "onDestroy";
        displayStatus();
    }


    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;

        //Toast toast = new Toast(this);
        //toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }




}
