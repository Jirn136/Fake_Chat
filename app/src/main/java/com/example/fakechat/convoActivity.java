package com.example.fakechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Objects;

public class convoActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv;
    private RecyclerView.LayoutManager lm;
    private ConvoRecyclerview adapter;
    private ArrayList<ConvoCons> cons= new ArrayList<>();
    private int imgId;
    private String nameId;
    private ImageView imgsProfile,video,audio,menu;
    private TextView txtNameCard;
    private ImageButton backButton,btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo);

        imgsProfile=findViewById(R.id.imgsProfile);
        video=findViewById(R.id.video);
        audio=findViewById(R.id.audio);
        menu=findViewById(R.id.menu);
        txtNameCard=findViewById(R.id.namesCard);
        backButton=findViewById(R.id.backButton);
        btnSend=findViewById(R.id.btnSend);

        nameId= Objects.requireNonNull(getIntent().getExtras()).getString("name");
        imgId=getIntent().getExtras().getInt("image");


        recyclerContents();

        convo();

        video.setOnClickListener(this);
        audio.setOnClickListener(this);
        menu.setOnClickListener(this);
        backButton.setOnClickListener(this);
        btnSend.setOnClickListener(this);

        txtNameCard.setText(nameId);
        imgsProfile.setImageResource(imgId);


    }

    private void recyclerContents() {
        rv=findViewById(R.id.chat_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
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



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.video:
                break;
            case R.id.audio:
                break;
            case R.id.menu:
                break;
            case R.id.backButton:
                finish();
                break;
            case R.id.btnSend:
                break;
        }
    }
}
