package com.example.robert.myapplication1.RecyclerView;

import java.util.ArrayList;


public class Student {

    private String studentName;
    private boolean isGraduated;

    public Student(String studentName, boolean isGraduated) {
        this.studentName = studentName;
        this.isGraduated = isGraduated;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

}
