package com.example.robert.myapplication1.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.robert.myapplication1.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RocketStartsAdapter extends RecyclerView.Adapter<RocketStartsAdapter.RocketStartsHolder> {

    private List<Rocket> rocketStartList;
    private Context context;

    public RocketStartsAdapter(List<Rocket> rocketStartList, Context context) {
        this.rocketStartList = rocketStartList;
        this.context = context;
    }


    public class RocketStartsHolder extends RecyclerView.ViewHolder {

        private TextView rocket_id;
        private ImageView image;

        public RocketStartsHolder(View itemView) {
            super(itemView);
            rocket_id = (TextView) itemView.findViewById(R.id.rocket_id);
            image = (ImageView) itemView.findViewById(R.id.picture_view);
        }
    }

    @NonNull
    @Override
    public RocketStartsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rocketHolderView = layoutInflater.inflate(R.layout.item_rocket_starts, parent, false);
        RocketStartsHolder rocketStartsHolder = new RocketStartsAdapter.RocketStartsHolder(rocketHolderView);

        return rocketStartsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RocketStartsHolder holder, int position) {

        Rocket rocket = rocketStartList.get(position);


        ImageView imageView = holder.image;
        Glide.with(context)
                .load(rocket.getLink().getImageUrl())
                .into(imageView);

        SimpleDateFormat inputFormat = new SimpleDateFormat(Rocket.DATE_FORMAT, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(Rocket.DATE_OUTPUT, Locale.getDefault());

        try {
            Date date = inputFormat.parse(rocket.getDate());
            TextView textView = holder.rocket_id;
            textView.setText("Launch year: " + rocket.launch_year + "\n\nDate: " + outputFormat.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return rocketStartList.size();
    }
}
