package com.example.robert.myapplication1.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.RecyclerView.Student;
import com.example.robert.myapplication1.RecyclerView.StudentsAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RocketActivity extends AppCompatActivity implements RocketContract.View{


    private RocketContract.Presenter presenter;
    private List <Rocket> rocket;

    @BindView(R.id.btRocketReset)
    Button btRocketReset;

    @BindView(R.id.progressBarRocket)
    ProgressBar progressBarRocket;

    @BindView(R.id.rocket_recycler_view)
    RecyclerView rocket_recycler_view;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                // set base url for every request method defined in Api.class
                .baseUrl(Api.BASE_URL)
                // add Gson converter to deserialize JSON into POJO
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                // return Retrofit instance
                .build();

        presenter = new RocketPresenter(
                this,
                // create Api interface instance
                retrofit.create(Api.class)
        );

    }

    @OnClick(R.id.btRocketReset)
    public void restartGetRocket() {
        presenter.refreshRocketData();
        progressBarRocket.setVisibility(View.VISIBLE);
    }


    public void setProgressBarInvisible(){
        progressBarRocket.setVisibility(View.GONE);
    }

    public void setButtonRocketVisible(){
        btRocketReset.setVisibility(View.VISIBLE);
    }


    public void showData(List<Rocket> body){
        rocket = body;
        RocketAdapter rocketAdapter = new RocketAdapter(rocket,this);

        rocket_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        rocket_recycler_view.setAdapter(rocketAdapter);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rocket_recycler_view.addItemDecoration(decoration);
    }

}
