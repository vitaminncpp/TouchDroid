package com.akshayaap.mouseremote.abstractfactory;

import com.akshayaap.mouseremote.config.Config;
import com.akshayaap.mouseremote.debug.DebugDatabase;
import com.akshayaap.mouseremote.debug.LoggMessage;
import com.akshayaap.mouseremote.io.KeyMap;
import com.akshayaap.mouseremote.network.UDPReceiver;
import com.akshayaap.mouseremote.network.UDPSender;
import com.akshayaap.mouseremote.debug.Logger;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GlobalFactory {
    //Shared Global Factory
    private static GlobalFactory factory;

    //Factory members
    private UDPSender messageSender;
    private UDPReceiver echoReceiver;

    private KeyMap keyMap;

    //utils
    private Logger logger;
    private DebugDatabase dd;

    private GlobalFactory() {
        keyMap = new KeyMap();
        dd = new DebugDatabase();
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

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public KeyMap getKeyMap() {
        return this.keyMap;
    }
}
