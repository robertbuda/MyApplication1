package com.example.robert.myapplication1;

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
 * Created by Robert on 2018-03-15.
 */

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.buttonSendMessage) Button buttonSendMessage;
    @BindView(R.id.messageText) EditText messageText;
    @BindView(R.id.numberText) EditText numberText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSendMessage)
    public void sendOnClick(){
        Toast.makeText(this,"SEND",Toast.LENGTH_LONG).show();
    }

}
