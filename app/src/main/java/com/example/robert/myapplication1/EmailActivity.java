package com.example.robert.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Robert on 2018-02-20.
 */

public class EmailActivity extends AppCompatActivity {

    private Button buttonEMail;
    private EditText TitleEmail;
    private EditText emailAdress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_email);

        buttonEMail = (Button) findViewById(R.id.buttonEmail);
        TitleEmail = findViewById(R.id.editTitleEmail);
        emailAdress = findViewById(R.id.editAdressEmail);

        buttonEMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, TitleEmail.getText().toString());
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAdress.getText().toString()});
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_email)));
    }
}
