package com.example.robert.myapplication1.room;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robert.myapplication1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsAdapterDao extends Adapter<StudentsAdapterDao.StudentsHolder> {

    private Context context;
    private List<StudentData> studentList = new ArrayList<>();
    private StudentsContractDao.AdapterInterface adapterInterface;


    public StudentsAdapterDao(List<StudentData> studentList, Context context, StudentsContractDao.AdapterInterface adapterInterface) {
        this.studentList = studentList;
        this.context = context;
        this.adapterInterface = adapterInterface;
    }

    public Context getContext() {
        return context;
    }

    public class StudentsHolder extends RecyclerView.ViewHolder {

        public TextView student_name;
        public Button student_button;
        public ImageView student_remove_icon;

        private int selectedPosition = -1;
        private HashMap hashMap = new HashMap();
        private int i = 0;

        public StudentsHolder(View studentsHolderView) {
            super(studentsHolderView);

            student_name = (TextView) itemView.findViewById(R.id.student_name);
            student_button = (Button) itemView.findViewById(R.id.student_button);
            student_remove_icon = (ImageView) itemView.findViewById(R.id.student_remove_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (hashMap.containsValue(selectedPosition)) {
                        itemView.setBackgroundColor(Color.parseColor("#ffffff"));
                        notifyItemChanged(selectedPosition);
                        Toast.makeText(context, "" + selectedPosition, Toast.LENGTH_LONG).show();
                    } else {
                        itemView.setBackgroundColor(Color.parseColor("#fdd835"));
                        hashMap.put(i, selectedPosition);
                        i++;
                        notifyItemChanged(selectedPosition);
                        Toast.makeText(context, "" + selectedPosition, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public StudentsAdapterDao.StudentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View studentsHolderView = layoutInflater.inflate(R.layout.item_student, parent, false);
        StudentsHolder studentsHolder = new StudentsHolder(studentsHolderView);

        return studentsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapterDao.StudentsHolder holder, int position) {
        StudentData student = studentList.get(position);

        TextView textView = holder.student_name;
        textView.setText("" + student.id);

        Button button = holder.student_button;
        button.setText(student.isDrunk ? "DRUNK" : "SOBER");
        button.setEnabled(student.isDrunk);

        ImageView imageView = holder.student_remove_icon;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               removeStudent(position);
            }});
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    private StudentData studentUndo;
    private int positionUndo;

    public void removeStudent (int position) {
        studentUndo = studentList.get(position);
        positionUndo = position;

        studentList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, studentList.size());
        showSBar(studentUndo,positionUndo);
        RoomDataBaseActivity.db.studentDao().deleteStudent(studentUndo);
    }

    public void updateStudentsListDao(List<StudentData> students) {
        studentList.clear();
        studentList.addAll(students);
        notifyDataSetChanged();
    }

    private int lastStudentId = 0;

    public void addStudentToAdapter() {
        studentList.add(0,new StudentData());
        notifyItemInserted(0);
        notifyItemRangeChanged(0,getItemCount());
    }

    public void showSBar (StudentData studentUndo, int positionUndo) {
        adapterInterface.dataToPresenter(studentUndo, positionUndo);
    }

    public void addUndoStudentToAdapter () {
        studentList.add(positionUndo,studentUndo);
        notifyItemInserted(positionUndo);
        notifyItemRangeChanged(0,getItemCount());

    }



}
