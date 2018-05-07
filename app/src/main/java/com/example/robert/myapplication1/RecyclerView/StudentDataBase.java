package com.example.robert.myapplication1.RecyclerView;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = StudentData.class, version = 1)
public abstract class StudentDataBase extends RoomDatabase {

    public abstract StudentDao studentDao();
}
