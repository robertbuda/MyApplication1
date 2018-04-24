package com.example.robert.myapplication1.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robert.myapplication1.ButterKnifeActivity_ViewBinding;
import com.example.robert.myapplication1.JobScheduler.ScheduleJobContract;
import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.simplecasemvp.Contract;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsHolder> {

    private Context context;
    private List<Student> studentList = new ArrayList<>();
    private StudentsContract.AdapterInterface adapterInterface;

    public StudentsAdapter(List<Student> studentList, Context context, StudentsContract.AdapterInterface adapterInterface) {
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
        button.setText(student.isGraduated() ? "GRADUATED" : "SUSPENDED");
        button.setEnabled(student.isGraduated());
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

    private Student studentUndo;
    private int positionUndo;

    public void removeStudent (int position) {
        studentUndo = studentList.get(position);
        positionUndo = position;
        studentList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, studentList.size());
        showSBar(studentUndo,positionUndo);
    }

    public void updateStudentsList(List<Student> students) {
        studentList.addAll(students);
        notifyDataSetChanged();
    }

    public void addStudentToAdapter() {
        studentList.add(0,new Student("New Student",true));
        notifyItemInserted(0);
        notifyItemRangeChanged(0,getItemCount());
    }

    public void showSBar (Student studentUndo, int positionUndo) {
        adapterInterface.dataToPresenter(studentUndo, positionUndo);
    }

    public void addUndoStudentToAdapter () {
        studentList.add(positionUndo,studentUndo);
        notifyItemInserted(positionUndo);
        notifyItemRangeChanged(0,getItemCount());

    }

}
