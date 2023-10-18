package com.example.climaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView dataEHoraView, temperaturaView, ventoView; ImageView iconeView;
    public MyViewHolder(@NonNull View itemView)
    {
        super(itemView);
        dataEHoraView = itemView.findViewById(R.id.textViewDataEHora);
        temperaturaView = itemView.findViewById(R.id.textViewTemperatura);
        ventoView = itemView.findViewById(R.id.textViewVento);
        iconeView = itemView.findViewById(R.id.imageViewIcone);
    }

}