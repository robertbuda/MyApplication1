package com.example.robert.myapplication1.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "students")
public class StudentData {

    @PrimaryKey(autoGenerate = true)
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentData(int id, String firstName, String lastName, boolean isDrunk, int grade, float accountVolume, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDrunk = isDrunk;
        this.grade = grade;
        this.accountVolume = accountVolume;
        this.address = address;
    }
}
