package com.example.rosary;

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
                "For the first section, make sure to hold the cross, the beads and the chain section.\n");
        inst2.setText("\nFor the second section make sure to hold the first 10 beads, the chain and the last bead.\n");
        inst3.setText("\nFor the third section make sure to hold the first 10 beads, the chain, and the icon.\n");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}