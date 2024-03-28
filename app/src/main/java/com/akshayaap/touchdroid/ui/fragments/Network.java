package com.akshayaap.touchdroid.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.network.UDPReceiver;
import com.akshayaap.touchdroid.ui.adapters.WifiListAdapter;
import com.akshayaap.touchdroid.util.Server;
import com.akshayaap.touchdroid.util.TaskCompleteCallback;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Network extends Fragment {
    View view;
    ImageView wifiLogo;
    RecyclerView serverListView;
    WifiListAdapter adapter;
    ArrayList<Server> networkList;
    ConnectionThread connection = new ConnectionThread();

    public Network() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_network, container, false);
        wifiLogo = view.findViewById(R.id.imageView_wifiLogo);
        serverListView = view.findViewById(R.id.serverListView);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_fade_out);
        wifiLogo.startAnimation(animation);
        serverListView.setVisibility(View.VISIBLE);

        networkList = new ArrayList<>();
        adapter = new WifiListAdapter(getContext(), networkList);
        serverListView.setAdapter(adapter);
        serverListView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter.setOnItemClickListener(position -> {
            this.connection.terminate();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new Touchpad());
            fragmentTransaction.commit();
            GlobalFactory.getFactory().createMessageSender(networkList.get(position).getIp());
            GlobalFactory.getFactory().terminateEchoReceiver();
        });
        this.connection.start();
        return view;
    }

    public class ConnectionThread extends Thread {
        boolean isRunning = true;
        byte[] data = new byte[4];
        private InetAddress ipAddress = null;
        UDPReceiver echo = GlobalFactory.getFactory().getEchoReceiver();

        public ConnectionThread() {
            echo.setOnReceivedCallback(new TaskCompleteCallback() {
                @Override
                public void complete() {
                    getActivity().runOnUiThread(new Thread() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        }

        public void run() {
            while (isRunning) {
                synchronized (this) {
                    try {
                        echo.receive(data);
                        Log.i("network", "" + data[0] + '.' + data[1] + '.' + data[2] + '.' + data[3]);
                    } catch (IOException e) {
                        GlobalFactory.getFactory().getLogger().log("networkerr", "Error Recevine Echo:" + e.getMessage());
                    }
                    ipAddress = echo.getPacket().getAddress();
                    if (ipAddress != null) {
                        try {
                            GlobalFactory.getFactory().addServer(new Server(ipAddress.getHostAddress(), ipAddress.getHostName()));
                        } catch (UnknownHostException e) {
                            GlobalFactory.getFactory().getLogger().log("networkerr", "Host Error:" + e.getMessage());
                        }
                        networkList.clear();
                        networkList.addAll(GlobalFactory.getFactory().getServers());
                    }
                }
            }
        }

        public void terminate() {
            this.isRunning = false;
            this.interrupt();
        }
    }
}