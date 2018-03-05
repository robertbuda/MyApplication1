package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Robert on 2018-02-18.
 */

public class StartActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_start);

        button1 = (Button) findViewById(R.id.buttonStart1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MainActivity.class);
            }
        });

        button2 = (Button) findViewById(R.id.buttonStart2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Linear.class);
            }
        });

        button3 = (Button) findViewById(R.id.buttonStart3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Relative.class);
            }
        });

        button4 = (Button) findViewById(R.id.buttonStart4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Constraint.class);
            }
        });

        button5 = (Button) findViewById(R.id.buttonStart5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Snow.class);
            }
        });

        button6 = (Button) findViewById(R.id.buttonStart6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Weather.class);
            }
        });

        button7 = (Button) findViewById(R.id.buttonStart7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Call.class);
            }
        });

        button8 = (Button) findViewById(R.id.buttonStart8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(WebViewActivity1.class);
            }
        });

        button9 = (Button) findViewById(R.id.buttonStart9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(EmailActivity.class);
            }
        });

        button10 = (Button) findViewById(R.id.buttonStart10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LifeTimeActivity.class);
            }
        });

        button11 = (Button) findViewById(R.id.buttonStart11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MenuActivity.class);
            }
        });

        button12 = (Button) findViewById(R.id.buttonStart12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ButterKnifeActivity.class);
            }
        });

        button13 = (Button) findViewById(R.id.buttonStart13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(FragmentActivity.class);
            }
        });

        button14 = (Button) findViewById(R.id.buttonStart14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(FragmentDynamicActivity.class);
            }
        });

        button15 = (Button) findViewById(R.id.buttonStart15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(BroadcastActivity.class);
            }
        });

        button16 = (Button) findViewById(R.id.buttonStart16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(BroadcastBootAvtivity.class);
            }
        });

        button17 = (Button) findViewById(R.id.buttonStart17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(BroadcastRegAppActivity.class);
            }
        });

        button18 = (Button) findViewById(R.id.buttonStart18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(NotificationActivity.class);
            }
        });

        button19 = (Button) findViewById(R.id.buttonStart19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ServiceActivity.class);
            }
        });

    }



    private void openActivity(Class class1) {
        Intent intent = new Intent(this, class1);
        startActivity(intent);
    }

}
