package com.example.fakechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.viewHolder> {
    int arr[];

    public recyclerview_adapter(int[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_viewholder, parent, false);
        viewHolder viewHolder = new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imgButton.setImageResource(arr[position]);
        holder.txtView.setText(arr[position ]);


    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageButton imgButton;
        TextView txtView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imgButton = itemView.findViewById(R.id.imgProfile);
            txtView = itemView.findViewById(R.id.txtName);
        }
    }
}
