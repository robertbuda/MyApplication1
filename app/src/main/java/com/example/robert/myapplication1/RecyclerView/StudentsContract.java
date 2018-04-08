package com.example.robert.myapplication1.RecyclerView;

public interface StudentsContract {

    interface View {

        void updateList();
    }

    interface Presenter {
        void getData();
    }

}
