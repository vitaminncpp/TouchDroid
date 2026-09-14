package com.akshayaap.touchdroid.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.io.Event;
import com.akshayaap.touchdroid.network.UDPSender;
import com.akshayaap.touchdroid.service.TouchPadService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Touchpad extends Fragment {
    UDPSender messageSender = null;
    private int X = 0;
    private int Y = 0;
    private int Xp = 0;
    private int Yp = 0;
    private int dx = 0;
    private int dy = 0;
    private View view;
    private final TouchPadService touchPadService;

    public Touchpad() {
        this.touchPadService = new TouchPadService(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_touchpad, container, false);

        messageSender = GlobalFactory.getFactory().getMessageSender();
        ConstraintLayout layout = this.view.findViewById(R.id.touchpad);
        layout.setOnTouchListener(this.touchPadService.getTouchListener());
        return this.view;
    }

    public boolean sendEvent(Event event) {
        try {
            messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
            return false;
        }
        return true;
    }
}