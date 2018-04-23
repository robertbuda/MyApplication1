package com.example.robert.myapplication1.RecyclerView;

import java.util.List;

public interface StudentsContract {

    interface View {
        void updateList(List<Student> students);
        void addStudent();
        void showFloatingButton();
        void showSnackBarInView(Student studentUndo, int positionUndo);
        void showUndoStudent(Student studentUndo, int positionUndo);
    }

    interface Presenter {
        void getData(int numStudents);
        void addOneStudent();
        void showSnackBar(Student studentUndo, int positionUndo);
        void addUndoStudent(Student studentUndo, int positionUndo);
    }

    interface AdapterInterface {
        void dataToPresenter (Student studentUndo, int positionUndo);
    }

}
