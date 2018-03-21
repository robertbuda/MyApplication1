package com.example.robert.myapplication1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViever2Activity extends AppCompatActivity {

    @BindView(R.id.buttonAppInfo)
    Button buttonAppInfo;

    @BindView(R.id.listViewPlaceViever)
    ListView listViewPlaceViever;

    ResourcesPlacViever resourcesPlacViever1 = new ResourcesPlacViever(R.drawable.foto_android, "Title", "aaa", "123456", "23456");



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placeviever2);
        ButterKnife.bind(this);




    }

    @OnClick(R.id.buttonAppInfo)
    public void onClickButtonPlaceInfo (){
        Intent intent = new Intent(this, PlaceViever4Activity.class);
        startActivity(intent);
    }
}
