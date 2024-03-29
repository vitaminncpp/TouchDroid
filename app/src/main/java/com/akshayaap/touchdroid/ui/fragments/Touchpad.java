package com.akshayaap.touchdroid.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.config.Config;
import com.akshayaap.touchdroid.io.Event;
import com.akshayaap.touchdroid.network.UDPSender;
import com.akshayaap.touchdroid.ui.activities.Keyboard;
import com.akshayaap.touchdroid.ui.activities.TouchPad;

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
        ConstraintLayout wheel = this.view.findViewById(R.id.wheel);
        ConstraintLayout hWheel = this.view.findViewById(R.id.hWheel);
        Button btnLeft = this.view.findViewById(R.id.btnLeft);
        Button btnRight = this.view.findViewById(R.id.btnRight);
        TextView txt_ip_port = this.view.findViewById(R.id.txt_ip_port);
        txt_ip_port.setText("Connected to " + messageSender.getPacket().getAddress() + " : " + Config.SERVER_PORT);
        layout.setOnTouchListener((v, motionEvent) -> {
            int eventType = motionEvent.getActionMasked();
            //event.reset();
            switch (eventType) {
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
                            //Log.d("networkerr", "OnSent: Failed to send MotionData");
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
        btnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int type = motionEvent.getActionMasked();
                //event.reset();
                switch (type) {
                    case MotionEvent.ACTION_DOWN:
                        event.setDwFlags(Event.MOUSEEVENTF_LEFTDOWN);
                        event.setXY(0, 0);
                        break;
                    case MotionEvent.ACTION_UP:
                        event.setDwFlags(Event.MOUSEEVENTF_LEFTUP);
                        event.setXY(0, 0);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        return true;

                }
                try {
                    messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
                    //Log.d("networkerr", "OnSent: Failed to send LetfClick");
                }
                return true;
            }
        });


        btnRight.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            //event.reset();
            switch (type) {
                case MotionEvent.ACTION_DOWN:
                    event.setDwFlags(Event.MOUSEEVENTF_RIGHTDOWN);
                    break;
                case MotionEvent.ACTION_UP:
                    event.setDwFlags(Event.MOUSEEVENTF_RIGHTUP);
                    break;
                case MotionEvent.ACTION_MOVE:
                    return true;
            }
            event.setXY(0, 0);
            try {
                messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
                //Log.d("networkerr", "OnSent: Failed to send RightClick");
            }
            return true;
        });

        wheel.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            //event.reset();
            switch (type) {
                case MotionEvent.ACTION_UP:
                    Yp = 0;
                    break;
                case MotionEvent.ACTION_MOVE:
                    Y = (int) motionEvent.getY();
                    dy = Y - Yp;
                    if (Yp != 0) {
                        event.setDwFlags(Event.MOUSEEVENTF_WHEEL);
                        if (dy > 0) {
                            event.setMouseData(1);
                        } else if (dy < 0) {
                            event.setMouseData(-1);
                        }
                        //event.setMouseData(dy);
                        try {
                            messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
                        } catch (IOException e) {
                            GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
                            //Log.d("networkerr", "OnSent: Failed to send WheelData");
                        }
                    }
                    Yp = Y;
                    break;
                default:
                    break;
            }
            return true;
        });

        hWheel.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            //event.reset();
            switch (type) {
                case MotionEvent.ACTION_UP:
                    Xp = 0;
                    break;
                case MotionEvent.ACTION_MOVE:
                    X = (int) motionEvent.getX();
                    dx = X - Xp;
                    if (Xp != 0) {
                        event.setDwFlags(Event.MOUSEEVENTF_HWHEEL);
                        if (dx > 0) {
                            event.setMouseData(1);
                        } else if (dx < 0) {
                            event.setMouseData(-1);
                        }
                        //event.setMouseData(dx);
                        try {
                            messageSender.send(event.toString().getBytes(StandardCharsets.UTF_8));
                        } catch (IOException e) {
                            GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending Event data:" + e.getMessage());
                            //Log.d("networkerr", "OnSent: Failed to send HWheelData");
                        }
                    }
                    Xp = X;
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