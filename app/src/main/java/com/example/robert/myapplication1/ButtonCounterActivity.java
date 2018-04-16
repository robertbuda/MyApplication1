package com.example.robert.myapplication1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-03-13.
 */

public class ButtonCounterActivity extends AppCompatActivity {


    @BindView(R.id.textButtonCounter) TextView textButtonCounter;

    @BindView(R.id.buttonPlusCounter) Button buttonPlusCounter;

    @BindView(R.id.buttonMinusCounter) Button buttonMinusCounter;

    int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttoncounter);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonPlusCounter)
    public void countPlusOnClick(){
        counter = counter + 2;
        textButtonCounter.setText("suma: " + counter);
        buttonPlusCounter.setBackgroundColor(Color.parseColor("#fdff58"));
    }

    @OnClick(R.id.buttonMinusCounter)
    public void countMinusOnClick(){
        counter--;
        textButtonCounter.setText("suma: " + counter);
    }



}
