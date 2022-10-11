package com.akshayaap.mouseremote.ui.activities;

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

import com.akshayaap.mouseremote.abstractfactory.GlobalFactory;
import com.akshayaap.mouseremote.config.Config;
import com.akshayaap.mouseremote.R;
import com.akshayaap.mouseremote.debug.LoggMessage;
import com.akshayaap.mouseremote.network.UDPReceiver;
import com.akshayaap.mouseremote.ui.adapters.WifiListAdapter;

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
    Connecting conn=new Connecting();
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
        //imageView_wifiLogo.setVisibility(View.GONE);
        recyclerView_serverList.setVisibility(View.VISIBLE);

        tempWifiList = new ArrayList<>();
        adapter = new WifiListAdapter(this, tempWifiList);
        recyclerView_serverList.setAdapter(adapter);
        recyclerView_serverList.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(position -> {
            conn.interrupt();
            Log.d("!!!", "onItemClick: " + tempWifiList.get(position));
            Intent myIntent = new Intent(MainActivity.this, TouchPad.class);
            myIntent.putExtra("ip", tempWifiList.get(position));
            startActivity(myIntent);
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

        conn.start();
        // new Thread(new TestConn()).start();
        // new Thread(conn).start();
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

    public class Connecting extends Thread {
        byte[] data = new byte[4];
        private InetAddress ipAddress = null;
        UDPReceiver echo = GlobalFactory.getFactory().getEchoReceiver();

        public void run() {

            while (true) {
                synchronized (MainActivity.this) {
                    try {
                        echo.receive(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ipAddress = echo.getPacket().getAddress();
                    ipList.add(ipAddress.getHostAddress());
                    tempWifiList.clear();
                    tempWifiList.addAll(ipList);
                }
            }
        }

    }


}