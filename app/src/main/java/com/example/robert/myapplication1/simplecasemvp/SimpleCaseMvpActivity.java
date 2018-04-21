package com.example.robert.myapplication1.simplecasemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.robert.myapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleCaseMvpActivity extends AppCompatActivity implements Contract.view {

    @BindView(R.id.buttonShowToastMvp) Button buttonShowToastMvp;
    Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new Presenter(this);

        setContentView(R.layout.activity_main_simple_case_mvp);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonShowToastMvp)
    public void clickToShowMessage () {
        presenter.clickedToastButton();
    }

    @Override
    public void showToastMessage(int position) {

        Toast toast = Toast.makeText(this,"MVP is working", Toast.LENGTH_LONG);
        toast.setGravity(position,0,0);
        toast.show();
    }
}
