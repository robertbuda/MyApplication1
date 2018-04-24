package com.example.robert.myapplication1.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.RecyclerView.Student;
import com.example.robert.myapplication1.RecyclerView.StudentsAdapter;
import com.google.gson.Gson;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RocketActivity extends AppCompatActivity implements RocketContract.View{

    private RocketContract.Presenter presenter;

    @BindView(R.id.btRocketReset)
    Button btRocketReset;

    @BindView(R.id.progressBarRocket)
    ProgressBar progressBarRocket;

    @BindView(R.id.rocket_recycler_view)
    RecyclerView rocket_recycler_view;

    @BindView(R.id.my_toolbar) Toolbar my_toolbar;

    private CardView cardView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);
        ButterKnife.bind(this);
        cardView = (CardView) findViewById(R.id.card_view);

        showActionBar();
        startRetroFit();
    }

    public void startRetroFit () {
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(io.reactivex.schedulers.Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(rxAdapter)
                .build();
        presenter = new RocketPresenter(
                this,
                retrofit.create(Api.class)
        );
    }

    @OnClick(R.id.btRocketReset)
    public void restartGetRocket() {
        presenter.refreshRocketData();
        progressBarRocket.setVisibility(View.VISIBLE);
    }


    public void setProgressBarInvisible(){
        progressBarRocket.setVisibility(View.INVISIBLE);
    }

    public void setButtonRocketVisible(){
        btRocketReset.setVisibility(View.VISIBLE);
    }

    public void showData(List<Rocket> rocket){
        RocketAdapter rocketAdapter = new RocketAdapter(rocket,this);
        rocket_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        rocket_recycler_view.setAdapter(rocketAdapter);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rocket_recycler_view.addItemDecoration(decoration);
        rocketAdapter.updateAdapter(rocket);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    public void showActionBar () {
        setSupportActionBar(my_toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Toast.makeText(this,"SMILE !!!",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
