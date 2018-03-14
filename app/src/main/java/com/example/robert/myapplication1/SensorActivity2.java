package com.example.robert.myapplication1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Robert on 2018-03-13.
 */

public class SensorActivity2 extends AppCompatActivity implements SensorEventListener {

    public static final String NAME_EXTRA = "name";

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.vendor)
    TextView vendor;

    @BindView(R.id.layoutColor)
    LinearLayout layoutColor;

    private SensorManager manager;
    private int backgroundColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

        String name = getIntent().getStringExtra(NAME_EXTRA);

        Log.i("SensorListActivity", name );

        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);
        Sensor sensor = getSensor(name, sensorList);

        if(sensor == null) {
            return;
        }

        setInfo(sensor);

        manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        manager.unregisterListener(this);
    }


    private Sensor getSensor(String name, List<Sensor> sensorList) {
        for(Sensor sensor : sensorList) {
            if(name.equals(sensor.getName())) {
                return sensor;
            }
        }

        return null;
    }

    private void setInfo(Sensor sensor) {
        name.setText(sensor.getName());
        vendor.setText(sensor.getVendor());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       Timber.d("SensorActivity accuracy: " + sensorEvent.accuracy);

        StringBuilder data = new StringBuilder();
        for(float value : sensorEvent.values) {
            data.append(value).append(" ");
        }

        Log.i("SensorActivity", "data: " + data.toString());

        if( sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            double x = sensorEvent.values[0];

            x = x/156;
            
            int a = (int) x;
            layoutColor.setBackgroundColor(Color.rgb(255,255,a));
        }

        //layoutColor.setBackgroundColor(Color.parseColor("#FFFF00"));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
