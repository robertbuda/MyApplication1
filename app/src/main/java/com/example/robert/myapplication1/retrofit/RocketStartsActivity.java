package com.example.robert.myapplication1.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RocketStartsActivity extends AppCompatActivity implements RocketContract.View , SwipeRefreshLayout.OnRefreshListener{


    private RocketContract.Presenter presenter;
    private Context context;
    private List<Rocket> rocket;

    @BindView(R.id.rocket_starts_recycler_view)
    RecyclerView rocket_starts_recycler_view;

    @BindView(R.id.swiperefresh2) SwipeRefreshLayout swiperefresh2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activit_rocket_starts);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ROCKET_ID");

        RxJava2CallAdapterFactory rxAdapter =
                RxJava2CallAdapterFactory.createWithScheduler(io.reactivex.schedulers.Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(rxAdapter)
                .build();

        presenter = new RocketStartsPresenter(this, retrofit.create(Api.class),id);

        refreshMySwipe();
    }

    public void showData(List<Rocket> rocket){
        RocketStartsAdapter rocketAdapter = new RocketStartsAdapter(rocket,this);
        rocket_starts_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        rocket_starts_recycler_view.setAdapter(rocketAdapter);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rocket_starts_recycler_view.addItemDecoration(decoration);
    }

    @Override
    public void setButtonRocketVisible() {
    }

    @Override
    public void setProgressBarInvisible() {
    }

    public void refreshMySwipe () {
        swiperefresh2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshRocketData();
            }
        });
    }

    @Override
    public void onRefresh() {

    }
}
