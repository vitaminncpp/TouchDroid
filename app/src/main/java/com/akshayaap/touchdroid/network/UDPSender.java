package com.akshayaap.touchdroid.network;

import androidx.annotation.NonNull;

import com.akshayaap.touchdroid.util.TaskCompleteCallback;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender {
    private DatagramSocket socket = null;
    private DatagramPacket packet = null;

    private boolean onErr = false;
    private IOException ex = null;

    private TaskCompleteCallback onSent = null;

    public UDPSender(InetAddress ip, int port) throws SocketException {
        socket = new DatagramSocket(port);
        packet = new DatagramPacket(new byte[1024], 1024);
        packet.setAddress(ip);
        packet.setPort(port);

        onSent = new TaskCompleteCallback() {
            @Override
            public void complete() {
                //TODO Nothing
            }
        };
    }

    public UDPSender() throws SocketException {
        socket = new DatagramSocket();
        packet = new DatagramPacket(null, 0);
    }

    public void send(@NonNull byte[] data) throws IOException {
        packet.setData(data);
        packet.setLength(data.length);
        new Thread() {
            @Override
            public void run() {
                try {
                    socket.send(packet);
                    onSent.complete();
                } catch (IOException e) {
                    onErr = true;
                    UDPSender.this.ex = e;
                }
            }
        }.start();
        if (onErr) {
            onErr = false;
            throw ex;
        }
    }

    public void setOnSentCallback(TaskCompleteCallback onSent) {
        this.onSent = onSent;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.socket.close();
    }

    public void close() {
        socket.close();
    }

    public DatagramPacket getPacket() {
        return packet;
    }
}
