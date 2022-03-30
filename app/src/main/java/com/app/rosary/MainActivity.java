package com.app.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = GlobalVar.getInstance().getIndex();

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
            if(count == 0)
                startActivity(new Intent(MainActivity.this, FirstRosaryActivity.class));
            else if(count < 4)
                startActivity(new Intent(MainActivity.this, SecondRosaryActivity.class));
            else
                startActivity(new Intent(MainActivity.this, ThirdRosaryActivity.class));
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