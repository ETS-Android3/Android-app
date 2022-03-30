package com.app.rosary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor edit;
    private Switch switch1;
    private Switch switch2;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //setTitle("Settings");
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        count = GlobalVar.getInstance().getIndex();

        //assert getSupportActionBar() != null;

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();

        String res = pref.getString("saved_title", "false");

        switch1 = (Switch) findViewById(R.id.switchPray);
        if(res.equals("true")){
            switch1.setChecked(true);
        }
        else{
            switch1.setChecked(false);
        }

        String resfatima = pref.getString("saved_fatima", "false");

        switch2 = (Switch) findViewById(R.id.switchFatima);

        if(resfatima.equals("true")){
            switch2.setChecked(true);
        }
        else{
            switch2.setChecked(false);
        }

        switch1.setOnCheckedChangeListener(this::OnCheckedChanged);
        switch2.setOnCheckedChangeListener(this::OnCheckedChanged);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rosary:
                if(count == 0)
                    startActivity(new Intent(SettingsActivity.this, FirstRosaryActivity.class));
                else if(count < 4)
                    startActivity(new Intent(SettingsActivity.this, SecondRosaryActivity.class));
                else
                    startActivity(new Intent(SettingsActivity.this, ThirdRosaryActivity.class));
                break;
            case R.id.mystery:
                startActivity(new Intent(SettingsActivity.this, Mysteries.class));
                break;
            case R.id.home:
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.switchPray) {
            if (isChecked) {
                edit.putString("saved_title", "true");
                edit.apply();
            } else {
                edit.putString("saved_title", "false");
                edit.apply();
            }
        }
        if (buttonView.getId() == R.id.switchFatima) {
            if (isChecked) {
                edit.putString("saved_fatima", "true");
                edit.apply();
            } else {
                edit.putString("saved_fatima", "false");
                edit.apply();
            }
        }
    }

    public void showPopUp(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }

    public void showPopUp2(View v){
        PopupMenu popup2 = new PopupMenu(this, v);
        popup2.setOnMenuItemClickListener(this);
        popup2.inflate(R.menu.menu_popup2);
        popup2.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.vslow:
                edit.putString("saved_speed", "VSlow");
                edit.apply();
                return true;
            case R.id.fast:
                edit.putString("saved_speed", "Fast");
                edit.apply();
                return true;
            case R.id.slow:
                edit.putString("saved_speed", "Slow");
                edit.apply();
                return true;
            case R.id.normal:
                edit.putString("saved_speed", "Normal");
                edit.apply();
                return true;
            case R.id.eng:
                edit.putString("saved_language", "English");
                edit.apply();
                return true;
            case R.id.fren:
                edit.putString("saved_language", "French");
                edit.apply();
                return true;
            case R.id.span:
                edit.putString("saved_language", "Spanish");
                edit.apply();
                return true;

        }
        return false;
    }
}