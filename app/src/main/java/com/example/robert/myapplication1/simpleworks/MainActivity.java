package com.example.robert.myapplication1.simpleworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.fragment.SecondActivity;
import com.example.robert.myapplication1.simpleworks.CameraActivity;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_DATA = "key_data";

    private Button button;
    private EditText editText;
    private Button buttonToCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Event","onCreate");

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.typeText);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              openSecondActivity();
            }
        });

        buttonToCam = (Button)findViewById(R.id.buttonToCamera);
        buttonToCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCameraActivity();
            }
        });
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(KEY_DATA,editText.getText().toString());
        startActivity(intent);
    }

    private void openCameraActivity() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Event","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Event","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Event","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Event","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Event","onDestroy");
    }

}
