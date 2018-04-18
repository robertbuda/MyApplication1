package com.example.robert.myapplication1.retrofit;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class RocketStartsPresenter implements RocketContract.Presenter, LifecycleObserver {

    private RocketContract.View view;
    private Api api;
    private String id;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RocketStartsPresenter(RocketContract.View view, Api api, String id) {
        this.view = view;
        this.api = api;
        this.id = id;
        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
       refreshRocketData();
    }

    public void refreshRocketData () {
        compositeDisposable.add(
                api.getAllLaunchesForRocketId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        launches -> view.showData(launches),
                        throwable -> Timber.e(throwable)
                        ));
    }
}
