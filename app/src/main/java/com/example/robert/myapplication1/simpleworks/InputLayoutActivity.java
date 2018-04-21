package com.example.robert.myapplication1.simpleworks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.retrofit.RocketContract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InputLayoutActivity extends AppCompatActivity {

    @BindView(R.id.textInputUserName) TextInputEditText textInputUserName;
    @BindView(R.id.textInputPassword) TextInputEditText textInputPassword;
    @BindView(R.id.buttonTextInput) Button buttonTextInput;

    @BindView(R.id.tilPassword) TextInputLayout tilPassword;

    private Snackbar snackbar;
    private String bufforLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);

        snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Wait one moment ...",
                Snackbar.LENGTH_LONG);
        snackbar.setAction("CLEAR LOGIN AND PASSWORD", new MyUndoListener());
        snackbar.show();
    }


    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@+[a-zA-Z0-9-]+.+[a-zA-Z0-9-]";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() < 20 && password.length() > 0;
    }


    @OnClick(R.id.buttonTextInput)
    public void loginToAccount() {
        hideKeyboard();
        snackbar.show();
        String username = textInputUserName.getText().toString();
        String password = textInputPassword.getText().toString();
        if (!validateEmail(username) || username == null) {
            textInputUserName.setError("Not a valid email address!");
        } else if (!validatePassword(password) || password == null) {
            textInputPassword.setError("Not a valid password, min. 6 charakters!");
        } else {
            // TODO login
            bufforLogin = username;
            Toast.makeText(this,"Wait to login ...",Toast.LENGTH_LONG).show();
        }

    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public class MyUndoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            textInputUserName.setText("");
            textInputPassword.setText("");
            }
    }


}
