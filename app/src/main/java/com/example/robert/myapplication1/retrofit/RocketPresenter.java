package com.example.robert.myapplication1.retrofit;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.SpaceX.CompanyInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class RocketPresenter implements RocketContract.Presenter, LifecycleObserver {

    private RocketContract.View view;
    private Api api;
    private CompanyInfo companyInfo;
    private Context context;



    public RocketPresenter(RocketContract.View view, Api api) {
        this.view = view;
        this.api = api;
        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {

        /*api.getCompanyInfo().enqueue(new Callback<CompanyInfo>() {
            @Override
            public void onResponse(Call<CompanyInfo> call, Response<CompanyInfo> response) {
            if(response.isSuccessful()) {
                companyInfo = response.body();
                Timber.e(companyInfo.getHeadquarter().getAddress());
            }
            else {
                Timber.e(response.message());
            }
            }

            @Override
            public void onFailure(Call<CompanyInfo> call, Throwable t) {
                Timber.e(t);
            }
        });*/
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
            refreshRocketData();
    }


    @Override
    public void refreshRocketData() {
        api.getRocketsInfo().enqueue(new Callback<List<Rocket>>() {
            @Override
            public void onResponse(Call<List<Rocket>> call, Response<List<Rocket>> response) {
                if (response.isSuccessful()) {
                    // todo show List<Rocket>
                    view.showData(response.body());
                    view.setProgressBarInvisible();
                    view.setButtonRocketVisible();

                } else {

                    Timber.e(response.message());
                    view.setButtonRocketVisible();
                }
            }

            @Override
            public void onFailure(Call<List<Rocket>> call, Throwable t) {
                Timber.e(t);
                view.setButtonRocketVisible();
            }
        });
    }
}


