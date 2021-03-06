package com.example.fakechat;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.viewHolder> {

    private ArrayList<names> chatList;
    private Activity a;
    private onitemclickListener listener;

    public void setListener(onitemclickListener listener) {
        this.listener = listener;
    }

    public recyclerview_adapter(Activity a, ArrayList<names> chatList) {
        this.chatList = chatList;
        this.a = a;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_viewholder, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface onitemclickListener {
        void onItemClick(int position);
    }

}
