package com.akshayaap.mouseremote.abstractfactory;

public class GlobalFactory {

    private static GlobalFactory factory = new GlobalFactory();


    private GlobalFactory() {

    }

    public static GlobalFactory getFactory() {
        return factory;
    }

}
