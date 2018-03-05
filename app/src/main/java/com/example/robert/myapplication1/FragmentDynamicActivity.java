package com.example.robert.myapplication1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Robert on 2018-02-23.
 */

public class FragmentDynamicActivity extends AppCompatActivity {

    Button buttonClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dynamic_fragment);

        buttonClick = findViewById(R.id.buttonFragmentDynamic);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                android.support.v4.app.Fragment fragment = new android.support.v4.app.Fragment();
                fragmentTransaction.add(R.id.layoutDynamic, fragment);
                fragmentTransaction.commit();
            }
        });

    }

}
