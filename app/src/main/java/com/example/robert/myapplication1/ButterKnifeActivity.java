package com.example.robert.myapplication1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-02-23.
 */

public class ButterKnifeActivity extends AppCompatActivity {

    @BindView(R.id.buttonButterKnifeCounter) Button buttonButterKnifeCounter;
    int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.butter_knife);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonButterKnifeCounter)
    public void countOnClick(){
        counter++;
        buttonButterKnifeCounter.setText("" + counter);
    }



}
