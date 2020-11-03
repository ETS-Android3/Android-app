package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

public class FirstRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
   private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_rosary);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF);

        Button Apostle = (Button) findViewById(R.id.CrossButton);
        Apostle.setOnTouchListener(this::onTouch);
        Button Father = (Button) findViewById(R.id.FatherButton);
        Father.setOnTouchListener(this::onTouch);
        Button Father2 = (Button) findViewById(R.id.FatherButton2);
        Father2.setOnTouchListener(this::onTouch);
        Button Mary = (Button) findViewById(R.id.MaryButton);
        Mary.setOnTouchListener(this::onTouch);
        Button Mary2 = (Button) findViewById(R.id.MaryButton2);
        Mary2.setOnTouchListener(this::onTouch);
        Button Mary3 = (Button) findViewById(R.id.MaryButton3);
        Mary3.setOnTouchListener(this::onTouch);
        Button Glory = (Button) findViewById(R.id.GloryButton);
        Glory.setOnTouchListener(this::onTouch);


        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);
        AVF.setFlipInterval(3000);
        AVF.setAutoStart(true);
        AVF.stopFlipping();

        GlobalVar.getInstance().setIndex();

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

        if (v.getId() == R.id.CrossButton) {
            arr = pray.getApostle();
        } else if (v.getId() == R.id.FatherButton || v.getId() == R.id.FatherButton2) {
            arr = pray.getOurFather();
        } else if (v.getId() == R.id.MaryButton || v.getId() == R.id.MaryButton2 || v.getId() == R.id.MaryButton3) {
            arr = pray.getMary();
        } else if (v.getId() == R.id.GloryButton) {
            arr = pray.getGlory();
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
                    Intent i = new Intent(FirstRosaryActivity.this, MainActivity.class);
                    startActivity(i);
                }else if(x1 > x2) {
                    Intent i = new Intent(FirstRosaryActivity.this, SecondRosaryActivity.class);
                    startActivity(i);
                }
                }
            break;
        }
        return false;
    }



}