package com.example.robert.myapplication1.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.robert.myapplication1.room.StudentDao;
import com.example.robert.myapplication1.room.StudentData;


@Database(entities = StudentData.class, version = 1)
public abstract class StudentDataBase extends RoomDatabase {

    public abstract StudentDao studentDao();
}
