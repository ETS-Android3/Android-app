package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

public class ThirdRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
    private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_rosary);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF3);

        Button Mary1 = (Button) findViewById(R.id.maryb1);
        Mary1.setOnTouchListener(this::onTouch);
        Button Mary2 = (Button) findViewById(R.id.maryb2);
        Mary2.setOnTouchListener(this::onTouch);
        Button Mary3 = (Button) findViewById(R.id.maryb3);
        Mary3.setOnTouchListener(this::onTouch);
        Button Mary4 = (Button) findViewById(R.id.maryb4);
        Mary4.setOnTouchListener(this::onTouch);
        Button Mary5 = (Button) findViewById(R.id.maryb5);
        Mary5.setOnTouchListener(this::onTouch);
        Button Mary6 = (Button) findViewById(R.id.maryb6);
        Mary6.setOnTouchListener(this::onTouch);
        Button Mary7 = (Button) findViewById(R.id.maryb7);
        Mary7.setOnTouchListener(this::onTouch);
        Button Mary8 = (Button) findViewById(R.id.maryb8);
        Mary8.setOnTouchListener(this::onTouch);
        Button Mary9 = (Button) findViewById(R.id.maryb9);
        Mary9.setOnTouchListener(this::onTouch);
        Button Mary10 = (Button) findViewById(R.id.maryb10);
        Mary10.setOnTouchListener(this::onTouch);
        Button HailMary = (Button) findViewById(R.id.hailmary);
        HailMary.setOnTouchListener(this::onTouch);

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);
        AVF.setFlipInterval(3000);
        AVF.setAutoStart(true);
        AVF.stopFlipping();
    }

    private boolean onTouch(View view, MotionEvent touch) {
        switch(touch.getAction()) {
            case MotionEvent.ACTION_DOWN:
                PrayNow(arr, view);
                AVF.setFlipInterval(3000);
                AVF.startFlipping();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                AVF.showNext();
                AVF.stopFlipping();
                AVF.removeAllViewsInLayout();
                break;
        }
        return false;
    }

    public void PrayNow(String [] arr, View v){
        Prayer pray = new Prayer();

        if (v.getId() == R.id.maryb1 || v.getId() == R.id.maryb2 || v.getId() == R.id.maryb3 ||
                v.getId() == R.id.maryb4 || v.getId() == R.id.maryb5 || v.getId() == R.id.maryb6 ||
                v.getId() == R.id.maryb7 || v.getId() == R.id.maryb8 || v.getId() == R.id.maryb9 ||
                v.getId() == R.id.maryb10) {
            arr = pray.getMary();
        } else if (v.getId() == R.id.hailmary) {
            arr = pray.getOurHolyQueen();
        }

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }



    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(Math.abs(x1-x2) > 50) {
                    if(x1 < x2){
                        Intent i = new Intent(ThirdRosaryActivity.this, SecondRosaryActivity.class);
                        startActivity(i);
                    }else if(x1 > x2) {
                        Intent i = new Intent(ThirdRosaryActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }
                break;
        }
        return false;
    }
}