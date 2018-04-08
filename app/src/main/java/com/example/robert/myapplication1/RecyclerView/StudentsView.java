package com.example.robert.myapplication1.RecyclerView;

public class StudentsView implements StudentsContract.Presenter {

    private StudentsContract.Presenter presenter;

    public StudentsView(StudentsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData() {

    }
}
