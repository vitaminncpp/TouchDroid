package com.akshayaap.mouseremote.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
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
import com.akshayaap.mouseremote.util.Server;
import com.akshayaap.mouseremote.util.TaskCompleteCallback;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_wifiLogo;
    RecyclerView recyclerView_serverList;
    WifiListAdapter adapter;
    ArrayList<Server> tempWifiList;
    Connecting conn = new Connecting();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            try {
                GlobalFactory.getFactory().createMessageSender(tempWifiList.get(position).getIp());
            } catch (SocketException | UnknownHostException e) {
                GlobalFactory.getFactory().getLogger().log("networkerr", "Host Not found:" + e.getMessage());
            }
            startActivity(myIntent);
        });


        conn.start();
        // new Thread(new TestConn()).start();
        // new Thread(conn).start();
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

        public Connecting() {
            echo.setOnReceivedCallback(new TaskCompleteCallback() {
                @Override
                public void complete() {
                    runOnUiThread(new Thread() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        }

        public void run() {

            while (true) {
                synchronized (MainActivity.this) {
                    try {
                        echo.receive(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ipAddress = echo.getPacket().getAddress();
                    if (ipAddress != null) {
                        try {
                            GlobalFactory.getFactory().addServer(new Server(ipAddress.getHostAddress(), ipAddress.getHostName()));
                        } catch (UnknownHostException e) {
                            GlobalFactory.getFactory().getLogger().log("networkerr", "Host Error:" + e.getMessage());
                        }
                        tempWifiList.clear();
                        tempWifiList.addAll(GlobalFactory.getFactory().getServers());
                    }
                }
            }
        }

    }


}