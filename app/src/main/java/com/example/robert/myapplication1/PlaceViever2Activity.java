package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

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

    private ArrayAdapter adapter ;
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


        ArrayList<ResourcesPlacViever> resourcesPlacVieversList = new ArrayList<>();

        /*ResourcesPlacViever resourcesPlacViever1 = new ResourcesPlacViever(R.drawable.foto_android, "Title 1");
        ResourcesPlacViever resourcesPlacViever2 = new ResourcesPlacViever(R.drawable.foto_android, "Title 2");
        ResourcesPlacViever resourcesPlacViever3 = new ResourcesPlacViever(R.drawable.foto_android, "Title 3");*/

        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 1"));
        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 2"));
        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 3"));

        placeViewerAdapter = new PlaceViewerAdapter(this,resourcesPlacVieversList );
        listViewPlaceViewer.setAdapter(placeViewerAdapter);

    }

    @OnClick(R.id.buttonAppInfo)
    public void onClickButtonPlaceInfo (){
        Intent intent = new Intent(this, PlaceViever4Activity.class);
        startActivity(intent);
    }
}
