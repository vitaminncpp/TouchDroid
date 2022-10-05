package com.akshayaap.mouseremote;

import android.content.Intent;
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
    Connecting conn = null;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipList = new HashSet<>(1);
        conn = new Connecting();

        imageView_wifiLogo = findViewById(R.id.imageView_wifiLogo);
        recyclerView_serverList = findViewById(R.id.recyclerView_serverList);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_fade_out);
        imageView_wifiLogo.startAnimation(animation);

//        NOTE: ADD FUNCTIONALITY HERE!!

//        NOTE: Make Wifi Logo invisible and Make Recycler view Visible when Connections are found
        //imageView_wifiLogo.setVisibility(View.GONE);
        recyclerView_serverList.setVisibility(View.VISIBLE);

        tempWifiList = new ArrayList<>();
        adapter = new WifiListAdapter(this, tempWifiList);
        recyclerView_serverList.setAdapter(adapter);
        recyclerView_serverList.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new WifiListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("!!!", "onItemClick: " + tempWifiList.get(position));
                Intent myIntent = new Intent(MainActivity.this, TouchPad.class);
                myIntent.putExtra("ip", tempWifiList.get(position));
                conn.freeResources();
                startActivity(myIntent);
            }
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


//        new Thread(new TestConn()).start();
        new Thread(conn).start();
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
        byte[] receiveData = new byte[4];
        private InetAddress ipAddress = null;
        private DatagramSocket serverSocket = null;
        private DatagramPacket receivePacket = null;


        public Connecting() {
            try {
                serverSocket = new DatagramSocket(Config.ECHO_PORT);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
        }

        public void run() {

            while (true) {
                synchronized (MainActivity.this) {
                    try {
                        serverSocket.receive(receivePacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ipAddress = receivePacket.getAddress();
                    ipList.add(ipAddress.getHostAddress());
                    tempWifiList.clear();
                    tempWifiList.addAll(ipList);
                }
            }

        }

        public void freeResources() {
            if (serverSocket != null) {
                this.serverSocket.close();
            }
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            this.serverSocket.close();
        }
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