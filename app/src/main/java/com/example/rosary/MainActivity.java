package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Rosary = (Button) findViewById(R.id.RosaryButton);
        Rosary.setOnClickListener(this::onClick);
        Button Instructions = (Button) findViewById(R.id.Inst);
        Instructions.setOnClickListener(this::onClick);
        Button Settings = (Button) findViewById(R.id.SettingButton);
        Settings.setOnClickListener(this::onClick);

    }

    public void onClick(View v){
        if(v.getId() == R.id.RosaryButton){
            startActivity(new Intent(MainActivity.this, FirstRosaryActivity.class));
        }
        else if(v.getId() == R.id.Inst){
            //startActivity(new Intent(MainActivity.this, FirstRosaryActivity.class));
        }
        else if(v.getId() == R.id.SettingButton){
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
    }
}