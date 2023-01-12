package com.akshayaap.touchdroid.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.config.Config;
import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.io.Event;
import com.akshayaap.touchdroid.network.UDPSender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TouchPad extends AppCompatActivity {
    UDPSender messageSender = null;
    Event event = new Event();
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
        messageSender = GlobalFactory.getFactory().getMessageSender();

        ConstraintLayout layout = findViewById(R.id.touchpad);
        ConstraintLayout wheel = findViewById(R.id.wheel);
        ConstraintLayout hWheel = findViewById(R.id.hWheel);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);
        TextView txt_ip_port = findViewById(R.id.txt_ip_port);
        ImageButton imageButton_SwitchToKey = findViewById(R.id.imageButton_SwitchToKey);


        txt_ip_port.setText("Connected to " + messageSender.getPacket().getAddress() + " : " + Config.SERVER_PORT);
        layout.setOnTouchListener((view, motionEvent) -> {
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

        imageButton_SwitchToKey.setOnClickListener(v -> {
            startActivity(new Intent(TouchPad.this, Keyboard.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}