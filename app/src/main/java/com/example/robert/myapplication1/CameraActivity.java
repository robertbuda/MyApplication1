package com.example.robert.myapplication1;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Robert on 2018-02-13.
 */

public class CameraActivity extends AppCompatActivity{

    public static final int CAMERA_REQUEST = 123;
    Button cameraButton;
    ImageView cameraImage;
    public static final int CAMERA_PERMISSION_REQUEST = 666;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraButton = (Button) findViewById(R.id.buttonToFoto);
        cameraImage = (ImageView) findViewById(R.id.imageViewToCamera);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
                Toast.makeText(this, "already ask, user denied", Toast.LENGTH_SHORT);
                showAlertDialogToTheUser();
            }else {
                Toast.makeText(this, "already ask \"dont ask again\"", Toast.LENGTH_SHORT);
                requestCameraPermission();
            }
        }
    }

    private void goToSettingsScreen(){
        startActivity(new Intent());
    }

    private void showAlertDialogToTheUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo
                requestCameraPermission();
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

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            } else {
                Toast.makeText(this, getString(R.string.permission_denied_message), Toast.LENGTH_SHORT).show();
            }

        }
    }


    private void openCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data) {
        if (requestCode == CAMERA_REQUEST ) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap)  bundle.get("data");
                cameraImage.setImageBitmap(bitmap);
            }
        }
    }

}
