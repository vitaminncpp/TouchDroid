package com.akshayaap.mouseremote.util;

public class Event {
    private int type;
    private int dx;
    private int dy;

    private int mouseData;
    private short wVk;
    private short wScan;


    private int dwFlags;
    private int time;
    private int dwExtraInfo;


    public Event(){
        this.reset();
    }

    public void reset(){
        this.type=-1;
        this.dx=-1;
        this.dy=-1;

        this.mouseData=-1;
        this.wVk=-1;
        this.wScan=-1;

        this.dwFlags=0;
        this.time=0;
        this.dwExtraInfo=0;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getMouseData() {
        return mouseData;
    }

    public void setMouseData(int mouseData) {
        this.mouseData = mouseData;
    }

    public short getwVk() {
        return wVk;
    }

    public void setwVk(short wVk) {
        this.wVk = wVk;
    }

    public short getwScan() {
        return wScan;
    }

    public void setwScan(short wScan) {
        this.wScan = wScan;
    }

    public int getDwFlags() {
        return dwFlags;
    }

    public void setDwFlags(int dwFlags) {
        this.dwFlags = dwFlags;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDwExtraInfo() {
        return dwExtraInfo;
    }

    public void setDwExtraInfo(int dwExtraInfo) {
        this.dwExtraInfo = dwExtraInfo;
    }

    @Override
    public String toString() {
        return "{\n"+
                "    \"type\":\"" + type +'\"'+
                ",\n    \"dx\":\"" + dx +'\"'+
                ",\n    \"dy\":\"" + dy +'\"'+
                ",\n    \"mouseData\":\"" + mouseData +'\"'+
                ",\n    \"wVk\":\"" + wVk +'\"'+
                ",\n    \"wScan\":\"" + wScan +'\"'+
                ",\n    \"dwFlags\":\"" + dwFlags +'\"'+
                ",\n    \"time\":\"" + time +'\"'+
                ",\n    \"dwExtraInfo\":\"" + dwExtraInfo +'\"'+
                "\n}";
    }
}
