package com.example.robert.myapplication1.SpaceX;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.async.MyAsyncTask;

public class SpaceXActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spacex);

        GetCompanyInfoTask getCompanyInfoTask = new GetCompanyInfoTask();
        getCompanyInfoTask.execute(SpacexAPI.COMPANY_INFO);

    }
}
