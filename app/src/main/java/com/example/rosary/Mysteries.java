package com.example.rosary;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toolbar;


public class Mysteries extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysteries);

        ImageButton b = (ImageButton) findViewById(R.id.backButton);
        b.setOnClickListener(this::OnClick);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.view_pager);
        setupWithViewPager(viewPager);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    private void setupWithViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Joy(), "Joy");
        adapter.addFragment(new Sorrow(), "Sorrow");
        adapter.addFragment(new Glory(), "Glorry");
        adapter.addFragment(new Lum(), "Lum");

        viewPager.setAdapter(adapter);
    }

    public void OnClick(View v){
        switch(v.getId()){
            case R.id.backButton:
                onBackPressed();
        }
    }
}