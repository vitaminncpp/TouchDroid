package com.aksahyaap.mouseremote;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
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

        imgBtn_Wifi = findViewById(R.id.imgBtn_Wifi);
        editText_inputIP = findViewById(R.id.editText_inputIP);
        imgBtn_ManualIP = findViewById(R.id.imgBtn_ManualIP);

        imgBtn_Wifi.setOnClickListener(view -> {
            changeWIfiColor();
        });
    }

    public void changeWIfiColor(){
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(getApplicationContext(), R.drawable.ic_baseline_wifi_enable);
        assert unwrappedDrawable != null;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(DrawableCompat.wrap(unwrappedDrawable), getResources().getColor(R.color.grey));
    }
}