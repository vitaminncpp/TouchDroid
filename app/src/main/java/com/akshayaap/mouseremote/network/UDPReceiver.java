package com.akshayaap.mouseremote.network;

import com.akshayaap.mouseremote.util.TaskCompleteCallback;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {

    private DatagramSocket socket = null;
    private DatagramPacket packet = null;

    private boolean onerr = false;
    private IOException ex = null;
    private TaskCompleteCallback onReceived = null;


    public UDPReceiver() throws SocketException {
        socket = new DatagramSocket();
        packet = new DatagramPacket(null, 0);
        onReceived = new TaskCompleteCallback() {
            @Override
            public void complete() {
                //TODO Nothing
            }
        };
    }

    public UDPReceiver(int port) throws SocketException {
        socket = new DatagramSocket(port);
        packet = new DatagramPacket(null, 0);
        packet.setPort(port);
        this.onReceived = new TaskCompleteCallback() {
            @Override
            public void complete() {
                //TODO Nothing
            }
        };
    }

    public void receive(byte[] buff) throws IOException {
        packet.setLength(buff.length);
        packet.setData(buff);

        new Thread() {
            @Override
            public void run() {
                try {
                    socket.receive(packet);
                    onReceived.complete();
                } catch (IOException e) {
                    onerr = true;
                    UDPReceiver.this.ex = e;
                }
            }
        }.start();
        if (onerr) {
            onerr = false;
            throw this.ex;
        }
    }

    public void receive(byte[] buff, TaskCompleteCallback onReceived) throws IOException {
        TaskCompleteCallback temp = this.onReceived;
        this.onReceived = onReceived;
        receive(buff);
        this.onReceived = temp;
    }

    public void setOnReceivedCallback(TaskCompleteCallback onReceived) {
        this.onReceived = onReceived;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        socket.close();
    }

    public void close() {
        socket.close();
    }

    public DatagramPacket getPacket() {
        return packet;
    }
}
