package com.example.robert.myapplication1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-03-14.
 */

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.buttonPlus)
    Button buttonPlus;

    @BindView(R.id.buttonMinus)
    Button buttonMinus;

    @BindView(R.id.textResult)
    TextView textResult;

    @BindView(R.id.editText1)
    EditText editText1;

    @BindView(R.id.editText2)
    EditText editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonPlus)
    void plus() {

        if (!editText1.getText().toString().isEmpty() && !editText2.getText().toString().isEmpty()) {
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            textResult.setText("" + (num1 + num2));
        } else {
            textResult.setText("0");
        }
    }
}