package com.example.robert.myapplication1.JobScheduler;

import android.app.job.JobInfo;

public interface ScheduleJobContract {

    interface View {
    void scheduleJob();
    }

    interface Presenter {
        void onButtonClick();
    }

}
