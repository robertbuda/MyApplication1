package com.example.robert.myapplication1.JobScheduler;

import android.app.job.JobInfo;

public class ScheduleJobPresenter implements ScheduleJobContract.Presenter {


    private ScheduleJobContract.View view;

    ScheduleJobPresenter(ScheduleJobContract.View view) {
        this.view = view;
    }

    @Override
    public void onButtonClick(){
        view.scheduleJob();
    }
}
