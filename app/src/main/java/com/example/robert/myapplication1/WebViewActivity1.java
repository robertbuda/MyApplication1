package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Robert on 2018-02-20.
 */

public class WebViewActivity1 extends AppCompatActivity {

    private EditText textWebView1;
    private Button buttonWebView1;
    public static final String KEY_DATA_WEB_VIEW = "key_data";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_webview1);

        textWebView1 = (EditText) findViewById(R.id.editTextWebView1);
        buttonWebView1 = (Button) findViewById(R.id.buttonWebView1);

        buttonWebView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               goToActivity2();
            }
        });
    }

    public void goToActivity2(){
        Intent intent = new Intent(this, WebViewActivity2.class);

        intent.putExtra(KEY_DATA_WEB_VIEW,textWebView1.getText().toString());
        startActivity(intent);
    }
}
