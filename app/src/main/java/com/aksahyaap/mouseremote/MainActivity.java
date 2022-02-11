package com.aksahyaap.mouseremote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class MainActivity extends AppCompatActivity {
    WifiManager wifiManager;
    ImageButton imgBtn_Wifi;
    EditText editText_inputIP;
    ImageButton imgBtn_ManualIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        imgBtn_Wifi = findViewById(R.id.imgBtn_Wifi);
        editText_inputIP = findViewById(R.id.editText_inputIP);
        imgBtn_ManualIP = findViewById(R.id.imgBtn_ManualIP);

        init();

        imgBtn_Wifi.setOnClickListener(view -> {
            if(wifiManager.isWifiEnabled()){
                wifiManager.setWifiEnabled(false);
                changeWIfiColor(false);
                Log.d("!!!","wifiState: "+false);
            }else{
                wifiManager.setWifiEnabled(true);
                changeWIfiColor(true);
                Log.d("!!!","wifiState: "+true);
            }
        });
    }

//    initialize the activity
    public void init(){
        if(wifiManager.isWifiEnabled()){
            changeWIfiColor(true);
            Log.d("!!!","wifiState: "+true);
        }else{
            changeWIfiColor(false);
            Log.d("!!!","wifiState: "+false);
        }
    }

//    change wifi image button color
    public void changeWIfiColor(Boolean flag){
        if(flag){
            DrawableCompat.setTint(DrawableCompat.wrap(imgBtn_Wifi.getDrawable()), ContextCompat.getColor(getApplicationContext(), R.color.primary));
        }else{
            DrawableCompat.setTint(DrawableCompat.wrap(imgBtn_Wifi.getDrawable()), ContextCompat.getColor(getApplicationContext(), R.color.grey));

        }
    }
}