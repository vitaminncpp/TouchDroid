package com.akshayaap.mouseremote.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.akshayaap.mouseremote.config.Config;
import com.akshayaap.mouseremote.R;
import com.akshayaap.mouseremote.network.Sender;
import com.akshayaap.mouseremote.util.Event;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TouchPad extends AppCompatActivity {
    Sender sender;
    int port = 0;
    Event event = new Event();
    InetAddress ip = null;
    private int X = 0;
    private int Y = 0;
    private int Xp = 0;
    private int Yp = 0;
    private int dx = 0;
    private int dy = 0;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_pad);
        port = Config.SERVER_PORT;
        try {
            ip = InetAddress.getByName(getIntent().getStringExtra("ip"));
            sender = new Sender(ip, Config.SERVER_PORT);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }

        ConstraintLayout layout = findViewById(R.id.touchpad);
        ConstraintLayout wheel = findViewById(R.id.wheel);
        ConstraintLayout hWheel = findViewById(R.id.hWheel);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);
        TextView txt_ip_port = findViewById(R.id.txt_ip_port);
        ImageButton imageButton_SwitchToKey = findViewById(R.id.imageButton_SwitchToKey);

        txt_ip_port.setText("Connected to " + ip + " : " + port);

        layout.setOnTouchListener((view, motionEvent) -> {
            int eventType = motionEvent.getActionMasked();
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
                        sender.send(event.toString());
                    }
                    Xp = X;
                    Yp = Y;
                    break;

                default:
                    break;
            }
            return true;
        });

        btnLeft.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            switch (type) {
                case MotionEvent.ACTION_DOWN:
                    event.setDwFlags(Event.MOUSEEVENTF_LEFTDOWN);
                    event.setXY(0, 0);
                    sender.send(event.toString());
                    break;
                case MotionEvent.ACTION_UP:
                    event.setDwFlags(Event.MOUSEEVENTF_LEFTUP);
                    event.setXY(0, 0);
                    sender.send(event.toString());
                    break;
            }
            return true;
        });

        btnRight.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            switch (type) {
                case MotionEvent.ACTION_DOWN:
                    event.setDwFlags(Event.MOUSEEVENTF_RIGHTDOWN);
                    event.setXY(0, 0);
                    sender.send(event.toString());
                    break;
                case MotionEvent.ACTION_UP:
                    event.setDwFlags(Event.MOUSEEVENTF_RIGHTUP);
                    event.setXY(0, 0);
                    sender.send(event.toString());
                    break;
            }
            return true;
        });

        wheel.setOnTouchListener((view, motionEvent) -> {
            int type = motionEvent.getActionMasked();
            switch (type) {
                case MotionEvent.ACTION_UP:
                    Yp = 0;
                    break;
                case MotionEvent.ACTION_MOVE:
                    Y = (int) motionEvent.getY();
                    dy = Y - Yp;
                    if (Yp != 0) {
                        event.setDwFlags(Event.MOUSEEVENTF_WHEEL);
                        event.setMouseData(dy);

                        sender.send(event.toString());
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
            switch (type) {
                case MotionEvent.ACTION_UP:
                    Xp = 0;
                    break;
                case MotionEvent.ACTION_MOVE:
                    X = (int) motionEvent.getX();
                    dx = X - Xp;
                    if (Xp != 0) {
                        event.setDwFlags(Event.MOUSEEVENTF_HWHEEL);
                        event.setMouseData(dx);
                        sender.send(event.toString());
                    }
                    Xp = X;
                    break;
                default:
                    break;
            }
            return true;
        });

        event.setType(Event.INPUT_MOUSE);

        imageButton_SwitchToKey.setOnClickListener(v->{
            startActivity(new Intent(TouchPad.this, Keyboard.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            sender = new Sender(InetAddress.getByName(getIntent().getStringExtra("ip")), Config.SERVER_PORT);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sender.freeResources();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sender.freeResources();
    }
}