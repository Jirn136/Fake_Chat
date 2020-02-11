package com.example.fakechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Objects;

public class convoActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rv;
    private RecyclerView.LayoutManager lm;
    private ConvoRecyclerview adapter;
    private ArrayList<ConvoCons> cons = new ArrayList<>();
    private int imgId;
    private String nameId;
    private ImageView imgsProfile, video, audio, menu;
    private TextView txtNameCard;
    private ImageButton backButton, btnSend;
    private String myList;
    private EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convo);

        imgsProfile = findViewById(R.id.imgsProfile);
        video = findViewById(R.id.video);
        audio = findViewById(R.id.audio);
        menu = findViewById(R.id.menu);
        txtNameCard = findViewById(R.id.namesCard);
        backButton = findViewById(R.id.backButton);
        btnSend = findViewById(R.id.btnSend);
        edtMessage = findViewById(R.id.edtMessage);

        nameId = Objects.requireNonNull(getIntent().getExtras()).getString("name");
        imgId = getIntent().getExtras().getInt("image");


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
        rv = findViewById(R.id.chat_recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ConvoRecyclerview(cons);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
    }

    private void convo() {

        cons.add(new ConvoCons("Hi....", "Hello.."));
        cons.add(new ConvoCons("How are you", "Im fine. What about you"));
        cons.add(new ConvoCons("Fine", "Shall we go for a Hangout?"));
        cons.add(new ConvoCons("When?", "Sometimes you wish!"));
        cons.add(new ConvoCons("I'll tell you later about that", "chill"));
    }


    @Override
    public void onClick(View v) {
        myList = edtMessage.getText().toString();
        switch (v.getId()) {
            case R.id.video:
                Toast.makeText(this, "Video Calling on Progress", Toast.LENGTH_SHORT).show();
                break;
            case R.id.audio:
                Toast.makeText(this, "Audio Calling on Progress", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu:
                PopupMenu popupMenu = new PopupMenu(this, v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.emailChat:
                                Toast.makeText(convoActivity.this, "Email chat is done", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.clearChat:
                                Toast.makeText(convoActivity.this, "Clearchat is done", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.block:
                                Toast.makeText(convoActivity.this, "Blocked the User", Toast.LENGTH_SHORT).show();

                                break;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.inside_chat);
                popupMenu.show();
                break;
            case R.id.backButton:
                finish();
                break;
            case R.id.btnSend:
                if (edtMessage.getText().toString().isEmpty()) {

                    Toast.makeText(this, "Enter Content", Toast.LENGTH_SHORT).show();
                } else {

                    edtMessage.setText("");
                    cons.add(new ConvoCons(myList, "ok"));
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
