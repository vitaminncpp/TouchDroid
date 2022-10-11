package com.akshayaap.mouseremote.io;

public class Event {

    public static final int INPUT_MOUSE = 0;
    public static final int INPUT_KEYBOARD = 1;
    public static final int INPUT_HARDWARE = 2;


    public static final int MOUSEEVENTF_MOVE = 0x0001; /* mouse move */
    public static final int MOUSEEVENTF_LEFTDOWN = 0x0002; /* left button down */
    public static final int MOUSEEVENTF_LEFTUP = 0x0004; /* left button up */
    public static final int MOUSEEVENTF_RIGHTDOWN = 0x0008; /* right button down */
    public static final int MOUSEEVENTF_RIGHTUP = 0x0010; /* right button up */
    public static final int MOUSEEVENTF_MIDDLEDOWN = 0x0020; /* middle button down */
    public static final int MOUSEEVENTF_MIDDLEUP = 0x0040; /* middle button up */
    public static final int MOUSEEVENTF_XDOWN = 0x0080; /* x button down */
    public static final int MOUSEEVENTF_XUP = 0x0100; /* x button down */
    public static final int MOUSEEVENTF_WHEEL = 0x0800; /* wheel button rolled */
    //#if (_WIN32_WINNT >= 0x0600);
    public static final int MOUSEEVENTF_HWHEEL = 0x01000; /* hwheel button rolled */

    //#if(WINVER >= 0x0600);
    public static final int MOUSEEVENTF_MOVE_NOCOALESCE = 0x2000;/* do not coalesce mouse moves */

    public static final int MOUSEEVENTF_VIRTUALDESK = 0x4000;/* map to entire virtual desktop */
    public static final int MOUSEEVENTF_ABSOLUTE = 0x8000;/* absolute move */

    public static final int KEYEVENTF_EXTENDEDKEY = 0x0001;
    public static final int KEYEVENTF_KEYUP = 0x0002;
    //#if(_WIN32_WINNT >= 0x0500)
    public static final int KEYEVENTF_UNICODE = 0x0004;
    public static final int KEYEVENTF_SCANCODE = 0x0008;

    private int type;
    private int dx;
    private int dy;

    private int mouseData;
    private short wVk;
    private short wScan;


    private int dwFlags;
    private int time;
    private int dwExtraInfo;


    public Event() {
        this.reset();
    }

    public void reset() {
        this.type = -1;
        this.dx = -1;
        this.dy = -1;

        this.mouseData = -1;
        this.wVk = -1;
        this.wScan = -1;

        this.dwFlags = 0;
        this.time = 0;
        this.dwExtraInfo = 0;
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
        return "{\n" +
                "    \"type\":\"" + type + '\"' +
                ",\n    \"dx\":\"" + dx + '\"' +
                ",\n    \"dy\":\"" + dy + '\"' +
                ",\n    \"mouseData\":\"" + mouseData + '\"' +
                ",\n    \"wVk\":\"" + wVk + '\"' +
                ",\n    \"wScan\":\"" + wScan + '\"' +
                ",\n    \"dwFlags\":\"" + dwFlags + '\"' +
                ",\n    \"time\":\"" + time + '\"' +
                ",\n    \"dwExtraInfo\":\"" + dwExtraInfo + '\"' +
                "\n}";
    }

    public void setXY(int dx, int dy) {
        this.dx=dx;
        this.dy=dy;
    }
}
