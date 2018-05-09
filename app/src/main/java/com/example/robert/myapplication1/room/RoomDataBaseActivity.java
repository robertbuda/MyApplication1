package com.example.robert.myapplication1.room;

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
import com.example.robert.myapplication1.RecyclerView.Student;
import com.example.robert.myapplication1.RecyclerView.StudentsAdapter;
import com.example.robert.myapplication1.RecyclerView.StudentsContract;
import com.example.robert.myapplication1.RecyclerView.StudentsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomDataBaseActivity extends AppCompatActivity implements StudentsContractDao.View , StudentsContractDao.AdapterInterface{

    private StudentsContractDao.Presenter presenter;
    private StudentsAdapterDao studentsAdapter;
    private ArrayList<StudentData> students = new ArrayList<StudentData>();
    private Context context;
    private StudentsContractDao.AdapterInterface adapterInterface;
    private StudentData studentUndoToShow;
    private int positionUndoToShow;
    private int numberOfStudent = 0;
    public static final String MY_PREFS_NAME = "MyPrefsStudents";
    private StudentData studentData;
    public static StudentDataBase db;

    @BindView(R.id.studentRecyclerView)
    RecyclerView studentsRecycler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        presenter = new StudentsPresenterDao(this);
        setupRecycler();
        setRoomDataBase();
        //numberOfStudent = db.studentDao().getAll().size();
        presenter.getDataDao();
        showFloatingButton();
    }

    public void setupRecycler() {
        studentsAdapter = new StudentsAdapterDao(students,this, this );
        studentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        studentsRecycler.setAdapter(studentsAdapter);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        studentsRecycler.addItemDecoration(decoration);
    }

    @Override
    public void updateListDao(List<StudentData> students) {
        studentsAdapter.updateStudentsListDao(students);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //presenter.addOneStudent();
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

    public void showSnackBarInView(StudentData studentUndo, int positionUndo) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Click to undo last remove", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new MyUndoStudent());
        snackbar.show();
        studentUndoToShow = studentUndo;
        positionUndoToShow = positionUndo;
    }

    @Override
    public void dataToPresenter(StudentData studentUndo, int positionUndo) {
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
        presenter.updateListStudent();
    }

    public void setRoomDataBase(){
        db = Room.databaseBuilder(getApplicationContext(),StudentDataBase.class, "database-student")
                .allowMainThreadQueries()
                .build();
    }
}
