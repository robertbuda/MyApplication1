package com.example.robert.myapplication1.simpleworks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.retrofit.RocketContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InputLayoutActivity extends AppCompatActivity {

    @BindView(R.id.textInputUserName) TextInputEditText textInputUserName;
    @BindView(R.id.textInputPassword) TextInputEditText textInputPassword;
    @BindView(R.id.buttonTextInput) Button buttonTextInput;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);

        setTextUserName();
        setTextPassword();
    }

    private void setTextPassword() {
        textInputUserName.setError("Error");
    }

    private void setTextUserName() {

    }

    @OnClick(R.id.buttonTextInput)
    public void loginToAccount() {
        hideKeyboard();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
