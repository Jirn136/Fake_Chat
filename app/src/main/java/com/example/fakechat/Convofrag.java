package com.example.fakechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Convofrag extends Fragment {
    private View v;
    private RecyclerView rv;
    private RecyclerView.LayoutManager lm;
    private ConvoRecyclerview adapter;
    private ArrayList<ConvoCons> cons= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(v==null){
            v=inflater.inflate(R.layout.convo_viewhold,container,false);
            convo();
            recyclerContents();
        }

        return v;
    }

    private void recyclerContents() {
        rv= v.findViewById(R.id.chat_recycler);
        lm=new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        adapter=new ConvoRecyclerview(cons);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
    }

    private void convo() {

        cons.add(new ConvoCons("Hi....","Hello.."));
        cons.add(new ConvoCons("How are you","Im fine. What about you"));
        cons.add(new ConvoCons("Fine","Shall we go for a Hangout?"));
        cons.add(new ConvoCons("When?","Sometimes you wish!"));
        cons.add(new ConvoCons("I'll tell you later about that","chill"));
    }
}
