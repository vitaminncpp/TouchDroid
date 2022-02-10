package com.aksahyaap.mouseremote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleBtn_Wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleBtn_Wifi = findViewById(R.id.toggleBtn_Wifi);

        toggleBtn_Wifi.setOnClickListener(view -> {
            if(toggleBtn_Wifi.isChecked()){
                Log.d("!!!","on");
            }
            if(!toggleBtn_Wifi.isChecked()){
                Log.d("!!!","off");
            }
        });


    }
}