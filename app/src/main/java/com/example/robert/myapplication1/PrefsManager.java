package com.example.robert.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    private static final String PREFS_FILE_NAME = "com.sda.sdaapp.PREFS_FILE";
    private static final String STUDENTS_COUNT = "students_count";

    private SharedPreferences sharedPreferences;

    public PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveStudentsCount(int count) {
        sharedPreferences
                .edit()
                .putInt(STUDENTS_COUNT, count)
                .apply();
    }

    public int getStudentsCount() {
        return sharedPreferences.getInt(STUDENTS_COUNT, 0);
    }

}
