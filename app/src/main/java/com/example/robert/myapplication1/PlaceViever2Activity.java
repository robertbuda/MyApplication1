package com.example.robert.myapplication1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViever2Activity extends AppCompatActivity {

    @BindView(R.id.buttonAppInfo)
    Button buttonAppInfo;

    @BindView(R.id.listViewPlaceViewer)
    ListView listViewPlaceViewer;


    private ArrayAdapter<String> adapter ;

    private ListView listView;
    private PlaceViewerAdapter placeViewerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placeviever2);
        ButterKnife.bind(this);

        /*String[] titles = new String[3];
        titles[0] = resourcesPlacViever1.getTitleRes();
        titles[1] = resourcesPlacViever2.getTitleRes();
        titles[2] = resourcesPlacViever3.getTitleRes();

        int [] photos = new int[3];
        photos[0] = resourcesPlacViever1.getImageRes();
        photos[1] = resourcesPlacViever2.getImageRes();
        photos[2] = resourcesPlacViever3.getImageRes();*/

        ResourcesPlacViever resourcesPlacViever1 = new ResourcesPlacViever(R.drawable.foto_android, "Title 1", "aaa", "123456", "23456");
        ResourcesPlacViever resourcesPlacViever2 = new ResourcesPlacViever(R.drawable.foto_android, "Title 2", "aaabbb", "12345346", "23455676");
        ResourcesPlacViever resourcesPlacViever3 = new ResourcesPlacViever(R.drawable.foto_android, "Title 3", "aaaccc", "12345656", "23453216");

        ArrayList<String> resourcesPlacVieversList = new ArrayList<>();
        resourcesPlacVieversList.add(resourcesPlacViever1.getImageRes(),resourcesPlacViever1.getTitleRes());
        resourcesPlacVieversList.add(resourcesPlacViever2.getImageRes(),resourcesPlacViever2.getTitleRes());
        resourcesPlacVieversList.add(resourcesPlacViever3.getImageRes(),resourcesPlacViever3.getTitleRes());

        adapter = new ArrayAdapter<String>(this, R.layout.text_place_row,resourcesPlacVieversList );
        listViewPlaceViewer.setAdapter(adapter);

    }

    @OnClick(R.id.buttonAppInfo)
    public void onClickButtonPlaceInfo (){
        Intent intent = new Intent(this, PlaceViever4Activity.class);
        startActivity(intent);
    }
}
