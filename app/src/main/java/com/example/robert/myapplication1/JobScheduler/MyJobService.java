package com.example.robert.myapplication1.JobScheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {


    private Disposable disposable;
    public static final int MY_JOB_ID = 1;

    @Override
    public boolean onStartJob(JobParameters params) {
        count(0,100);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
    disposable.dispose();
        return true;
    }

    private void count(Integer from , Integer to) {
        disposable = Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            Integer start = from;
            while (start <= to) {
                Timber.d(String.valueOf(start++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },
                BackpressureStrategy.BUFFER)

                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        currentProgres -> {
                // todo
                }, throwable -> {

                }, () -> {

                });

    }
}
