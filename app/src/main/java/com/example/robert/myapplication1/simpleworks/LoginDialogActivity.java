package com.example.robert.myapplication1.simpleworks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.robert.myapplication1.R;

/**
 * Created by Robert on 2018-03-27.
 */

public class LoginDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_dialog_class);

    }

    @Override
    protected void onResume() {
        super.onResume();

        LoginDialog loginDialog = new LoginDialog();
        loginDialog.setOnLoginListener(new LoginDialog.OnLoginListener() {
            @Override
            public void onLogin(String login, String password) {
                show(login, password);
            }
        });
        loginDialog.show(getFragmentManager(),"LoginDialog");

    }

    private void show(String login, String password) {
        Toast.makeText(LoginDialogActivity.this, login + ", " + password, Toast.LENGTH_SHORT).show();
    }
}
