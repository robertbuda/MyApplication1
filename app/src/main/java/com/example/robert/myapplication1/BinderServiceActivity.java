package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import services.BinderService;

/**
 * Created by Robert on 2018-03-11.
 */

public class BinderServiceActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_binderservice);
        button = (Button) findViewById(R.id.buttonStartBinderService);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyBinderService();
            }
        });


    }

    private void startMyBinderService() {
        Intent intent = new Intent(this, BinderService.class);
        startService(intent);
    }
}
