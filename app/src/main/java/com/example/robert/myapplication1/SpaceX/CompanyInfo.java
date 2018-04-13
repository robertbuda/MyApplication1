package com.example.robert.myapplication1.SpaceX;

import android.support.v7.app.AppCompatActivity;

import com.example.robert.myapplication1.retrofit.Headquarter;
import com.google.gson.annotations.SerializedName;

public class CompanyInfo extends AppCompatActivity {


    String name;
    String founder;
    int employees;
    int vehicles;
    @SerializedName("launch_sites")
    int launchSites;
    @SerializedName("headquarters")
    Headquarter headquarter;
    String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    public int getLaunchSites() {
        return launchSites;
    }

    public void setLaunchSites(int launchSites) {
        this.launchSites = launchSites;
    }

    public Headquarter getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(Headquarter headquarter) {
        this.headquarter = headquarter;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
