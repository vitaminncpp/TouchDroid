package com.akshayaap.mouseremote.network;

import androidx.annotation.NonNull;

import com.akshayaap.mouseremote.util.TaskCompleteCallback;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class UDPSender {
    private DatagramSocket socket = null;
    private DatagramPacket packet = null;

    private boolean onerr = false;
    private IOException ex = null;

    private TaskCompleteCallback onSent = null;

    public UDPSender(InetAddress ip, int port) throws UnknownHostException, SocketException {
        socket = new DatagramSocket(port, ip);
        packet = new DatagramPacket(null, 0);

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
        packet.setLength(data.length);
        packet.setData(data);
        new Thread() {
            @Override
            public void run() {
                try {
                    socket.send(packet);
                    onSent.complete();
                } catch (IOException e) {
                    onerr = true;
                    UDPSender.this.ex = e;
                }
            }
        }.start();
        if (onerr) {
            onerr = false;
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
