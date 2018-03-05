package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Robert on 2018-02-18.
 */

public class Call extends AppCompatActivity {

    private Button buttonCall1;
    private CheckBox checkBox;

    public static final String KEY_DATA_CALL = "true";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_call1);

        checkBox = (CheckBox) findViewById(R.id.checkBoxPhone1);
        buttonCall1 = (Button) findViewById(R.id.buttonPhone1);

        buttonCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCall2();
            }
        });
    }

    private void openCall2() {
        Intent intent = new Intent(this, Call2.class);
        intent.putExtra(KEY_DATA_CALL, checkBox.isChecked());
        startActivity(intent);
    }
}
