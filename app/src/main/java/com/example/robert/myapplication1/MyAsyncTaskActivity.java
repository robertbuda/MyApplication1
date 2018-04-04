package com.example.robert.myapplication1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.robert.myapplication1.async.BackgroundTaskContract;
import com.example.robert.myapplication1.async.MyAsyncTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAsyncTaskActivity extends AppCompatActivity implements BackgroundTaskContract.View{


    @BindView(R.id.progressBarAsyncTask)
    ProgressBar progressBarAsyncTask;

    @BindView(R.id.buttonStartAsyncTask)
    Button buttonStartAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_async_task);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonStartAsyncTask)
    public void startAsyncTask (){
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.setView(this);
        myAsyncTask.execute(0);
       }


    @Override
    public void showProgress(){
    progressBarAsyncTask.setVisibility(ProgressBar.VISIBLE);
       }

    @Override
    public void hideProgress(){
        progressBarAsyncTask.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void updateProgress(Integer progress){
        progressBarAsyncTask.setProgress(progress);
    }

    @Override
    public void showOutput(String output){

    }

    }
