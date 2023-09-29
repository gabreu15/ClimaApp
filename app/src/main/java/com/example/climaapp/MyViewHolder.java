package com.example.climaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView dateView, maxTempView, minTempView, windView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        dateView = itemView.findViewById(R.id.idTextViewDate);
        maxTempView = itemView.findViewById(R.id.idTextViewMaxTemp);
        minTempView = itemView.findViewById(R.id.idTextViewMinTemp);
        windView = itemView.findViewById(R.id.idTextViewWind);
    }
}
