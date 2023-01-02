package com.akshayaap.touchdroid.abstractfactory;

import com.akshayaap.touchdroid.config.Config;
import com.akshayaap.touchdroid.debug.DebugDatabase;
import com.akshayaap.touchdroid.debug.LoggMessage;
import com.akshayaap.touchdroid.io.KeyMap;
import com.akshayaap.touchdroid.network.UDPReceiver;
import com.akshayaap.touchdroid.network.UDPSender;
import com.akshayaap.touchdroid.debug.Logger;
import com.akshayaap.touchdroid.util.Server;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.Collection;
import java.util.HashMap;

public class GlobalFactory {
    //Shared Global Factory
    private static GlobalFactory factory = new GlobalFactory();

    //Factory members
    private UDPSender messageSender = null;
    private UDPReceiver echoReceiver = null;

    private final KeyMap keyMap;
    private final HashMap<String, Server> servers;

    //utils
    private final Logger logger;
    private final DebugDatabase dd;

    private GlobalFactory() {
        keyMap = new KeyMap();
        dd = new DebugDatabase();
        servers = new HashMap<>();
        logger = new Logger() {
            @Override
            public void log(LoggMessage message) {
                dd.addMessage(message);
            }

            @Override
            public void log(String tag, String message) {
                LoggMessage msg = new LoggMessage(tag, message);
                dd.addMessage(msg);
            }
        };
        init();
    }

    private void init() {
        try {
            this.echoReceiver = new UDPReceiver(Config.ECHO_PORT);
        } catch (SocketException e) {
            LoggMessage message = new LoggMessage("networkerr", "Network Error:" + e.getMessage(), Thread.currentThread().getStackTrace());
            logger.log(message);
        }
    }

    public UDPSender createMessageSender(InetAddress address) {
        if (this.messageSender != null) {
            this.messageSender.close();
        }
        //😆
        try {
            this.messageSender = new UDPSender(address, Config.SERVER_PORT);
        } catch (SocketException e) {
            logger.log("networkerr", "Failed to Create messageSender:" + e.getMessage());
        }
        return this.messageSender;
    }

    //Returns Global Factory
    public static GlobalFactory getFactory() {
        if (factory == null) {
            factory = new GlobalFactory();
        }
        return factory;
    }

    public UDPSender getMessageSender() {
        return this.messageSender;
    }

    public UDPReceiver getEchoReceiver() {
        return this.echoReceiver;
    }

    public void addServer(Server server) {
        this.servers.put(server.getIp().getHostAddress(), server);
    }

    public Logger getLogger() {
        return this.logger;
    }

    public KeyMap getKeyMap() {
        return this.keyMap;
    }

    public Collection<Server> getServers() {
        return this.servers.values();
    }
}
