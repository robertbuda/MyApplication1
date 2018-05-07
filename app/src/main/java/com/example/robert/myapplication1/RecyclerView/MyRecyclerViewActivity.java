package com.example.robert.myapplication1.RecyclerView;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
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

public class MyRecyclerViewActivity extends AppCompatActivity implements StudentsContract.View , StudentsContract.AdapterInterface{

    private StudentsContract.Presenter presenter;
    private StudentsAdapter studentsAdapter;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Context context;
    private StudentsContract.AdapterInterface adapterInterface;
    private Student studentUndoToShow;
    private int positionUndoToShow;
    private int numberOfStudent = 0;
    public static final String MY_PREFS_NAME = "MyPrefsStudents";
    private int numberOfStudentToSave;

    @BindView(R.id.studentRecyclerView)
    RecyclerView studentsRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        presenter = new StudentsPresenter(this);
        setupRecycler();
        numberOfStudent = getStudentsNumberFromSharedPreferences();
        presenter.getData(numberOfStudent);
        showFloatingButton();
    }

    public void setupRecycler() {
        studentsAdapter = new StudentsAdapter(students,this, this );
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
        studentsRecycler.scrollToPosition(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.addOneStudent();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student, menu);
        return true;
    }

    @Override
    public void showFloatingButton () {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               presenter.addOneStudent();
            }
        });
    }

    public void showSnackBarInView(Student studentUndo, int positionUndo) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Click to undo last remove", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new MyUndoStudent());
        snackbar.show();
        studentUndoToShow = studentUndo;
        positionUndoToShow = positionUndo;
    }

    @Override
    public void dataToPresenter(Student studentUndo, int positionUndo) {
        presenter.showSnackBar(studentUndo, positionUndo);
    }

    public class MyUndoStudent implements View.OnClickListener{
        @Override
        public void onClick(View v) {
        showUndoStudent();
        }
    }

    @Override
    public void showUndoStudent() {
        studentsAdapter.addUndoStudentToAdapter();
        studentsRecycler.scrollToPosition(positionUndoToShow);
    }

    @Override
    protected void onStop() {
        super.onStop();
        numberOfStudentToSave = studentsAdapter.getItemCount();
        updateStudentsNumberToSharedPreferences(numberOfStudentToSave);
    }

    public void updateStudentsNumberToSharedPreferences (int students) {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt("numberOfStudents", students);
        editor.apply();
    }

    public int getStudentsNumberFromSharedPreferences (){
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
            int studentsNumber = prefs.getInt("numberOfStudents", 0);
            return studentsNumber;
    }

    public void initiateStudentDataBase(){

        StudentDataBase db = Room.databaseBuilder(getApplicationContext(),
                StudentDataBase.class, "database-students").build();
    }
}
