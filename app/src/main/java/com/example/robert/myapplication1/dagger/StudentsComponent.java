package com.example.robert.myapplication1.dagger;


import com.example.robert.myapplication1.RecyclerView.MyRecyclerViewActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {StudentsModule.class})
public interface StudentsComponent {

    void inject(MyRecyclerViewActivity myRecyclerViewActivity);
}
