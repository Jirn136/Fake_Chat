package com.example.fakechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class frag_chats extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private recyclerview_adapter adapter;
    private ArrayList<names> chatList = new ArrayList<>();

    public frag_chats() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.chats, container, false);

            recyclerViewProcess();
            addChatMembers();
        }

        return view;
    }

    private void addChatMembers() {

        chatList.add(new names("Rdj", R.drawable.rdj));
        chatList.add(new names("Jessy", R.drawable.jessy));
        chatList.add(new names("Ryuk", R.drawable.ryuk));
        chatList.add(new names("Maxim", R.drawable.maxim));
        chatList.add(new names("John", R.drawable.john));
        chatList.add(new names("Heath",R.drawable.joker));
    }

    private void recyclerViewProcess() {
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new recyclerview_adapter(getActivity(),chatList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        adapter.setListener(new recyclerview_adapter.onitemclickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i= new Intent(getContext(),convoActivity.class);
                names item=chatList.get(position);
                i.putExtra("name",item.getNames());
                i.putExtra("image",item.getImgId());
                startActivity(i);
            }
        });
    }

}
