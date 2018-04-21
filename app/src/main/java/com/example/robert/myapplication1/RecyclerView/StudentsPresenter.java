package com.example.robert.myapplication1.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.robert.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsPresenter implements StudentsContract.Presenter {

    private StudentsContract.View view;
    private ArrayList<Student> students = new ArrayList<Student>();


    public StudentsPresenter(StudentsContract.View view) {
        this.view = view;
    }

    private int lastStudentId = 0;

    @Override
    public void getData(int numStudents) {
            for (int i = 0 ; i < numStudents ; i++) {
                students.add(new Student("Student: " + ++lastStudentId , i < numStudents / 2 ));
            }
            view.updateList(students);
    }




}
