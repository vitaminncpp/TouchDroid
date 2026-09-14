package com.akshayaap.touchdroid.io

class Event {

    companion object {
        const val INPUT_MOUSE: Int = 0
        const val INPUT_KEYBOARD: Int = 1
        const val INPUT_HARDWARE: Int = 2

        const val MOUSEEVENTF_MOVE: Int = 0x0001 /* mouse move */
        const val MOUSEEVENTF_LEFTDOWN: Int = 0x0002 /* left button down */
        const val MOUSEEVENTF_LEFTUP: Int = 0x0004 /* left button up */
        const val MOUSEEVENTF_RIGHTDOWN: Int = 0x0008 /* right button down */
        const val MOUSEEVENTF_RIGHTUP: Int = 0x0010 /* right button up */
        const val MOUSEEVENTF_MIDDLEDOWN: Int = 0x0020 /* middle button down */
        const val MOUSEEVENTF_MIDDLEUP: Int = 0x0040 /* middle button up */
        const val MOUSEEVENTF_XDOWN: Int = 0x0080 /* x button down */
        const val MOUSEEVENTF_XUP: Int = 0x0100 /* x button down */
        const val MOUSEEVENTF_WHEEL: Int = 0x0800 /* wheel button rolled */
        const val MOUSEEVENTF_HWHEEL: Int = 0x01000 /* hwheel button rolled */
        const val MOUSEEVENTF_MOVE_NOCOALESCE: Int = 0x2000 /* do not coalesce mouse moves */
        const val MOUSEEVENTF_VIRTUALDESK: Int = 0x4000 /* map to entire virtual desktop */
        const val MOUSEEVENTF_ABSOLUTE: Int = 0x8000 /* absolute move */

        const val KEYEVENTF_EXTENDEDKEY: Int = 0x0001
        const val KEYEVENTF_KEYUP: Int = 0x0002
        const val KEYEVENTF_UNICODE: Int = 0x0004
        const val KEYEVENTF_SCANCODE: Int = 0x0008
    }

    var type: Int = -1
    var dx: Int = -1
    var dy: Int = -1

    var mouseData: Int = -1
    var wVk: Short = -1
    var wScan: Short = -1

    var dwFlags: Int = 0
    var time: Int = 0
    var dwExtraInfo: Int = 0

    init {
        reset()
    }

    fun reset() {
        type = -1
        dx = -1
        dy = -1

        mouseData = -1
        wVk = -1
        wScan = -1

        dwFlags = 0
        time = 0
        dwExtraInfo = 0
    }

    fun setXY(dx: Int, dy: Int) {
        this.dx = dx
        this.dy = dy
    }

    override fun toString(): String {
        return """{
    "type":"$type",
    "dx":"$dx",
    "dy":"$dy",
    "mouseData":"$mouseData",
    "wVk":"$wVk",
    "wScan":"$wScan",
    "dwFlags":"$dwFlags",
    "time":"$time",
    "dwExtraInfo":"$dwExtraInfo"
}"""
    }
}
