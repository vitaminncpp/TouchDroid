package com.aksahyaap.mouseremote;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_wifiIcon;
    int CON_PORT = 5560;
    int WORK_PORT = 5559;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_wifiIcon = findViewById(R.id.imageView_wifiIcon);
        imageView_wifiIcon.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_fade_out));

        Connecting con = new Connecting();
        Thread conThread = new Thread(con);
        conThread.start();

    }

    public class Connecting implements Runnable {
        public void run() {
            try{
                DatagramSocket serverSocket = new DatagramSocket(CON_PORT);
                byte[] receiveData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                serverSocket.receive(receivePacket);
                InetAddress IPAddress = receivePacket.getAddress();

                Intent myIntent = new Intent(MainActivity.this, TouchPad.class);
                myIntent.putExtra("ip", IPAddress.toString().substring(1));
                myIntent.putExtra("port", String.valueOf(WORK_PORT));
                startActivity(myIntent);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}