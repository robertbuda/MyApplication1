package com.example.robert.myapplication1.room;

import java.util.ArrayList;
import java.util.List;

public class StudentsPresenterDao implements StudentsContractDao.Presenter {

    private StudentsContractDao.View view;
    private ArrayList<StudentData> students = new ArrayList<StudentData>();
    private StudentDao studentDao;


    public StudentsPresenterDao(StudentsContractDao.View view) {
        this.view = view;
    }


    @Override
    public void getDataDao() {
        studentDao = RoomDataBaseActivity.db.studentDao();
        view.updateListDao(studentDao.getAll());
    }

    @Override
    public void addOneStudent() {
        StudentData studentData = new StudentData();
        studentDao = RoomDataBaseActivity.db.studentDao();
        studentDao.insertStudent(studentData);
        view.updateListDao(studentDao.getAll());

    }

    @Override
    public void updateListStudent() {
        view.updateListDao(studentDao.getAll());
    }

    @Override
    public void showSnackBar(StudentData studentUndo, int positionUndo) {
        view.showSnackBarInView(studentUndo,positionUndo);
    }

    @Override
    public void addUndoStudent(StudentData studentUndo, int positionUndo) {
    }

    @Override
    public int showNumberStudents() {
        return 0;
    }

    @Override
    public void getNumberStudents(int numStudents) {

    }



}
