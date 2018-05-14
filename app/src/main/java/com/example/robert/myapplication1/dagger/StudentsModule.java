package com.example.robert.myapplication1.dagger;


import com.example.robert.myapplication1.PrefsManager;
import com.example.robert.myapplication1.RecyclerView.StudentsContract;
import com.example.robert.myapplication1.RecyclerView.StudentsPresenter;
import com.example.robert.myapplication1.room.StudentDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentsModule {

    private StudentsContract.View view;

    public StudentsModule (StudentsContract.View view) { this.view = view;}


    @Provides
    @Singleton
    StudentsContract.Presenter provideStudentsPresenter (){
        return new StudentsPresenter(view);
    }
}
