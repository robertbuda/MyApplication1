package com.example.robert.myapplication1.RecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.robert.myapplication1.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MyRecyclerViewActivity extends AppCompatActivity {

@BindView(R.id.studentRecyclerView)
RecyclerView studentsRecycler;

private StudentsAdapter studentsAdapter;
private StudentsContract.Presenter presenter;

private ArrayList<Student> students;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        setupRecycler();
    }


    private void setupRecycler() {

        students = Student.createStudentList(50);
        //students.addAll(Student.createStudentList(10));
        studentsAdapter = new StudentsAdapter(students,this);

        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(studentsAdapter);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        studentsRecycler.addItemDecoration(decoration);
    }
}
