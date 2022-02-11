package com.aksahyaap.mouseremote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class MainActivity extends AppCompatActivity {
    WifiManager wifiManager;
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;

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

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager = (WifiP2pManager) getApplicationContext().getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(),null);

        mReceiver = new WifiBroadcastReceiver(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        init();

        imgBtn_Wifi.setOnClickListener(view -> {
            if(wifiManager.isWifiEnabled()){
                wifiManager.setWifiEnabled(false);
                changeWIfiColor(false);
                Log.d("!!!","wifiState: "+false);
            }else{
                wifiManager.setWifiEnabled(true);
                changeWIfiColor(true);
                Log.d("!!!","wifiState: "+true);
            }
        });
    }

//    initialize the activity
    public void init(){
        if(wifiManager.isWifiEnabled()){
            changeWIfiColor(true);
            Log.d("!!!","wifiState: "+true);
        }else{
            changeWIfiColor(false);
            Log.d("!!!","wifiState: "+false);
        }
    }

//    change wifi image button color
    public void changeWIfiColor(Boolean flag){
        if(flag){
            DrawableCompat.setTint(DrawableCompat.wrap(imgBtn_Wifi.getDrawable()), ContextCompat.getColor(getApplicationContext(), R.color.primary));
        }else{
            DrawableCompat.setTint(DrawableCompat.wrap(imgBtn_Wifi.getDrawable()), ContextCompat.getColor(getApplicationContext(), R.color.grey));

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}