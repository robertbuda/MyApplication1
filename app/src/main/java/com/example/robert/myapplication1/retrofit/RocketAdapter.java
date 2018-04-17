package com.example.robert.myapplication1.retrofit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.RecyclerView.Student;
import com.example.robert.myapplication1.RecyclerView.StudentsAdapter;

import java.util.List;

public class RocketAdapter extends RecyclerView.Adapter<RocketAdapter.RocketHolder> {


    public class RocketHolder extends RecyclerView.ViewHolder {

        public TextView rocket_id;

        public RocketHolder(View itemView) {
            super(itemView);
            rocket_id = (TextView) itemView.findViewById(R.id.rocket_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


    private List<Rocket> rocketList;
    private Context context;


    public RocketAdapter(List<Rocket> rocketList, Context context) {
        this.rocketList = rocketList;
        this.context = context;
    }

    @NonNull
    @Override
    public RocketAdapter.RocketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rocketHolderView = layoutInflater.inflate(R.layout.item_rocket, parent, false);
        RocketHolder rocketHolder = new RocketHolder(rocketHolderView);

        return rocketHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RocketAdapter.RocketHolder holder, int position) {
        Rocket rocket = rocketList.get(position);
        TextView textView = holder.rocket_id;
        textView.setText(rocket.id + " - "+ rocket.name + " - " + rocket.type + "\n\n" + rocket.description + "\n\n"
                + "id: " + rocket.payloadWeights.get(position).id + "\n"
                + "name: " + rocket.payloadWeights.get(position).name + "\n"
                + "kg: " + rocket.payloadWeights.get(position).kg + "\n"
                + "lb: " + rocket.payloadWeights.get(position).lb
        );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //textView.setText("CLICK");
             Intent intent = new Intent(context, RocketStartsActivity.class);
             intent.putExtra("ROCKET_ID",rocket.id);
             v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return rocketList.size();
    }

    public void updateAdapter(List<Rocket> rockets) {

    }


}
