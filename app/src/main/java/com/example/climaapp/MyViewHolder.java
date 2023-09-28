package com.example.climaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView timeView, temperatureView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.idImageViewIcon);
        timeView = itemView.findViewById(R.id.idTextViewTime);
        temperatureView = itemView.findViewById(R.id.idTextViewTemperature);
    }
}
