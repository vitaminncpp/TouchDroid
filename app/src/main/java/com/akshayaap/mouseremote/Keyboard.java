package com.akshayaap.mouseremote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Keyboard extends AppCompatActivity {

    ImageButton imageButton_SwitchToPad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        imageButton_SwitchToPad = findViewById(R.id.imageButton_SwitchToPad);



        imageButton_SwitchToPad.setOnClickListener(v->{
            startActivity(new Intent(Keyboard.this, TouchPad.class));
        });
    }
}