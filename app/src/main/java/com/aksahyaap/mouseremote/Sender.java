package com.aksahyaap.mouseremote;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender extends AsyncTask<String, Void, PrintWriter> {


    @Override
    protected PrintWriter doInBackground(String... strings) {
        Socket s=null;
        PrintWriter pw=null;
        try {
            Log.d("!!!!","sending data");
            s = new Socket(strings[0],Integer.parseInt(strings[1]));
            pw=new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pw;
    }




}



