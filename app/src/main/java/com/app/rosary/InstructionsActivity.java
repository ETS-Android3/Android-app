package com.app.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        getSupportActionBar().setTitle("Instructions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView inst1 = (TextView) findViewById(R.id.textint1);
        TextView inst2 = (TextView) findViewById(R.id.textint2);
        TextView inst3 = (TextView) findViewById(R.id.textint3);

        inst1.setText("\nTo pray the rosary make sure to hold each section highlighted by the arrows" +
                "\nThere is a bar (highlighted by the blue arrow) where you can adjust the prayer count. It also keeps track of progression.\n\n" +
                "For the first section, make sure to hold the cross, the first 4 beads, the chain section once (twice with fatima prayer enabled) and the last bead.\n");
        inst2.setText("\nFor the second, third, fourth and fifth section make sure to hold the first 10 beads, the chain once (twice with fatima prayer enabled) and the last bead.\n");
        inst3.setText("\nFor the last section make sure to hold the first 10 beads, the chain once (twice with fatima prayer enabled), and the icon twice.\n");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}