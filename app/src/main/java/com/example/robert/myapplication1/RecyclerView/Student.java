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


    private static int lastStudentId = 0;

    public static ArrayList<Student> createStudentList (int numStudents) {
        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0 ; i < numStudents ; i++) {
            students.add(new Student("Student: " + ++lastStudentId , i < numStudents / 2 ));
        }
        return students;
    }

}
