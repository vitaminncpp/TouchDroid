package com.akshayaap.mouseremote;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_wifiLogo;
    RecyclerView recyclerView_serverList;
    WifiListAdapter adapter;
    ArrayList<String> tempWifiList;
    HashSet<String> ipList;
    Button scan;
    Button logger;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipList = new HashSet<>(1);

        imageView_wifiLogo = findViewById(R.id.imageView_wifiLogo);
        recyclerView_serverList = findViewById(R.id.recyclerView_serverList);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_fade_out);
        imageView_wifiLogo.startAnimation(animation);

//        NOTE: ADD FUNCTIONALITY HERE!!

//        NOTE: Make Wifi Logo invisible and Make Recycler view Visible when Connections are found
        imageView_wifiLogo.setVisibility(View.GONE);
        recyclerView_serverList.setVisibility(View.VISIBLE);

        tempWifiList = new ArrayList<>();
        tempWifiList.add("asd");
        tempWifiList.add("zxc");
        tempWifiList.add("qwe");

        adapter = new WifiListAdapter(this, tempWifiList);
        recyclerView_serverList.setAdapter(adapter);
        recyclerView_serverList.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(position -> {
//        NOTE: connect to the server here
            Log.d("!!!", "clicked");
        });

        scan = findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

        logger = findViewById(R.id.log);
        logger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Log_button_log", "onClick: Logged");
            }
        });

        new Thread(new TestConn()).start();
    }

    public void addHostToLost(InetAddress ip, String name, int i) {
        this.tempWifiList.add(i, name);
        this.adapter.notifyItemInserted(i);
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private Layout item;
        private InetAddress ip;

        public CustomViewHolder(@NonNull View itemView, @NonNull InetAddress ip) {
            super(itemView);
            this.ip = ip;
        }
    }

    public class Connecting implements Runnable {
        public void run() {
            synchronized (MainActivity.this) {
                InetAddress ipAddress = null;
                DatagramSocket serverSocket = null;
                DatagramPacket receivePacket = null;


                while (true) {
                    try {
                        serverSocket = new DatagramSocket(Config.ECHO_PORT);
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                    byte[] receiveData = new byte[4];

                    receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    ipAddress = receivePacket.getAddress();
                    ipList.add(ipAddress.getHostAddress());
                    try {
                        serverSocket.receive(receivePacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
//
//            Intent myIntent = new Intent(MainActivity.this, TouchPad.class);
//            myIntent.putExtra("ip", ipAddress.toString().substring(1));
//            startActivity(myIntent);
    }

    class TestConn implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    ipList.add("Host: #" + (int) (i / 10));
                    tempWifiList.clear();
                    tempWifiList.addAll(ipList);
                    //adapter.notifyItemInserted(i);
                }
            }
        }
    }
}