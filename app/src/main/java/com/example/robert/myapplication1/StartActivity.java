package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.robert.myapplication1.JobScheduler.ScheduleJobActivity;
import com.example.robert.myapplication1.RecyclerView.MyRecyclerViewActivity;
import com.example.robert.myapplication1.SpaceX.SpaceXActivity;
import com.example.robert.myapplication1.broadcast.BroadcastActivity;
import com.example.robert.myapplication1.broadcast.BroadcastBootAvtivity;
import com.example.robert.myapplication1.broadcast.BroadcastRegAppActivity;
import com.example.robert.myapplication1.fragment.FragmentActivity;
import com.example.robert.myapplication1.fragment.FragmentDynamicActivity;
import com.example.robert.myapplication1.navigationdrawer.DrawerActivity;
import com.example.robert.myapplication1.retrofit.RocketActivity;
import com.example.robert.myapplication1.simplecasemvp.SimpleCaseMvpActivity;
import com.example.robert.myapplication1.simpleworks.Call;
import com.example.robert.myapplication1.simpleworks.Constraint;
import com.example.robert.myapplication1.simpleworks.DownloadActivity;
import com.example.robert.myapplication1.simpleworks.EmailActivity;
import com.example.robert.myapplication1.simpleworks.ForegroundActivity;
import com.example.robert.myapplication1.simpleworks.InputLayoutActivity;
import com.example.robert.myapplication1.simpleworks.LifeTimeActivity;
import com.example.robert.myapplication1.simpleworks.Linear;
import com.example.robert.myapplication1.simpleworks.LoginDialogActivity;
import com.example.robert.myapplication1.simpleworks.MainActivity;
import com.example.robert.myapplication1.simpleworks.NotificationActivity;
import com.example.robert.myapplication1.simpleworks.PagesActivity;
import com.example.robert.myapplication1.simpleworks.RectangleDrawActivity;
import com.example.robert.myapplication1.simpleworks.Relative;
import com.example.robert.myapplication1.simpleworks.Snow;
import com.example.robert.myapplication1.simpleworks.Weather;
import com.example.robert.myapplication1.simpleworks.WebViewActivity1;

import fragments.MyPagerAdapter;

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
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button button37;
    private Button button38;
    private Button button39;
    private Button button40;

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

        button20 = (Button) findViewById(R.id.buttonStart20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(DownloadActivity.class);
            }
        });

        button21 = (Button) findViewById(R.id.buttonStart21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(DownloadActivity.class);
            }
        });

        button22 = (Button) findViewById(R.id.buttonStart22);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ForegroundActivity.class);
            }
        });

        button23 = (Button) findViewById(R.id.buttonStart23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(BinderServiceActivity.class);
            }
        });

        button24 = (Button) findViewById(R.id.buttonStart24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ButtonCounterActivity.class);
            }
        });

        button25 = (Button) findViewById(R.id.buttonStart25);
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SensorListActivity.class);
            }
        });

        button26 = (Button) findViewById(R.id.buttonStart26);
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(CalculatorActivity.class);
            }
        });

        button27 = (Button) findViewById(R.id.buttonStart27);
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MessageActivity.class);
            }
        });

        button28 = (Button) findViewById(R.id.buttonStart28);
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LocationActivity.class);
            }
        });

        button29 = (Button) findViewById(R.id.buttonStart29);
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PlaceViever1Activity.class);
            }
        });

        button30 = (Button) findViewById(R.id.buttonStart30);
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RectangleDrawActivity.class);
            }
        });

        button31 = (Button) findViewById(R.id.buttonStart31);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LoginDialogActivity.class);
            }
        });

        button32 = (Button) findViewById(R.id.buttonStart32);
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MyAsyncTaskActivity.class);
            }
        });

        button33 = (Button) findViewById(R.id.buttonStart33);
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ScheduleJobActivity.class);
            }
        });

        button34 = (Button) findViewById(R.id.buttonStart34);
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(MyRecyclerViewActivity.class);
            }
        });

        button35 = (Button) findViewById(R.id.buttonStart35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SpaceXActivity.class);
            }
        });

        button36 = (Button) findViewById(R.id.buttonStart36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RocketActivity.class);
            }
        });

        button37 = (Button) findViewById(R.id.buttonStart37);
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(InputLayoutActivity.class);
            }
        });

        button38 = (Button) findViewById(R.id.buttonStart38);
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SimpleCaseMvpActivity.class);
            }
        });

        button39 = (Button) findViewById(R.id.buttonStart39);
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PagesActivity.class);
            }
        });

        button40 = (Button) findViewById(R.id.buttonStart40);
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(DrawerActivity.class);
            }
        });

    }



    private void openActivity(Class class1) {
        Intent intent = new Intent(this, class1);
        startActivity(intent);
    }

}
