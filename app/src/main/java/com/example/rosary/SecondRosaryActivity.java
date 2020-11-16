package com.example.rosary;

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
import android.widget.SeekBar;

public class SecondRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
    private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    private SeekBar seekBar;
    private SharedPreferences pref;
    private int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_rosary);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF2);

        GlobalVar.getInstance().setCount();

        String speedString = pref.getString("save_speed", "Normal");

        if(speedString.equals("Fast"))
            speed = 3000;
        else if(speedString.equals("Slow"))
            speed = 4000;
        else speed = 3500;

        ImageButton Tab1 = (ImageButton) findViewById(R.id.tab3Button);
        Tab1.setOnClickListener(this::onClick);

        ImageButton Tab2 = (ImageButton) findViewById(R.id.tab4Button);
        Tab2.setOnClickListener(this::onClick);

        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setMax(12);
        seekBar.setProgress(0);

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

    }

    private void onClick(View v){
        if(v.getId() == R.id.tab3Button){
            if(GlobalVar.getInstance().getIndex() == 3 ) {
                Intent i = new Intent(SecondRosaryActivity.this, FirstRosaryActivity.class);
                startActivity(i);
            }
            else{
                GlobalVar.getInstance().increaseIndex();
                Intent i = new Intent(SecondRosaryActivity.this, SecondRosaryActivity.class);
                startActivity(i);
            }
        }
        else if(v.getId() == R.id.tab4Button){
            if(GlobalVar.getInstance().getIndex() <= 0) {
                Intent i = new Intent(SecondRosaryActivity.this, ThirdRosaryActivity.class);
                startActivity(i);
            }
            else {
                GlobalVar.getInstance().decreaseIndex();
                Intent i = new Intent(SecondRosaryActivity.this, SecondRosaryActivity.class);
                startActivity(i);
            }
        }
    }


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

        if (GlobalVar.getInstance().getCount() > -1 && GlobalVar.getInstance().getCount() < 10) {
            arr = pray.getMary(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        } else if (GlobalVar.getInstance().getCount() == 10) {
            arr = pray.getGlory(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        }
        else if (GlobalVar.getInstance().getCount() == 11) {
            arr = pray.getOurFather(language, title);
            GlobalVar.getInstance().increaseCount();
            seekBar.incrementProgressBy(1);
        }
        else return;

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }


}