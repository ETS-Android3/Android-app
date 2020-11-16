package com.example.rosary;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class FirstRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
   private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    private SeekBar seekBar;
    private SharedPreferences pref;
    private int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_rosary);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF);

        GlobalVar.getInstance().setCount();

        ImageButton Tab1 = (ImageButton) findViewById(R.id.tab1Button);
        Tab1.setOnClickListener(this::onClick);

        ImageButton Tab2 = (ImageButton) findViewById(R.id.tab2Button);
        Tab2.setOnClickListener(this::onClick);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(7);
        seekBar.setProgress(0);

        String speedString = pref.getString("save_speed", "Normal");

        if(speedString.equals("Fast"))
            speed = 3000;
        else if(speedString.equals("Slow"))
            speed = 4000;
        else speed = 3500;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                GlobalVar.getInstance().setCount(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

        GlobalVar.getInstance().setIndex();



    }


    private void onClick(View v){
        if(v.getId() == R.id.tab1Button){
            Intent i = new Intent(FirstRosaryActivity.this, MainActivity.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.tab2Button){
            Intent i = new Intent(FirstRosaryActivity.this, SecondRosaryActivity.class);
            startActivity(i);
        }
    }

   // WorkerThread workerThread;

    public boolean onTouchEvent(MotionEvent event){

        String title = pref.getString("saved_title", "false");

        int action = event.getAction();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                PrayNow(arr);
                AVF.setFlipInterval(speed);
                AVF.setAutoStart(true);
                if(title.equals("true"))
                    AVF.stopFlipping();
                else
                    AVF.startFlipping();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                AVF.setDisplayedChild(1);
                AVF.stopFlipping();
                AVF.removeAllViewsInLayout();
                break;
        }
        return false;
    }

    public void PrayNow(String [] arr){

        String title = pref.getString("saved_title", "false");
        String language = pref.getString("saved_language", "English");

        Prayer pray = new Prayer();

        if (GlobalVar.getInstance().getCount() == 0) {
            arr = pray.getApostle(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        } else if(GlobalVar.getInstance().getCount() == 1){
            arr = pray.getOurFather(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        } else if (GlobalVar.getInstance().getCount() > 1 && GlobalVar.getInstance().getCount() < 5) {
            arr = pray.getMary(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        } else if (GlobalVar.getInstance().getCount() == 5) {
            arr = pray.getGlory(language,title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        } else if (GlobalVar.getInstance().getCount() == 6) {
            arr = pray.getOurFather(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        }
        else return;

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }



}