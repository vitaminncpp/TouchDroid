package com.akshayaap.mouseremote.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {
    private final InetAddress ip;
    private final String name;

    public Server(String ip, String name) throws UnknownHostException {
        this.ip = InetAddress.getByName(ip);
        this.name = name;
    }

    public Server(InetAddress ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    public InetAddress getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ip\":\"" + ip.getHostAddress() + '\"' +
                ", \"name\":\"" + name + '\"' +
                '}';
    }
}
