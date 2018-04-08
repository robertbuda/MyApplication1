package com.example.robert.myapplication1.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentsPresenter implements StudentsContract.Presenter {

    private StudentsContract.View view;

    public StudentsPresenter(StudentsContract.View view) {
        this.view = view;
    }

    @Override
    public void getData() {

    }
}
