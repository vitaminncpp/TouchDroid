package com.akshayaap.mouseremote.network;

import androidx.annotation.NonNull;

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

    public UDPSender(String ip, int port) throws UnknownHostException, SocketException {
        socket = new DatagramSocket(port, InetAddress.getByName(ip));
        packet = new DatagramPacket(null, 256);
    }

    public UDPSender() {
    }

    public void send(@NonNull String data) throws IOException {
        packet.setData(data.getBytes(StandardCharsets.UTF_8));
        new Thread() {
            @Override
            public void run() {
                try {
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
