package com.example.robert.myapplication1.JobScheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.robert.myapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleJobActivity extends AppCompatActivity implements ScheduleJobContract.View{


    @BindView(R.id.progressBarJobService)
    ProgressBar progressBarJobService;

    @BindView(R.id.buttonStartJobService)
    Button buttonStartJobService;

    private ScheduleJobContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jobservice);
        ButterKnife.bind(this);
        presenter = new ScheduleJobPresenter(this);
    }


    @OnClick(R.id.buttonStartJobService)
    public void startJobService () {
        presenter.onButtonClick();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void scheduleJob() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if(jobScheduler != null) {
            jobScheduler.schedule(new JobInfo.Builder(
                    MyJobService.MY_JOB_ID,new ComponentName(this,MyJobService.class))
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresCharging(false)
                    .build()
            );
        }

    }
}
