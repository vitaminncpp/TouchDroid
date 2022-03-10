package com.akshayaap.mouseremote;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import com.akshayaap.mouseremote.R;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TouchPad extends AppCompatActivity {
    private int X = 0;
    private int Y = 0;
    private int Xp = 0;
    private int Yp = 0;
    private int dx = 0;
    private int dy = 0;
    Sender sender;


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_pad);

        String ip = getIntent().getStringExtra("ip");
        String port = Integer.toString(Config.SERVER_PORT);

        try {
            sender=new Sender(InetAddress.getByName(ip),Config.SERVER_PORT );
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ConstraintLayout layout = findViewById(R.id.touchpad);
        ConstraintLayout wheel = findViewById(R.id.wheel);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);
        TextView txt_ip_port = findViewById(R.id.txt_ip_port);

        txt_ip_port.setText("Connected to "+ip+" : "+port);



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
                    if (Xp != 0 && Yp != 0)
                        sender.send(String.format( "%6d    %6d    M      end",dx,dy));

                    Xp = X;
                    Yp = Y;


                    break;
                default:
                    break;
            }
            return true;
        });


        btnLeft.setOnTouchListener((view, motionEvent) -> {

            int type=motionEvent.getActionMasked();
            switch(type){
                case MotionEvent.ACTION_DOWN:
                    sender.send("     0         0    L          end");

                    break;
                case MotionEvent.ACTION_UP:
                    sender.send("     0         0    l      end");

                    break;
            }

            return true;
        });




        btnRight.setOnTouchListener((view, motionEvent) -> {
            int type=motionEvent.getActionMasked();
            switch(type){
                case MotionEvent.ACTION_DOWN:
                    sender.send("     0         0    R      end");

                    break;
                case MotionEvent.ACTION_UP:
                    sender.send("     0         0    r      end");

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
                    if (Yp != 0)
                        sender.send(String.format("%6d         0    W      end", dy));

                    Yp = Y;
                    break;
                default:
                    break;
            }
            return true;
        });
    }

}