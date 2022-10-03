package com.akshayaap.mouseremote;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mouseremote.WifiListAdapter;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_wifiLogo;
    RecyclerView recyclerView_serverList;
    ArrayList<String> tempWifiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_wifiLogo = findViewById(R.id.imageView_wifiLogo);
        recyclerView_serverList = findViewById(R.id.recyclerView_serverList);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_fade_out);
        imageView_wifiLogo.startAnimation(animation);

//        NOTE: ADD FUNCTIONALITY HERE!!
/*
//        NOTE: Make Wifi Logo invisible and Make Recycler view Visible when Connections are found
        imageView_wifiLogo.setVisibility(View.GONE);
        recyclerView_serverList.setVisibility(View.VISIBLE);

        tempWifiList = new ArrayList<>();
        tempWifiList.add("asd");
        tempWifiList.add("zxc");
        tempWifiList.add("qwe");

        WifiListAdapter wifiListAdapter = new WifiListAdapter(this, tempWifiList);
        recyclerView_serverList.setAdapter(wifiListAdapter);
        recyclerView_serverList.setLayoutManager(new LinearLayoutManager(this));

        wifiListAdapter.setOnItemClickListener(position -> {
//        NOTE: connect to the server here
            Log.d("!!!","clicked");
        });
*/
        Connecting con = new Connecting();
        Thread conThread = new Thread(con);
        conThread.start();
    }

    public class Connecting implements Runnable {
        public void run() {
            try {
                DatagramSocket serverSocket = new DatagramSocket(Config.ECHO_PORT);
                byte[] receiveData = new byte[4];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);
                InetAddress IPAddress = receivePacket.getAddress();

                Intent myIntent = new Intent(MainActivity.this, TouchPad.class);
                myIntent.putExtra("ip", IPAddress.toString().substring(1));
                startActivity(myIntent);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private Layout item;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}