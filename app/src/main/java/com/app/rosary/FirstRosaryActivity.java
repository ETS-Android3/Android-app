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

public class FirstRosaryActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_first_rosary);

        getSupportActionBar().setTitle("Rosary");

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF);

        GlobalVar.getInstance().setCount();
        GlobalVar.getInstance().setIndex();

        title = pref.getString("saved_title", "false");
        language = pref.getString("saved_language", "English");
        fatima = pref.getString("saved_fatima", "false");

        ImageButton Tab1 = (ImageButton) findViewById(R.id.tab1Button);
        Tab1.setOnClickListener(this::onClick);

        ImageButton Tab2 = (ImageButton) findViewById(R.id.tab2Button);
        Tab2.setOnClickListener(this::onClick);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        if(fatima.equals("false"))
            seekBar.setMax(7);
        else
            seekBar.setMax(8);

        seekBar.setProgress(0);

        String speedString = pref.getString("saved_speed", "Normal");

        if(speedString.equals("Fast"))
            speed = 3000;
        else if(speedString.equals("Slow"))
            speed = 5000;
        else if(speedString.equals("VSlow"))
            speed = 6000;
        else speed = 3800;

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
                startActivity(new Intent(FirstRosaryActivity.this, SettingsActivity.class));
                break;
            case R.id.mystery:
                startActivity(new Intent(FirstRosaryActivity.this, Mysteries.class));
                break;
            case R.id.home:
                startActivity(new Intent(FirstRosaryActivity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void onClick(View v){
        if(v.getId() == R.id.tab1Button){
            startActivity(new Intent(FirstRosaryActivity.this, MainActivity.class));
        }
        else if(v.getId() == R.id.tab2Button){
            GlobalVar.getInstance().increaseIndex();
            startActivity(new Intent(FirstRosaryActivity.this, SecondRosaryActivity.class));
        }
    }

   // WorkerThread workerThread;

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
            if (GlobalVar.getInstance().getCount() == 0) {
                arr = pray.getApostle(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 1) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() > 1 && GlobalVar.getInstance().getCount() < 5) {
                arr = pray.getMary(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 5) {
                arr = pray.getGlory(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 6) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else return;
        }
        else {
            if (GlobalVar.getInstance().getCount() == 0) {
                arr = pray.getApostle(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 1) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() > 1 && GlobalVar.getInstance().getCount() < 5) {
                arr = pray.getMary(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 5) {
                arr = pray.getGlory(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 6) {
                arr = pray.getOurFatimaPrayer(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 7) {
                arr = pray.getOurFather(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else return;
        }

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }



}