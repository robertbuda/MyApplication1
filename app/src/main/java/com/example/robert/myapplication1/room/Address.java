package com.example.robert.myapplication1.room;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"city" , "street" , "number"})
public class Address {

    public String city;
    public String street;
    public int number;

}
