package com.example.robert.myapplication1.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(StudentData studentData);

    @Update
    void updateStudents(StudentData studentData);

    @Delete
    void delete(StudentData studentData);


    @Query("SELECT * FROM students")
    List<StudentData> getAll();

    @Query("SELECT * FROM students WHERE id IN (:studentId)")
    List<StudentData> getById(int studentId);

    @Query("SELECT * FROM students WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    StudentData findByName(String first, String last);




}
