package com.example.fakechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.viewHolder> {

    private ArrayList<names> chatList;

    public recyclerview_adapter(ArrayList<names> chatList) {
        this.chatList = chatList;
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
        holder.imgButton.setImageResource(chatList.get(position).getImgId());
        holder.txtView.setText(chatList.get(position).getNames());


    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imgButton;
        TextView txtView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imgButton = itemView.findViewById(R.id.imgProfile);
            txtView = itemView.findViewById(R.id.txtName);
        }
    }
}
