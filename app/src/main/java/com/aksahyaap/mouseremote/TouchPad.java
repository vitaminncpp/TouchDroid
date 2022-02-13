package com.aksahyaap.mouseremote;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TouchPad extends AppCompatActivity {
    private int X = 0;
    private int Y = 0;
    private int Xp = 0;
    private int Yp = 0;
    private int dx = 0;
    private int dy = 0;
    private Socket client;

    public DataOutputStream dos;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_pad);

        String ip = getIntent().getStringExtra("ip");
        String port = getIntent().getStringExtra("port");

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();

        ConstraintLayout layout = findViewById(R.id.touchpad);
        ConstraintLayout wheel = findViewById(R.id.wheel);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);
        TextView txt_ip_port = findViewById(R.id.txt_ip_port);

        txt_ip_port.setText("Connected to "+ip+" : "+port);

        new Thread(new clientThread(ip, port)).start();

        dialog.dismiss();

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
                        new Thread(new senderThread(String.format("%6d    %6d    M      end",dx,dy))).start();

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
                    new Thread(new senderThread("     0         0    L          end")).start();
                    break;
                case MotionEvent.ACTION_UP:
                    new Thread(new senderThread("     0         0    l      end")).start();
                    break;
            }

            return true;
        });




        btnRight.setOnTouchListener((view, motionEvent) -> {
            int type=motionEvent.getActionMasked();
            switch(type){
                case MotionEvent.ACTION_DOWN:
                    new Thread(new senderThread("     0         0    R      end")).start();
                    break;
                case MotionEvent.ACTION_UP:
                    new Thread(new senderThread("     0         0    r      end")).start();
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
                        new Thread(new senderThread(String.format("%6d         0    W      end", dy))).start();
                    Yp = Y;
                    break;
                default:
                    break;
            }
            return true;
        });
    }


    class clientThread implements Runnable {
        String ip;
        String port;

        clientThread(String ip, String port) {
            this.ip = ip;
            this.port = port;
        }

        public void run() {
            try {
                client = new Socket(this.ip, Integer.parseInt(this.port));
                dos = new DataOutputStream(client.getOutputStream());

                //new Thread(new senderThread("str1")).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class senderThread implements Runnable {
        String str;

        senderThread(String str) {
            this.str = str;
        }

        public void run() {
            try {
                dos.writeBytes(str );
                Log.i("String", String.valueOf(str.length()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}