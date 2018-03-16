package com.example.robert.myapplication1;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Robert on 2018-03-13.
 */

public class SensorListActivity extends AppCompatActivity {

    @BindView(R.id.sensorList)
    LinearLayout sensorList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sensorlist);
        ButterKnife.bind(this);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (final Sensor sensor : list){
            Log.i("SensorListActivity", sensor.getName());

            Button button = new Button(getApplicationContext());
            button.setText(sensor.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SensorActivity2.class );
                    if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    }
                        intent.putExtra(SensorActivity2.NAME_EXTRA , sensor.getName());
                        startActivity(intent);

                }
            });
            sensorList.addView(button);
        }

    }
}


