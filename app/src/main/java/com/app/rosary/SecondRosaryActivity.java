package com.app.rosary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class SecondRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
    private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    private SeekBar seekBar;
    private SharedPreferences pref;
    private int speed;
    private String title, language, fatima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_rosary);

        getSupportActionBar().setTitle("Rosary");

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF2);

        GlobalVar.getInstance().setCount();

        String speedString = pref.getString("saved_speed", "Normal");

        title = pref.getString("saved_title", "false");
        language = pref.getString("saved_language", "English");
        fatima = pref.getString("saved_fatima", "false");

        if(speedString.equals("Fast"))
            speed = 3000;
        else if(speedString.equals("Slow"))
            speed = 5000;
        else if(speedString.equals("VSlow"))
            speed = 6000;
        else speed = 3800;

        ImageButton Tab1 = (ImageButton) findViewById(R.id.tab3Button);
        Tab1.setOnClickListener(this::onClick);

        ImageButton Tab2 = (ImageButton) findViewById(R.id.tab4Button);
        Tab2.setOnClickListener(this::onClick);

        seekBar = (SeekBar) findViewById(R.id.seekBar2);

        if(fatima.equals("false"))
            seekBar.setMax(12);
        else
            seekBar.setMax(13);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                startActivity(new Intent(SecondRosaryActivity.this, SettingsActivity.class));
                break;
            case R.id.mystery:
                startActivity(new Intent(SecondRosaryActivity.this, Mysteries.class));
                break;
            case R.id.home:
                startActivity(new Intent(SecondRosaryActivity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void onClick(View v){
        if(v.getId() == R.id.tab3Button){
            if(GlobalVar.getInstance().getIndex() == 1 ) {
                startActivity(new Intent(SecondRosaryActivity.this, FirstRosaryActivity.class));
            }
            else{
                GlobalVar.getInstance().decreaseIndex();
                startActivity(new Intent(SecondRosaryActivity.this, SecondRosaryActivity.class));
            }
        }
        else if(v.getId() == R.id.tab4Button){
            if(GlobalVar.getInstance().getIndex() >= 4) {
                startActivity(new Intent(SecondRosaryActivity.this, ThirdRosaryActivity.class));
            }
            else {
                GlobalVar.getInstance().increaseIndex();
                startActivity(new Intent(SecondRosaryActivity.this, SecondRosaryActivity.class));
            }
        }
    }


    public boolean onTouchEvent(MotionEvent event){

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

        Prayer pray = new Prayer();

        if(fatima.equals("false")) {
            if (GlobalVar.getInstance().getCount() > -1 && GlobalVar.getInstance().getCount() < 10) {
                arr = pray.getMary(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 10) {
                arr = pray.getGlory(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 11) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else return;
        }
        else {
            if (GlobalVar.getInstance().getCount() > -1 && GlobalVar.getInstance().getCount() < 10) {
                arr = pray.getMary(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 10) {
                arr = pray.getGlory(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 11) {
                arr = pray.getOurFatimaPrayer(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 12) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            }
            else return;
        }

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }


}