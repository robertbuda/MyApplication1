package com.example.robert.myapplication1.simpleworks;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robert.myapplication1.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Robert on 2018-02-13.
 */

public class CameraActivity extends AppCompatActivity{

    public static final int CAMERA_REQUEST = 123;
    Button cameraButton;
    ImageView cameraImage;
    public static final int CAMERA_PERMISSION_REQUEST = 666;

    @BindView(R.id.buttonShowImage)
    TextView buttonShowImage;

    private File mypath;
    private File directory;
    private File directoryImage;
    private File f;
    private Bitmap b;
    private ImageView img;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
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

                saveToInternalStorage(bitmap);
            }
        }
    }

    private void saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        mypath = new File(directory,"MyImage1.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            Toast.makeText(this,"Photo saved",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this,directory.getAbsolutePath().toString(),Toast.LENGTH_LONG).show();
        //return directory.getAbsolutePath();
    }


    @OnClick(R.id.buttonShowImage)
    public void loadImageFromStorage () {
        try {
            f = new File(directory, "MyImage1.jpg");
            b = BitmapFactory.decodeStream(new FileInputStream(f));
            img = (ImageView) findViewById(R.id.imageFromMemory);
            img.setImageBitmap(b);
            Toast.makeText(this,directory.getAbsolutePath().toString(),Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }




}
