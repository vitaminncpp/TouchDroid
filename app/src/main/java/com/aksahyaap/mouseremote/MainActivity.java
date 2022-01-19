package com.aksahyaap.mouseremote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mainTxtIP = findViewById(R.id.mainTxtIP);
        EditText mainTxtPort = findViewById(R.id.mainNumPort);


        Button button = findViewById(R.id.btnConnect);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = mainTxtIP.getText().toString().trim();
                String port = mainTxtPort.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, TouchPad.class);
                intent.putExtra("ip", ip);
                intent.putExtra("port", port);

                startActivity(intent);
            }
        });
    }
}