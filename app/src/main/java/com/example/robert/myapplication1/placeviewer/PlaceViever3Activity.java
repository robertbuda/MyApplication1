package com.example.robert.myapplication1.placeviewer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robert.myapplication1.R;
import com.google.android.gms.maps.GoogleMap;

import butterknife.BindView;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViever3Activity extends AppCompatActivity {

    private GoogleMap mMap;
    private int fotoId;
    private String title;
    private Intent data;

    /*@BindView(R.id.imageViewPlace3)
    ImageView imageViewPlace3;*/

    /*@BindView(R.id.textViewlayout3)
    TextView textViewlayout3;*/

    ImageView imageView;

    TextView textView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placeviever3);

        setImage();
    }


    public void setImage(){

        Bundle bundle = getIntent().getExtras();
        Integer bitmap = bundle.getInt("FOTO");
        String bitmap1 = bundle.getString("TITLE");

        imageView = (ImageView) findViewById(R.id.imageViewPlace3);
        imageView.setImageResource(bitmap);

        textView = (TextView) findViewById(R.id.textViewlayout3);
        textView.setText(bitmap1);

        //imageViewPlace3.setImageResource(bitmap);

    }

}
