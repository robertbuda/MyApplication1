package com.example.robert.myapplication1.dagger;


import com.example.robert.myapplication1.RecyclerView.MyRecyclerViewActivity;

import javax.inject.Singleton;
import dagger.Component;
import dagger.Provides;


@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    StudentsComponent plus(StudentsModule studentsModule);
}
