package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor edit;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //setTitle("Settings");
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //assert getSupportActionBar() != null;

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();

        String res = pref.getString("saved_title", "false");

        switch1 = (Switch) findViewById(R.id.switch4);
        if(res.equals("true")){
            switch1.setChecked(true);
        }
        else{
            switch1.setChecked(false);
        }


        switch1.setOnCheckedChangeListener(this::OnCheckedChanged);
    }

    public void OnCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            edit.putString("saved_title", "true");
            edit.apply();
        }
        else{
            edit.putString("saved_title", "false");
            edit.apply();
        }
    }

    public void showPopUp(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }

    public void showPopUp2(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup2);
        popup.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
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