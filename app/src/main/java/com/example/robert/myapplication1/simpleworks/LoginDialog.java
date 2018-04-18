package com.example.robert.myapplication1.simpleworks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.example.robert.myapplication1.R;

/**
 * Created by Robert on 2018-03-27.
 */

public class LoginDialog extends DialogFragment {

    private OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public interface OnLoginListener {
        void onLogin (String login, String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        ConstraintLayout layout = (ConstraintLayout) layoutInflater.inflate(R.layout.activity_login_dialog, null);

        final EditText editTextLogin = layout.findViewById(R.id.editTextLogin);
        final EditText editTextPassword = layout.findViewById(R.id.editTextPassword);


        return new AlertDialog.Builder(getActivity())

                .setView(layout)
                .setCancelable(false)
                .setPositiveButton("LOGIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (onLoginListener != null){
                            onLoginListener.onLogin(editTextLogin.getText().toString(),editTextPassword.getText().toString());
                        }
                    }
                })
                .create();
    }
}
