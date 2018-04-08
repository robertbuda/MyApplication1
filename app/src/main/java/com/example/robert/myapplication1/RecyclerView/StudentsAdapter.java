package com.example.robert.myapplication1.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.robert.myapplication1.ButterKnifeActivity_ViewBinding;
import com.example.robert.myapplication1.JobScheduler.ScheduleJobContract;
import com.example.robert.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsHolder> {


    /*@BindView(R.id.student_name)
    TextView student_name;

    @BindView(R.id.student_button)
    Button student_button;*/


    public class StudentsHolder extends RecyclerView.ViewHolder {


        public TextView student_name;
        public Button student_button;

        public StudentsHolder(View studentsHolderView) {
            super(studentsHolderView);

            //ButterKnife.bind(this,studentsHolderView);

            student_name = (TextView) itemView.findViewById(R.id.student_name);
            student_button = (Button) itemView.findViewById(R.id.student_button);

        }
    }

    private List<Student> studentList;
    private Context context;

    public StudentsAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }


    @NonNull
    @Override
    public StudentsAdapter.StudentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View studentsHolderView = layoutInflater.inflate(R.layout.item_student, parent, false);

        StudentsHolder studentsHolder = new StudentsHolder(studentsHolderView);

        return studentsHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.StudentsHolder holder, int position) {


        Student student = studentList.get(position);

        TextView textView = holder.student_name;
        textView.setText(student.getStudentName());

        Button button = holder.student_button;
        button.setText(student.isGraduated() ? "GRADUATED" : "SUSPENDED" );
        button.setEnabled(student.isGraduated());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


}
