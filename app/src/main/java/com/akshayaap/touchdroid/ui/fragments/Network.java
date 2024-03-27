package com.akshayaap.touchdroid.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.ui.activities.MainActivity;
import com.akshayaap.touchdroid.ui.activities.MasterActivity;
import com.akshayaap.touchdroid.ui.adapters.WifiListAdapter;
import com.akshayaap.touchdroid.util.Server;

import java.util.ArrayList;

public class Network extends Fragment {
    View view;
    ImageView imageView_wifiLogo;
    RecyclerView recyclerView_serverList;
    WifiListAdapter adapter;
    ArrayList<Server> tempWifiList;
    MainActivity.Connecting conn;

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
        imageView_wifiLogo = view.findViewById(R.id.imageView_wifiLogo);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_fade_out);
        imageView_wifiLogo.startAnimation(animation);

        return view;

    }
}