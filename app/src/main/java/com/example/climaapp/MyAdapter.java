package com.example.climaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dataEHoraView.setText(items.get(position).getDataEHora());
        holder.temperaturaView.setText(items.get(position).getTemperatura());
        holder.ventoView.setText(items.get(position).getVento());
        holder.iconeView.setImageResource(R.drawable.not_available);
        if (items.get(position).getIcone().equals("01d"))
            holder.iconeView.setImageResource(R.drawable.d01);
        if (items.get(position).getIcone().equals("01n"))
            holder.iconeView.setImageResource(R.drawable.n01);
        if (items.get(position).getIcone().equals("02d"))
            holder.iconeView.setImageResource(R.drawable.d02);
        if (items.get(position).getIcone().equals("02n"))
            holder.iconeView.setImageResource(R.drawable.n02);
        if (items.get(position).getIcone().equals("03d"))
            holder.iconeView.setImageResource(R.drawable.d03);
        if (items.get(position).getIcone().equals("03n"))
            holder.iconeView.setImageResource(R.drawable.n03);
        if (items.get(position).getIcone().equals("04d"))
            holder.iconeView.setImageResource(R.drawable.d04);
        if (items.get(position).getIcone().equals("04n"))
            holder.iconeView.setImageResource(R.drawable.n04);
        if (items.get(position).getIcone().equals("09d"))
            holder.iconeView.setImageResource(R.drawable.d09);
        if (items.get(position).getIcone().equals("09n"))
            holder.iconeView.setImageResource(R.drawable.n09);
        if (items.get(position).getIcone().equals("10d"))
            holder.iconeView.setImageResource(R.drawable.d10);
        if (items.get(position).getIcone().equals("10n"))
            holder.iconeView.setImageResource(R.drawable.n10);
        if (items.get(position).getIcone().equals("11d"))
            holder.iconeView.setImageResource(R.drawable.d11);
        if (items.get(position).getIcone().equals("11n"))
            holder.iconeView.setImageResource(R.drawable.n11);
        if (items.get(position).getIcone().equals("50d"))
            holder.iconeView.setImageResource(R.drawable.d50);
        if (items.get(position).getIcone().equals("50n"))
            holder.iconeView.setImageResource(R.drawable.n50);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
