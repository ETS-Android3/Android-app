package com.example.rosary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();
    }
}