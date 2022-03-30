package com.app.rosary;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class Mysteries extends AppCompatActivity {

    private int count;

    private SectionsPagerAdapter sectionsPagerAdapter;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysteries);

        count = GlobalVar.getInstance().getIndex();

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.view_pager);
        setupWithViewPager(viewPager);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        ImageButton b = (ImageButton) findViewById(R.id.backButton);
        b.setOnClickListener(this::OnClick);


    }

    public void OptionMenu2(View v){
        PopupMenu optionMenu = new PopupMenu(this, v);
        optionMenu.setOnMenuItemClickListener(this::onMenuItemClick);
        optionMenu.inflate(R.menu.optionmenu3);
        optionMenu.show();
    }



    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()) {
            case R.id.rosary:
                if(count == 0)
                    startActivity(new Intent(Mysteries.this, FirstRosaryActivity.class));
                else if(count < 4)
                    startActivity(new Intent(Mysteries.this, SecondRosaryActivity.class));
                else
                    startActivity(new Intent(Mysteries.this, ThirdRosaryActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(Mysteries.this, SettingsActivity.class));
                break;
            case R.id.home:
                startActivity(new Intent(Mysteries.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupWithViewPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Joy(), "Joyful");
        adapter.addFragment(new Sorrow(), "Sorrow-\nful");
        adapter.addFragment(new Glory(), "Glorious");
        adapter.addFragment(new Lum(), "Luminous");

        viewPager.setAdapter(adapter);
    }

    public void OnClick(View v){
        switch(v.getId()){
            case R.id.backButton:
                onBackPressed();
        }
    }
}