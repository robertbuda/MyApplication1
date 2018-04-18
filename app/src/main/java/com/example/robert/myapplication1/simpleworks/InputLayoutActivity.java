package com.example.robert.myapplication1.simpleworks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.robert.myapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputLayoutActivity extends AppCompatActivity {


    @BindView(R.id.textInputLayout)
    EditText textInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);

    }
}
