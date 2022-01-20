package com.aksahyaap.mouseremote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TouchPad extends AppCompatActivity {

    private int X=0;
    private int Y=0;
    private int Xp=0;
    private int Yp=0;
    private int dx=0;
    private int dy=0;
    private Sender sender;
    private PrintWriter pw;
    public MData data;
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
        Log.i("IPandPort",ip+"   "+port);
        txtIP.setText(ip);
        txtPort.setText(port);
        ProgressDialog dialog=new ProgressDialog(this);

        ConstraintLayout layout =(ConstraintLayout)findViewById(R.id.layout_touchpad);
        dialog.show();
        Socket s=null;

        try {
            s = new Socket(ip,Integer.parseInt(port));
            pw=new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.dismiss();

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int eventType= motionEvent.getActionMasked();
                switch (eventType){

                    case MotionEvent.ACTION_MOVE:

                        Log.i("TouchEvents","ActionMove");
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
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}