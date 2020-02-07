package com.example.fakechat;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationDrawer();

        tabFrags();

    }

    public void navigationDrawer(){
        Toolbar toolbar= findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawerLayout= findViewById(R.id.drawLayout);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draw_open,R.string.draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void tabFrags(){
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        viewPagerAdapter adapter= new viewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new frag_chats(),"Chats");
        adapter.addFragment(new frag_group(),"Groups");
        adapter.addFragment(new frag_calls(),"Calls");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
