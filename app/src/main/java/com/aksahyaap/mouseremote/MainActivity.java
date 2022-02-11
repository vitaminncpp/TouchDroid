package com.aksahyaap.mouseremote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    ImageButton imgBtn_Wifi;
    EditText editText_inputIP;
    ImageButton imgBtn_ManualIP;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn_Wifi = findViewById(R.id.imgBtn_Wifi);
        editText_inputIP = findViewById(R.id.editText_inputIP);
        imgBtn_ManualIP = findViewById(R.id.imgBtn_ManualIP);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        setWifiCol(wifiManager.isWifiEnabled()?1:0);

        imgBtn_Wifi.setOnClickListener(view -> {
            if(wifiManager.isWifiEnabled()){
                wifiManager.setWifiEnabled(false);
                Toast.makeText(getApplicationContext(), "disabling wifi", Toast.LENGTH_SHORT).show();
            } else {
                wifiManager.setWifiEnabled(true);
                Toast.makeText(getApplicationContext(), "enabling wifi", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
            }
        });

        String ip = "";
        while(!intToInetAddress(wifiManager.getDhcpInfo().gateway).toString().equals("/0.0.0.0")){
            ip = intToInetAddress(wifiManager.getDhcpInfo().gateway) + "";
        }
        Log.d("!!!",ip);

    }

    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    void setWifiCol(int val){
        switch (val){
            case 1: DrawableCompat.setTint(imgBtn_Wifi.getDrawable(), ContextCompat.getColor(getApplicationContext(), R.color.primary));break;
            case 2: DrawableCompat.setTint(imgBtn_Wifi.getDrawable(), ContextCompat.getColor(getApplicationContext(), R.color.primary_dark));break;
            default: DrawableCompat.setTint(imgBtn_Wifi.getDrawable(), ContextCompat.getColor(getApplicationContext(), R.color.grey));break;
        }
    }

    public InetAddress intToInetAddress(int hostAddress) {
        byte[] addressBytes = {(byte) (0xff & hostAddress),
                (byte) (0xff & (hostAddress >> 8)),
                (byte) (0xff & (hostAddress >> 16)),
                (byte) (0xff & (hostAddress >> 24))};
        try
        {
            return InetAddress.getByAddress(addressBytes);
        }
        catch (UnknownHostException e)
        {
            throw new AssertionError();
        }
    }

    public BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra){
                case WifiManager.WIFI_STATE_ENABLED:
                    setWifiCol(1);
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    setWifiCol(0);
                    break;
            }
        }
    };
}