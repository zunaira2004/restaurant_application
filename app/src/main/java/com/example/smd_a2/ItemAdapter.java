package com.example.smd_a2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    ArrayList<Item> items = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public ItemAdapter(ArrayList<Item> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvName.setText(items.get(position).getRestaurant_name());
        holder.tvSubItem.setText(items.get(position).getSubItem());
        holder.tvLocation.setText(items.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvSubItem, tvLocation;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSubItem = itemView.findViewById(R.id.tvSubItem);
            tvLocation = itemView.findViewById(R.id.tvLocation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Item clickedItem = items.get(position);
                        listener.onItemClick(clickedItem);
                    }
                }
            });
        }
    }
}
