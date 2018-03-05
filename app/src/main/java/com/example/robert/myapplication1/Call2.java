package com.example.robert.myapplication1;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.Intent.ACTION_CALL;
import static android.content.Intent.ACTION_DIAL;

/**
 * Created by Robert on 2018-02-18.
 */

public class Call2 extends AppCompatActivity {

    private TextView textViewNumber;
    private TextView textViewCall;
    private Button buttonCallitem2;
    public static final int CALL_PERMISSION_REQUEST = 666;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_call2);

        textViewNumber = (TextView) findViewById(R.id.editTextCall2);
        buttonCallitem2 = (Button) findViewById(R.id.buttonCall2);

        Intent intent = getIntent();
        final boolean ifCheckedInCall = intent.getBooleanExtra(Call.KEY_DATA_CALL,true);

        buttonCallitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifCheckedInCall) {
                    makeCall();
                } else {
                    goToPhone();
                }
            }
        });
    }

    private void makeCall() {
        String number = textViewNumber.getText().toString();
        Uri call = Uri.parse("tel:" + number);
        Intent callNumber = new Intent(Intent.ACTION_DIAL, call);
        startActivity(callNumber);
    }

    private void goToPhone() {
        String number = textViewNumber.getText().toString();
        Uri callNumber = Uri.parse("tel:" + number);
        Intent callConfirm = new Intent(Intent.ACTION_CALL, callNumber);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(callConfirm);
        }else {
            requestCallPermission();
        }
    }

    private void requestCallPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == CALL_PERMISSION_REQUEST) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                goToPhone();
            } else {
                Toast.makeText(this, getString(R.string.permission_denied_message), Toast.LENGTH_SHORT).show();
                setPermission();
            }
        }
    }

    private void setPermission(){
        startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null)));
    }


    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            goToPhone();
        } else {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){
                Toast.makeText(this, "already ask, user denied", Toast.LENGTH_SHORT).show();
                showAlertDialogToTheUser();
                requestCallPermission();
            }else {
                Toast.makeText(this, "already ask \"dont ask again\"", Toast.LENGTH_SHORT).show();
                requestCallPermission();
            }
        }
    }


    private void showAlertDialogToTheUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo
                requestCallPermission();
            }
        });

        builder.setNegativeButton(R.string.deny, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
