package com.example.robert.myapplication1.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.robert.myapplication1.simpleworks.MainActivity;
import com.example.robert.myapplication1.R;


/**
 * Created by Robert on 2018-02-12.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView textViewSecond;
    private Button buttonOpenUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewSecond = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        final String textSentFromIntent = intent.getStringExtra(MainActivity.KEY_DATA);
        textViewSecond.setText(textSentFromIntent);

        buttonOpenUrl = (Button) findViewById(R.id.button2);
        buttonOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + textSentFromIntent));

                //startActivity(intent1);

                //if(textSentFromIntent.startsWith("http://" || textSentFromIntent.startsWith("https://"))

            if(intent1.resolveActivity(getPackageManager()) != null){
                startActivity(intent1);
            }

            }
        });
        }
    }

