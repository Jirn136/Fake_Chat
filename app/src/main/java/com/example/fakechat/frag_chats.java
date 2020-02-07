package com.example.fakechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class frag_chats extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private recyclerview_adapter adapter;

    int[] arr = {R.drawable.jessy, R.drawable.john, R.drawable.ryuk, R.drawable.maxim, R.drawable.rdj};

    public frag_chats() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chats, container, false);

        recyclerViewProcess();

        return view;
    }

    private void recyclerViewProcess() {
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new recyclerview_adapter(arr);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

}
