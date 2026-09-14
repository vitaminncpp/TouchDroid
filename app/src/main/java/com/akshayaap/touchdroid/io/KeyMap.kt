package com.akshayaap.touchdroid.io

class KeyMap {

    companion object {
        // mouse
        const val VK_L_MOUSE: Short = 0x01
        const val VK_R_MOUSE: Short = 0x02
        const val VK_CANCEL: Short = 0x03
        const val VK_M_MOUSE: Short = 0x04
        const val VK_X1_MOUSE: Short = 0x05
        const val VK_X2_MOUSE: Short = 0x06

        // other
        const val VK_UNDEFINED_7: Short = 0x07
        // System
        const val VK_BACK: Short = 0x08
        const val VK_TAB: Short = 0x09
        const val VK_RESERVED_A: Short = 0x0A
        const val VK_RESERVED_B: Short = 0x0B
        const val VK_CLEAR: Short = 0x0C
        const val VK_RETURN: Short = 0x0D

        const val VK_UNDEFINE_E: Short = 0x0E
        const val VK_UNDEFINE_F: Short = 0x0F
        const val VK_SHIFT: Short = 0x10
        const val VK_CONTROL: Short = 0x11
        const val VK_ALT: Short = 0x12
        const val VK_PAUSE: Short = 0x13
        const val VK_CAPS_LOCK: Short = 0x14
        const val VK_ESCAPE: Short = 0x1B
        const val VK_SPACE: Short = 0x20
        const val VK_PAGE_UP: Short = 0x21
        const val VK_PAGE_DOWN: Short = 0x22
        const val VK_END: Short = 0x23
        const val VK_HOME: Short = 0x24
        const val VK_LEFT: Short = 0x25
        const val VK_UP: Short = 0x26
        const val VK_RIGHT: Short = 0x27
        const val VK_DOWN: Short = 0x28
        const val VK_PRINTSCREEN: Short = 0x2C
        const val VK_INSERT: Short = 0x2D
        const val VK_DELETE: Short = 0x2E

        // numbers
        const val VK_0: Short = 0x30
        const val VK_1: Short = 0x31
        const val VK_2: Short = 0x32
        const val VK_3: Short = 0x33
        const val VK_4: Short = 0x34
        const val VK_5: Short = 0x35
        const val VK_6: Short = 0x36
        const val VK_7: Short = 0x37
        const val VK_8: Short = 0x38
        const val VK_9: Short = 0x39

        // Alphabets
        const val VK_A: Short = 0x41
        const val VK_B: Short = 0x42
        const val VK_C: Short = 0x43
        const val VK_D: Short = 0x44
        const val VK_E: Short = 0x45
        const val VK_F: Short = 0x46
        const val VK_G: Short = 0x47
        const val VK_H: Short = 0x48
        const val VK_I: Short = 0x49
        const val VK_J: Short = 0x4A
        const val VK_K: Short = 0x4B
        const val VK_L: Short = 0x4C
        const val VK_M: Short = 0x4D
        const val VK_N: Short = 0x4E
        const val VK_O: Short = 0x4F
        const val VK_P: Short = 0x50
        const val VK_Q: Short = 0x51
        const val VK_R: Short = 0x52
        const val VK_S: Short = 0x53
        const val VK_T: Short = 0x54
        const val VK_U: Short = 0x55
        const val VK_V: Short = 0x56
        const val VK_W: Short = 0x57
        const val VK_X: Short = 0x58
        const val VK_Y: Short = 0x59
        const val VK_Z: Short = 0x5A

        const val VK_LEFT_WIN: Short = 0x5B
        const val VK_RIGHT_WIN: Short = 0x5C
        const val VK_APPS: Short = 0x5D

        const val VK_NUMPAD0: Short = 0x60
        const val VK_NUMPAD1: Short = 0x61
        const val VK_NUMPAD2: Short = 0x62
        const val VK_NUMPAD3: Short = 0x63
        const val VK_NUMPAD4: Short = 0x64
        const val VK_NUMPAD5: Short = 0x65
        const val VK_NUMPAD6: Short = 0x66
        const val VK_NUMPAD7: Short = 0x67
        const val VK_NUMPAD8: Short = 0x68
        const val VK_NUMPAD9: Short = 0x69
        const val VK_MULTIPLY: Short = 0x6A
        const val VK_ADD: Short = 0x6B
        const val VK_SEPARATOR: Short = 0x6C
        const val VK_SUBTRACT: Short = 0x6D
        const val VK_DECIMAL: Short = 0x6E
        const val VK_DIVIDE: Short = 0x6F
        const val VK_F1: Short = 0x70
        const val VK_F2: Short = 0x71
        const val VK_F3: Short = 0x72
        const val VK_F4: Short = 0x73
        const val VK_F5: Short = 0x74
        const val VK_F6: Short = 0x75
        const val VK_F7: Short = 0x76
        const val VK_F8: Short = 0x77
        const val VK_F9: Short = 0x78
        const val VK_F10: Short = 0x79
        const val VK_F11: Short = 0x7A
        const val VK_F12: Short = 0x7B
        const val VK_F13: Short = 0x7C
        const val VK_F14: Short = 0x7D
        const val VK_F15: Short = 0x7E
        const val VK_F16: Short = 0x7F
        const val VK_F17: Short = 0x80.toShort()
        const val VK_F18: Short = 0x81.toShort()
        const val VK_F19: Short = 0x82.toShort()
        const val VK_F20: Short = 0x83.toShort()
        const val VK_F21: Short = 0x84.toShort()
        const val VK_F22: Short = 0x85.toShort()
        const val VK_F23: Short = 0x86.toShort()
        const val VK_F24: Short = 0x87.toShort()

        const val VK_NUMLOCK: Short = 0x90.toShort()
        const val VK_SCROLL_LOCK: Short = 0x91.toShort()
        const val VK_LEFT_SHIFT: Short = 0xA0.toShort()
        const val VK_RIGHT_SHIFT: Short = 0xA1.toShort()
        const val VK_LEFT_CONTROL: Short = 0xA2.toShort()
        const val VK_RIGHT_CONTROL: Short = 0xA3.toShort()
        const val VK_LEFT_ALT: Short = 0xA4.toShort()
        const val VK_RIGHT_ALT: Short = 0xA5.toShort()
        const val VK_SEMICOLON: Short = 0xBA.toShort()
        const val VK_EQUALS: Short = 0xBB.toShort()
        const val VK_COMMA: Short = 0xBC.toShort()
        const val VK_MINUS: Short = 0xBD.toShort()
        const val VK_PERIOD: Short = 0xBE.toShort()
        const val VK_SLASH: Short = 0xBF.toShort()
        const val VK_BACK_QUOTE: Short = 0xC0.toShort()
        const val VK_OPEN_BRACKET: Short = 0xDB.toShort()
        const val VK_BACK_SLASH: Short = 0xDC.toShort()
        const val VK_CLOSE_BRACKET: Short = 0xDD.toShort()
        const val VK_QUOTE: Short = 0xDE.toShort()
    }

    private val vKeyMap: MutableMap<Int, Short> = HashMap()
    private val scanCodeMap: MutableMap<Int, Short> = HashMap()

    init {
        initVKeyMap()
        initScanCodeMap()
    }

    private fun initVKeyMap() {
    }

    private fun initScanCodeMap() {
    }

    fun getVKCode(button: Int): Short? {
        return this.vKeyMap[button]
    }

    fun getScanCode(button: Int): Short? {
        return this.scanCodeMap[button]
    }
}
