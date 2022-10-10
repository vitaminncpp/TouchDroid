package com.akshayaap.mouseremote.abstractfactory;

import com.akshayaap.mouseremote.config.Config;
import com.akshayaap.mouseremote.network.UDPReceiver;
import com.akshayaap.mouseremote.network.UDPSender;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GlobalFactory {
    //Shared Global Factory
    private static GlobalFactory factory = new GlobalFactory();

    //Factory members
    private UDPSender messageSender;
    private UDPReceiver echoReceiver;

    private GlobalFactory() {

    }

    public void createMessageSender(InetAddress address) throws SocketException, UnknownHostException {
        if (this.messageSender != null) {
            this.messageSender.close();
        }
        //😆
        this.messageSender = new UDPSender(address, Config.SERVER_PORT);
    }

    //Returns Global Factory
    public static GlobalFactory getFactory() {
        return factory;
    }

    public UDPSender getMessageSender() {
        return this.messageSender;
    }

    public UDPReceiver getEchoReceiver() {
        return this.echoReceiver;
    }
}
