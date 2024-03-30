package com.example.smd_a2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    ArrayList<Item> items=new ArrayList<>();

    public ItemAdapter(ArrayList<Item> list)
    {
        items=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
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


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvSubItem,tvLocation;
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            tvSubItem=itemView.findViewById(R.id.tvSubItem);
            tvLocation=itemView.findViewById(R.id.tvLocation);
//            ivImage=itemView.findViewById(R.id.ivImage);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    itemView.getContext();
//
//                    Intent intent=new Intent(ItemAdapter.this,FormActivity.class);
//                }
//            });

        }


    }
}
