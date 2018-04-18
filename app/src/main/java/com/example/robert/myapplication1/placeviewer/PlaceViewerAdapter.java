package com.example.robert.myapplication1.placeviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.RecyclerView.ResourcesPlacViever;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViewerAdapter extends ArrayAdapter<ResourcesPlacViever> {

    private Context context;
    private List<ResourcesPlacViever> resourcesList = new ArrayList<>();


    public PlaceViewerAdapter(@NonNull Context context, ArrayList<ResourcesPlacViever> list) {
        super(context, 0, list);
        this.context = context;
        this.resourcesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(this.context).inflate(R.layout.text_place_row,parent,false);

        ResourcesPlacViever currentResource = resourcesList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imgPlaces);
        imageView.setImageResource(currentResource.getImageRes());

        TextView textView = (TextView) listItem.findViewById(R.id.txtPlaces);
        textView.setText(currentResource.getTitleRes());

        return listItem;

    }
}
