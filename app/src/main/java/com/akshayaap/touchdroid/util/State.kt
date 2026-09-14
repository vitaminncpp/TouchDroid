package com.akshayaap.touchdroid.util;

public class State {
    private int state = -1;
    private int prevState = -1;
    private int pCount = 0;
    private int prevCount = 0;
    private int time = 0; // in milliseconds
    private int prevTime = 0; // in milliseconds
    private int event = -1;
    private int prevEvent = -1;

    public State() {

    }

    public synchronized int getState() {
        return this.state;
    }

    public synchronized void setState(int state) {
        this.prevState = this.state;
        this.state = state;
    }

    public synchronized int getPrevState() {
        return this.prevState;
    }

    public synchronized void setPrevState(int state) {
        this.prevState = state;
    }

    public synchronized void setCount(int count) {
        this.prevCount = this.pCount;
        this.pCount = count;
    }

    public synchronized int getCount(int count) {
        return this.pCount;
    }

    public synchronized int getPrevCount() {
        return this.prevCount;
    }

    public synchronized void setPrevCount(int count) {
        this.prevCount = count;
    }

    public synchronized int getTime() {
        return this.time;
    }

    public synchronized void setTime(int time) {
        this.prevTime = this.time;
        this.time = time;
    }

    public synchronized int getEvent() {
        return event;
    }

    public synchronized void setEvent(int event) {
        this.prevEvent = this.event;
        this.event = event;

    }

    public synchronized int getPrevEvent() {
        return prevEvent;
    }

    public synchronized void setPrevEvent(int prevEvent) {
        this.prevEvent = prevEvent;
    }
}
