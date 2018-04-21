package com.example.robert.myapplication1.RecyclerView;

import java.util.List;

public interface StudentsContract {

    interface View {
        void updateAdapter();
        void updateList(List<Student> students);
        void addStudent();
        void showUndoCancel();
    }

    interface Presenter {
        void getData(int numStudents);

    }

}
