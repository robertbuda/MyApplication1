package com.example.robert.myapplication1.RecyclerView;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "students")
public class StudentData {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "is_drunk")
    public boolean isDrunk;

    @ColumnInfo(name = "grade_year")
    public int grade;

    @ColumnInfo(name = "account_volume")
    public float accountVolume;

    @Embedded
    public Address address;

}
