package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("The Rosary");

        Button gloriousMysteries = findViewById(R.id.gloriousMysteries);
        gloriousMysteries.setOnClickListener(this::onClick);

        /*
        ImageButton Rosary = (ImageButton) findViewById(R.id.RosaryButton);
        Rosary.setOnClickListener(this::onClick);

        ImageButton Instructions = (ImageButton) findViewById(R.id.Inst);
        Instructions.setOnClickListener(this::onClick);

        ImageButton Settings = (ImageButton) findViewById(R.id.SettingButton);
        Settings.setOnClickListener(this::onClick);

        ImageButton Mystery = (ImageButton) findViewById(R.id.mysteryButton);
        Mystery.setOnClickListener(this::onClick);

         */

    }

    public void onClick(View v){

        if (v.getId() == R.id.gloriousMysteries) {
            if (GlobalVar.getInstance().getIndex() == -1 || GlobalVar.getInstance().getIndex() == 0) {
                startActivity(new Intent(MainActivity.this, BeginRosaryActivity.class));
            } else if (GlobalVar.getInstance().getIndex() == 1) {
                startActivity(new Intent(MainActivity.this, FirstRosaryActivity.class));
            } else if (GlobalVar.getInstance().getIndex() > 1 && GlobalVar.getInstance().getIndex() < 6) {
                startActivity(new Intent(MainActivity.this, SecondRosaryActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, ThirdRosaryActivity.class));
            }
        }
        /*
        if(v.getId() == R.id.RosaryButton){
            startActivity(new Intent(MainActivity.this, FirstRosaryActivity.class));
        }
        else if(v.getId() == R.id.mysteryButton){
            startActivity(new Intent(MainActivity.this, Mysteries.class));
        }
        else if(v.getId() == R.id.Inst){
            startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
        }
        else if(v.getId() == R.id.SettingButton){
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }

         */
    }
}