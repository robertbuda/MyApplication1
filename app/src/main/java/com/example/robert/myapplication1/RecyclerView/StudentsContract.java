package com.example.robert.myapplication1.RecyclerView;

public interface StudentsContract {

    interface View {
        void updateList();
        void showUndoCancel();
    }

    interface Presenter {
        void getData();

    }

}
