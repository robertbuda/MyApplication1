package com.example.robert.myapplication1.room;

import com.example.robert.myapplication1.RecyclerView.Student;

import java.util.List;

public interface StudentsContractDao {
    interface View {
        void updateListDao(List<StudentData> students);
        void showFloatingButton();
        void showSnackBarInView(StudentData studentUndo, int positionUndo);
        void showUndoStudent();
    }

    interface Presenter {
        void getDataDao();
        void addOneStudent();
        void updateListStudent();
        void showSnackBar(StudentData studentUndo, int positionUndo);
        void addUndoStudent(StudentData studentUndo, int positionUndo);
        int showNumberStudents();
        void getNumberStudents(int numStudents);


    }

    interface AdapterInterface {
        void dataToPresenter(StudentData studentUndo, int positionUndo);
        void openEditStudent(int id);

    }

}
