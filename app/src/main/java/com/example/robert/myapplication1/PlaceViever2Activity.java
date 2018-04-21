package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.robert.myapplication1.placeviewer.ResourcesPlacViever;
import com.example.robert.myapplication1.placeviewer.PlaceViever3Activity;
import com.example.robert.myapplication1.placeviewer.PlaceViever4Activity;
import com.example.robert.myapplication1.placeviewer.PlaceViewerAdapter;

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

    private PlaceViewerAdapter placeViewerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placeviever2);
        ButterKnife.bind(this);

        ArrayList<ResourcesPlacViever> resourcesPlacVieversList = new ArrayList<>();

        /*ResourcesPlacViever resourcesPlacViever1 = new ResourcesPlacViever(R.drawable.foto_android, "Title 1");
        ResourcesPlacViever resourcesPlacViever2 = new ResourcesPlacViever(R.drawable.foto_android, "Title 2");
        ResourcesPlacViever resourcesPlacViever3 = new ResourcesPlacViever(R.drawable.foto_android, "Title 3");*/

        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 1"));
        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 2"));
        resourcesPlacVieversList.add(new ResourcesPlacViever(R.drawable.foto_android, "Title 3"));

        placeViewerAdapter = new PlaceViewerAdapter(this,resourcesPlacVieversList );
        listViewPlaceViewer.setAdapter(placeViewerAdapter);

        Intent intent = new Intent(this, PlaceViever3Activity.class);
        listViewPlaceViewer.setOnItemClickListener((parent, view, position, id) -> goToLayout3());

    }

    private void goToLayout3() {
        Intent intent = new Intent(this, PlaceViever3Activity.class);
        Bundle b = new Bundle();
        b.putInt("FOTO", R.drawable.foto_android);
        b.putString("TITLE","Title 1");
        intent.putExtras(b);
        startActivity(intent);

    }


    @OnClick(R.id.buttonAppInfo)
    public void onClickButtonPlaceInfo (){
        Intent intent = new Intent(this, PlaceViever4Activity.class);
        startActivity(intent);
    }
}
