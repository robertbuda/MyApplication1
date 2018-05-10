package com.example.robert.myapplication1.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.robert.myapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentDataBaseActivity extends AppCompatActivity {


    @BindView(R.id.etStudentName)
    EditText etStudentName;

    @BindView(R.id.btSaveStudent)
    Button btSaveStudent;

    private String firstName;
    private int id;
    private StudentData studentData;
    private StudentDao studentDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database_student);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("Student_ID", 0);

        studentData = RoomDataBaseActivity.db.studentDao().getById(id);
        etStudentName.setText(studentData.firstName);

    }

    @OnClick(R.id.btSaveStudent)
    public void goToMainList() {

        studentData = RoomDataBaseActivity.db.studentDao().getById(id);
        studentDao = RoomDataBaseActivity.db.studentDao();

        firstName = etStudentName.getText().toString();
        studentData.setFirstName(firstName);
        studentDao.updateStudents(studentData);

        Intent intent = new Intent(this,RoomDataBaseActivity.class);
        startActivity(intent);
    }
}
