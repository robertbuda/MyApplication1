package com.example.robert.myapplication1.room;

import java.util.ArrayList;

public class StudentsPresenterDao implements StudentsContractDao.Presenter {

    private StudentsContractDao.View view;
    private ArrayList<StudentData> students = new ArrayList<StudentData>();
    private int lastStudentId = 0;
    private StudentDao studentDao;

    public StudentsPresenterDao(StudentsContractDao.View view) {
        this.view = view;
    }


    @Override
    public void getData(int numStudents) {
            for (int i = 0 ; i < numStudents ; i++) {
                students.add(new StudentData());
            }
            view.updateListDao(students);
    }

    @Override
    public void addOneStudent() {
        studentDao = RoomDataBaseActivity.db.studentDao();
        studentDao.insertStudent(new StudentData());
        view.addStudent();

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
