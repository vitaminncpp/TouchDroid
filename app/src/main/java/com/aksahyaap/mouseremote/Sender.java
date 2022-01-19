package com.aksahyaap.mouseremote;


import android.os.AsyncTask;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender extends AsyncTask<Void, Void, Void> {

    private String ip;
    private int port;
    private Socket s;
    PrintWriter pw;
    public MData data;

    public Sender(String ip, int port, MData data) throws IOException {
        this.ip = ip;
        this.port = port;
        this.data = data;
    }

    public void send(int X, int Y) {

    }

    public void send(String msg) {
        pw.println(msg);
    }

    @Override
    protected Void doInBackground(Void... voids) {


        try {
            s = new Socket(ip, port);
            pw = new PrintWriter(s.getOutputStream());
            Log.i("SuccessStatus", "After Creating Socket");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {


            pw.println(data.X + " " + data.Y);
            pw.println(data.dx + " " + data.dy);

        }
    }

}



