package com.example.fakechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConvoRecyclerview extends RecyclerView.Adapter<myViewHolder> {
    ArrayList<ConvoCons> cons;

    public ConvoRecyclerview(ArrayList<ConvoCons> cons) {
        this.cons = cons;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.convo_viewhold, parent, false);
        myViewHolder viewHolder = new myViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.incoming.setText(cons.get(position).conEnd);
        holder.outgoing.setText(cons.get(position).convMe);

    }

    @Override
    public int getItemCount() {
        return cons.size();
    }
}

class myViewHolder extends RecyclerView.ViewHolder {
    TextView incoming, outgoing;

    myViewHolder(@NonNull View itemView) {
        super(itemView);
        incoming = itemView.findViewById(R.id.incoming);
        outgoing = itemView.findViewById(R.id.outgoing);
    }
}
