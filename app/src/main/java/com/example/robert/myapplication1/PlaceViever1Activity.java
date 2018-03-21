package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViever1Activity extends AppCompatActivity {

    @BindView(R.id.buttonPlaceViever)
    Button buttonPlaceViever;

    @BindView(R.id.Login)
    EditText Login;

    @BindView(R.id.Password)
    EditText Password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placeviever1);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonPlaceViever)
    public void onClickButtonPlaceViever() {
        Intent intent = new Intent(this, PlaceViever2Activity.class);
        if (!Login.getText().toString().isEmpty() && !Password.getText().toString().isEmpty()) {
            startActivity(intent);
        } else {
            Toast.makeText(this,"Wal sie",Toast.LENGTH_SHORT).show();
        }

    }
}
