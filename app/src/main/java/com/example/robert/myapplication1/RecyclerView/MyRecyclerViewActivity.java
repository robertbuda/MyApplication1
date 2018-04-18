package com.example.robert.myapplication1.RecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student.createStudentList(1);
                studentsAdapter.notifyItemInserted(0);
                studentsAdapter.notifyItemRangeChanged(0,studentsAdapter.getItemCount());
                studentsRecycler.scrollToPosition(0);
            }
        });

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Student.createStudentList(1);
        studentsAdapter.notifyItemInserted(0);
        studentsAdapter.notifyItemRangeChanged(0,studentsAdapter.getItemCount());
        studentsRecycler.scrollToPosition(0);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);

        return true;
    }


}
