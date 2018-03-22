package com.example.robert.myapplication1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 2018-03-21.
 */

public class PlaceViewerAdapter extends ArrayAdapter<ResourcesPlacViever> {

    private Context context;
    private List<ResourcesPlacViever> resourcesList = new ArrayList<>();


    public PlaceViewerAdapter(@NonNull Context context, List<ResourcesPlacViever> resourcesList) {
        super(context, 0, resourcesList);
        this.context = context;
        this.resourcesList = resourcesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(this.context).inflate(R.layout.text_place_row,parent,false);

        ResourcesPlacViever placeViewerAdapter = resourcesList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imgPlaces);
        imageView.setImageResource(placeViewerAdapter.getImageRes());

        TextView textView = (TextView) listItem.findViewById(R.id.txtPlaces);
        textView.setText(placeViewerAdapter.getTitleRes());

        return listItem;

    }
}
