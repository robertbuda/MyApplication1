package com.example.robert.myapplication1.RecyclerView;

import android.content.Context;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecyclerViewActivity extends AppCompatActivity implements StudentsContract.View{

    private StudentsContract.Presenter presenter;
    private StudentsAdapter studentsAdapter;
    private ArrayList<Student> students = new ArrayList<Student>();

    @BindView(R.id.studentRecyclerView)
    RecyclerView studentsRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        presenter = new StudentsPresenter(this);
        setupRecycler();
        presenter.getData(50);
    }

    public void setupRecycler() {
        studentsAdapter = new StudentsAdapter(students,this );
        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(studentsAdapter);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        studentsRecycler.addItemDecoration(decoration);
    }

    @Override
    public void updateList(List<Student> students) {
        studentsAdapter.updateStudentsList(students);
    }

    @Override
    public void addStudent() {
        studentsAdapter.addStudentToAdapter();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        addStudent();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);
        return true;
    }



    @Override
    public void updateAdapter() {

    }




    public void showUndoCancel () {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new MyUndoListener())
                        .show();
            }
        });
    }

    public class MyUndoListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }
}
