package com.akshayaap.touchdroid.ui.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.io.Event;
import com.akshayaap.touchdroid.network.UDPSender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Touchpad extends Fragment {
    UDPSender messageSender = null;
    Event event = new Event();
    private int X = 0;
    private int Y = 0;
    private int Xp = 0;
    private int Yp = 0;
    private int dx = 0;
    private int dy = 0;
    private View view;

    public Touchpad() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_touchpad, container, false);

        messageSender = GlobalFactory.getFactory().getMessageSender();

        ConstraintLayout layout = this.view.findViewById(R.id.touchpad);
        layout.setOnTouchListener((v, motionEvent) -> {
            int eventType = motionEvent.getActionMasked();
            //event.reset();
            switch (eventType) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
                case MotionEvent.ACTION_BUTTON_PRESS:
                    break;
                case MotionEvent.ACTION_BUTTON_RELEASE:
                    break;
                case MotionEvent.ACTION_SCROLL:
                    break;
                case MotionEvent.ACTION_UP:
                    Xp = 0;
                    Yp = 0;
                    break;

                case MotionEvent.ACTION_MOVE:
                    X = (int) motionEvent.getX();
                    Y = (int) motionEvent.getY();
                    dx = X - Xp;
                    dy = Y - Yp;
                    if (Xp != 0 && Yp != 0) {
                        event.setDwFlags(Event.MOUSEEVENTF_MOVE);
                        event.setXY(dx, dy);
                        try {
                            messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
                        } catch (IOException e) {
                            GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
                        }
                    }
                    Xp = X;
                    Yp = Y;
                    break;

                default:
                    break;
            }
            return true;
        });
        event.setType(Event.INPUT_MOUSE);
        return this.view;
    }
}