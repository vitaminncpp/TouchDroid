package com.aksahyaap.mouseremote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {
    TextView textView_waitingForCon;
    int CON_PORT = 5560;
    int WORK_PORT = 5559;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_waitingForCon = findViewById(R.id.textView_waitingForCon);
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