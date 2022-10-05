package com.akshayaap.mouseremote;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Sender {

    String data;
    DatagramSocket socket;
    DatagramPacket packet;

    public Sender(InetAddress ip, int port) throws SocketException {
        socket = new DatagramSocket(Config.SERVER_PORT);
        packet = new DatagramPacket(new byte[256], 256);
        packet.setAddress(ip);
        packet.setPort(Config.SERVER_PORT);
    }

    public void send(String data) {
        this.data = data;
        new Thread(new SenderThread()).start();
    }

    public void freeResources() {
        this.socket.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.socket.close();
    }

    class SenderThread implements Runnable {

        @Override
        public void run() {
            packet.setData(data.getBytes(StandardCharsets.UTF_8));
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


