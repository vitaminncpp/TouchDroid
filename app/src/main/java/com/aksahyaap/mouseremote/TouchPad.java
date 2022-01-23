package com.aksahyaap.mouseremote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TouchPad extends AppCompatActivity {
    private int X=0;
    private int Y=0;
    private int Xp=0;
    private int Yp=0;
    private int dx=0;
    private int dy=0;
    private Sender sender;
    private Socket client;
    private PrintWriter pw;
    public MData data;
    public DataOutputStream dos;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_pad);
        TextView txtIP=findViewById(R.id.txtIP);
        TextView txtPort=findViewById(R.id.txtPort);

        data=new MData();

        String ip=getIntent().getStringExtra("ip");
        String port=getIntent().getStringExtra("port");
        Log.i("IP and Port",ip+"   "+port);
        txtIP.setText(ip);
        txtPort.setText(port);
        ProgressDialog dialog=new ProgressDialog(this);

        ConstraintLayout layout =(ConstraintLayout)findViewById(R.id.layout_touchpad);
        dialog.show();

        Log.d("!!!connecting to: ",ip+":"+port);
        new Thread(new clientThread(ip,port)).start();

        dialog.dismiss();

        layout.setOnTouchListener((view, motionEvent) -> {
            int eventType= motionEvent.getActionMasked();
            switch (eventType){

                case MotionEvent.ACTION_MOVE:
                    X= (int) motionEvent.getX();
                    Y= (int) motionEvent.getY();
                    dx=X-Xp;
                    dy=Y-Yp;
                    data.X=X;
                    data.Y=Y;
                    data.dx=dx;
                    data.dy=dy;

                    Xp=X;
                    Yp=Y;
                    Log.d("!!!",data.X+" "+data.Y+" "+data.dx+" "+data.dy);
                    new Thread(new senderThread(data.X+" "+data.Y+" "+data.dx+" "+data.dy)).start();

                    break;
                default:
                    break;
            }
            return true;
        });
    }

    class clientThread implements Runnable{
        String ip;
        String port;
        clientThread(String ip, String port){
            this.ip = ip;
            this.port = port;
        }
        public void run() {
            try {
                Log.d("!!!connecting to: ",ip+":"+port);
                client = new Socket(this.ip, Integer.parseInt(this.port));
                dos = new DataOutputStream(client.getOutputStream());

                new Thread(new senderThread("str1")).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class senderThread implements Runnable{
        String str;
        senderThread(String str){
            this.str = str;
        }
        public void run() {
            try {
                dos.writeBytes(str + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}