package com.app.rosary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.AdapterViewFlipper;
import android.widget.SeekBar;

public class ThirdRosaryActivity extends AppCompatActivity {

    public String[] arr =  {};
    private AdapterViewFlipper AVF;
    CustomAdapter customAdapter;
    private SeekBar seekBar;
    private SharedPreferences pref;
    private int speed;
    private VelocityTracker mVelocityTracker = null;
    private String title, language, fatima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_rosary);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        AVF = (AdapterViewFlipper) findViewById(R.id.AVF);

        GlobalVar.getInstance().setCount();

        title = pref.getString("saved_title", "false");
        language = pref.getString("saved_language", "English");
        fatima = pref.getString("saved_fatima", "false");

        String speedString = pref.getString("saved_speed", "Normal");

        if(speedString.equals("Fast"))
            speed = 3000;
        else if(speedString.equals("Slow"))
            speed = 5000;
        else if(speedString.equals("VSlow"))
            speed = 6000;
        else speed = 3800;

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        if(fatima.equals("false"))
            seekBar.setMax(13);
        else
            seekBar.setMax(14);
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

    private void viewChange(int viewUpdate) {
        if(viewUpdate == 0){
            GlobalVar.getInstance().decreaseIndex();
            Intent i = new Intent(ThirdRosaryActivity.this, SecondRosaryActivity.class);
            startActivity(i);
        }
        else {
            GlobalVar.getInstance().setIndex();
            Intent i = new Intent(ThirdRosaryActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    public boolean onTouchEvent(MotionEvent event){

        int action = event.getAction();
        float y1 = 0;
        float y2 = 0;
        float diffY = 0;

        switch(action){
            case MotionEvent.ACTION_DOWN:
                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain();
                } else {
                    mVelocityTracker.clear();
                }
                mVelocityTracker.addMovement(event);
                y1 = event.getY();
                PrayNow(arr);
                AVF.setFlipInterval(speed);
                AVF.setAutoStart(true);
                if(title.equals("true"))
                    AVF.stopFlipping();
                else
                    AVF.startFlipping();
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                mVelocityTracker.computeCurrentVelocity(1000);
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                y2 = event.getY();
                AVF.setDisplayedChild(1);
                AVF.stopFlipping();
                AVF.removeAllViewsInLayout();
                diffY = y2 - y1;
                if (Math.abs(diffY) > 1000 && Math.abs(mVelocityTracker.getYVelocity()) > 300) {
                    String d = String.valueOf(mVelocityTracker.getYVelocity());
                    if (mVelocityTracker.getYVelocity() > 0) {
                        viewChange(1);
                    } else {
                        viewChange(0);
                    }
                }
                break;
        }
        return false;
    }


    public void PrayNow(String [] arr){

        String title = pref.getString("saved_title", "false");
        String language = pref.getString("saved_language", "English");

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
                arr = pray.getOurHolyQueen(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 12) {
                arr = pray.getOurFinalPrayer(language, title);
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
                arr = pray.getOurHolyQueen(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else if (GlobalVar.getInstance().getCount() == 13) {
                arr = pray.getOurFinalPrayer(language, title);
                GlobalVar.getInstance().increaseCount();
                seekBar.incrementProgressBy(1);
            } else return;
        }

        customAdapter = new CustomAdapter(getApplicationContext(), arr);
        AVF.setAdapter(customAdapter);

    }


}