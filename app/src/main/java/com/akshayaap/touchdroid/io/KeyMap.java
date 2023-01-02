package com.akshayaap.touchdroid.io;

import com.akshayaap.touchdroid.R;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {

    /**
     * List of All the keys
     */
    //<key-list>
    // mouse
    public static final short VK_L_MOUSE = 0x01;
    public static final short VK_R_MOUSE = 0x02;
    public static final short VK_CANCEL = 0x03;
    public static final short VK_M_MOUSE = 0x04;
    public static final short VK_X1_MOUSE = 0x05; //WTF is that
    public static final short VK_X2_MOUSE = 0x06; //WTF is that too

    //other
    public static final short VK_UNDEFINED_7 = 0X07;
    //System
    public static final short VK_BACK = 0x08;
    public static final short VK_TAB = 0x09;
    public static final short VK_RESERVED_A = 0x0A;
    public static final short VK_RESERVED_B = 0x0B;
    public static final short VK_CLEAR = 0x0C;
    public static final short VK_RETURN = 0x0D;

    public static final short VK_UNDEFINE_E = 0X0E;
    public static final short VK_UNDEFINE_F = 0X0F;
    public static final short VK_SHIFT = 0x10;
    public static final short VK_CONTROL = 0x11;
    public static final short VK_ALT = 0x12;
    public static final short VK_PAUSE = 0x13;
    public static final short VK_CAPS_LOCK = 0x14;
    public static final short VK_ESCAPE = 0x1B;
    public static final short VK_SPACE = 0x20;
    public static final short VK_PAGE_UP = 0x21;
    public static final short VK_PAGE_DOWN = 0x22;
    public static final short VK_END = 0x23;
    public static final short VK_HOME = 0x24;
    public static final short VK_LEFT = 0x25;
    public static final short VK_UP = 0x26;
    public static final short VK_RIGHT = 0x27;
    public static final short VK_DOWN = 0x28;
    public static final short VK_PRINTSCREEN = 0x2C;
    public static final short VK_INSERT = 0x2D;
    public static final short VK_DELETE = 0x2E;

    //numbers
    public static final short VK_0 = 0x30;
    public static final short VK_1 = 0x31;
    public static final short VK_2 = 0x32;
    public static final short VK_3 = 0x33;
    public static final short VK_4 = 0x34;
    public static final short VK_5 = 0x35;
    public static final short VK_6 = 0x36;
    public static final short VK_7 = 0x37;
    public static final short VK_8 = 0x38;
    public static final short VK_9 = 0x39;

    //Alphabets
    public static final short VK_A = 0x41;
    public static final short VK_B = 0x42;
    public static final short VK_C = 0x43;
    public static final short VK_D = 0x44;
    public static final short VK_E = 0x45;
    public static final short VK_F = 0x46;
    public static final short VK_G = 0x47;
    public static final short VK_H = 0x48;
    public static final short VK_I = 0x49;
    public static final short VK_J = 0x4A;
    public static final short VK_K = 0x4B;
    public static final short VK_L = 0x4C;
    public static final short VK_M = 0x4D;
    public static final short VK_N = 0x4E;
    public static final short VK_O = 0x4F;
    public static final short VK_P = 0x50;
    public static final short VK_Q = 0x51;
    public static final short VK_R = 0x52;

    public static final short VK_S = 0x53;
    public static final short VK_T = 0x54;
    public static final short VK_U = 0x55;
    public static final short VK_V = 0x56;
    public static final short VK_W = 0x57;
    public static final short VK_X = 0x58;
    public static final short VK_Y = 0x59;
    public static final short VK_Z = 0x5A;

    public static final short VK_LEFT_WIN = 0x5B;
    public static final short VK_RIGHT_WIN = 0x5C;
    public static final short VK_APPS = 0x5D;


    public static final short VK_NUMPAD0 = 0x60;
    public static final short VK_NUMPAD1 = 0x61;
    public static final short VK_NUMPAD2 = 0x62;
    public static final short VK_NUMPAD3 = 0x63;
    public static final short VK_NUMPAD4 = 0x64;
    public static final short VK_NUMPAD5 = 0x65;
    public static final short VK_NUMPAD6 = 0x66;
    public static final short VK_NUMPAD7 = 0x67;
    public static final short VK_NUMPAD8 = 0x68;
    public static final short VK_NUMPAD9 = 0x69;
    public static final short VK_MULTIPLY = 0x6A;
    public static final short VK_ADD = 0x6B;
    public static final short VK_SEPARATOR = 0x6C;
    public static final short VK_SUBTRACT = 0x6D;
    public static final short VK_DECIMAL = 0x6E;
    public static final short VK_DIVIDE = 0x6F;
    public static final short VK_F1 = 0x70;
    public static final short VK_F2 = 0x71;
    public static final short VK_F3 = 0x72;
    public static final short VK_F4 = 0x73;
    public static final short VK_F5 = 0x74;
    public static final short VK_F6 = 0x75;
    public static final short VK_F7 = 0x76;
    public static final short VK_F8 = 0x77;
    public static final short VK_F9 = 0x78;
    public static final short VK_F10 = 0x79;
    public static final short VK_F11 = 0x7A;
    public static final short VK_F12 = 0x7B;
    public static final short VK_F13 = 0x7C;
    public static final short VK_F14 = 0x7D;
    public static final short VK_F15 = 0x7E;
    public static final short VK_F16 = 0x7F;
    public static final short VK_F17 = 0x80;
    public static final short VK_F18 = 0x81;
    public static final short VK_F19 = 0x82;
    public static final short VK_F20 = 0x83;
    public static final short VK_F21 = 0x84;
    public static final short VK_F22 = 0x85;
    public static final short VK_F23 = 0x86;

    public static final short VK_F24 = 0x87;
    public static final short VK_NUMLOCK = 0x90;
    public static final short VK_SCROLL_LOCK = 0x91;
    public static final short VK_LEFT_SHIFT = 0xA0;
    public static final short VK_RIGHT_SHIFT = 0xA1;
    public static final short VK_LEFT_CONTROL = 0xA2;
    public static final short VK_RIGHT_CONTROL = 0xA3;
    public static final short VK_LEFT_ALT = 0xA4;
    public static final short VK_RIGHT_ALT = 0xA5;
    public static final short VK_SEMICOLON = 0xBA;
    public static final short VK_EQUALS = 0xBB;
    public static final short VK_COMMA = 0xBC;
    public static final short VK_MINUS = 0xBD;
    public static final short VK_PERIOD = 0xBE;
    public static final short VK_SLASH = 0xBF;
    public static final short VK_BACK_QUOTE = 0xC0;
    public static final short VK_OPEN_BRACKET = 0xDB;
    public static final short VK_BACK_SLASH = 0xDC;
    public static final short VK_CLOSE_BRACKET = 0xDD;
    public static final short VK_QUOTE = 0xDE;

    //</key-list>

    private Map<Integer, Short> vKeyMap = null;
    private Map<Integer, Short> scanCodeMap = null;

    public KeyMap() {
        vKeyMap = new HashMap<>();
        scanCodeMap = new HashMap<>();
        initVKeyMap();
        initScanCodeMap();
    }

    private void initVKeyMap() {
        vKeyMap.put(R.id.button0, VK_0);
        vKeyMap.put(R.id.button1, VK_1);
        vKeyMap.put(R.id.button2, VK_2);
        vKeyMap.put(R.id.button3, VK_3);
        vKeyMap.put(R.id.button4, VK_4);
        vKeyMap.put(R.id.button5, VK_5);
        vKeyMap.put(R.id.button6, VK_6);
        vKeyMap.put(R.id.button7, VK_7);
        vKeyMap.put(R.id.button8, VK_8);
        vKeyMap.put(R.id.button9, VK_9);


        vKeyMap.put(R.id.buttonA, VK_A);
        vKeyMap.put(R.id.buttonB, VK_B);
        vKeyMap.put(R.id.buttonC, VK_C);
        vKeyMap.put(R.id.buttonD, VK_D);
        vKeyMap.put(R.id.buttonE, VK_E);
        vKeyMap.put(R.id.buttonF, VK_F);
        vKeyMap.put(R.id.buttonG, VK_G);
        vKeyMap.put(R.id.buttonH, VK_H);
        vKeyMap.put(R.id.buttonI, VK_I);
        vKeyMap.put(R.id.buttonJ, VK_J);
        vKeyMap.put(R.id.buttonK, VK_K);
        vKeyMap.put(R.id.buttonL, VK_L);


        vKeyMap.put(R.id.buttonM, VK_M);
        vKeyMap.put(R.id.buttonN, VK_N);
        vKeyMap.put(R.id.buttonO, VK_O);
        vKeyMap.put(R.id.buttonP, VK_P);
        vKeyMap.put(R.id.buttonQ, VK_Q);
        vKeyMap.put(R.id.buttonR, VK_R);

        vKeyMap.put(R.id.buttonS, VK_S);
        vKeyMap.put(R.id.buttonT, VK_T);
        vKeyMap.put(R.id.buttonU, VK_U);
        vKeyMap.put(R.id.buttonV, VK_V);
        vKeyMap.put(R.id.buttonW, VK_W);
        vKeyMap.put(R.id.buttonX, VK_X);
        vKeyMap.put(R.id.buttonY, VK_Y);
        vKeyMap.put(R.id.buttonZ, VK_Z);

        //System keys
        //Tab
        vKeyMap.put(R.id.buttonTab, VK_TAB);
        //ctrl
        vKeyMap.put(R.id.buttonLCtrl, VK_LEFT_CONTROL);
        vKeyMap.put(R.id.buttonRCtrl, VK_RIGHT_CONTROL);

        //shift
        vKeyMap.put(R.id.buttonLShift, VK_LEFT_SHIFT);
        vKeyMap.put(R.id.buttonRShift, VK_RIGHT_SHIFT);

        //Alt
        vKeyMap.put(R.id.buttonLAlt, VK_LEFT_ALT);
        vKeyMap.put(R.id.buttonRAlt, VK_RIGHT_ALT);

        //winkey
        vKeyMap.put(R.id.buttonWindows, VK_LEFT_WIN);

        //caps lock, num lock
        vKeyMap.put(R.id.buttonCaps, VK_CAPS_LOCK);
        //TODO numlock

        //print, delete, insert, end
        vKeyMap.put(R.id.buttonPrintScr, VK_PRINTSCREEN);
        vKeyMap.put(R.id.buttonInsert, VK_INSERT);
        vKeyMap.put(R.id.buttonDelete, VK_DELETE);

        //backspace and enter
        vKeyMap.put(R.id.buttonBackspace, VK_BACK);
        vKeyMap.put(R.id.buttonEnter, VK_RETURN);
        // special characters
        vKeyMap.put(R.id.buttonBackslash, VK_BACK_SLASH);
        vKeyMap.put(R.id.buttonEquals, VK_EQUALS);
        vKeyMap.put(R.id.buttonQuote, VK_QUOTE);
        vKeyMap.put(R.id.buttonSemiColon, VK_SEMICOLON);
        vKeyMap.put(R.id.buttonComma, VK_COMMA);
        vKeyMap.put(R.id.buttonSqOpen, VK_OPEN_BRACKET);
        vKeyMap.put(R.id.buttonSqClose, VK_CLOSE_BRACKET);
        vKeyMap.put(R.id.buttonDot, VK_PERIOD);
        vKeyMap.put(R.id.buttonTiddle, VK_BACK_QUOTE);
        vKeyMap.put(R.id.buttonSlash, VK_SLASH);
        vKeyMap.put(R.id.buttonMinus, VK_MINUS);

        //arrow keys
        vKeyMap.put(R.id.buttonLeft, VK_LEFT);
        vKeyMap.put(R.id.buttonRight, VK_RIGHT);
        vKeyMap.put(R.id.buttonUp, VK_UP);
        vKeyMap.put(R.id.buttonDown, VK_DOWN);
        // spce bar
        vKeyMap.put(R.id.buttonSpace, VK_SPACE);
        //TODO Page up page down

        //num-pad
        //TODO num-pad keys

        //TODO `ESC` and `END` keys
        vKeyMap.put(R.id.buttonEsc, VK_ESCAPE);
        vKeyMap.put(R.id.buttonEnd, VK_END);

        //function keys
        vKeyMap.put(R.id.buttonF1, VK_F1);
        vKeyMap.put(R.id.buttonF2, VK_F2);
        vKeyMap.put(R.id.buttonF3, VK_F3);
        vKeyMap.put(R.id.buttonF4, VK_F4);
        vKeyMap.put(R.id.buttonF5, VK_F5);
        vKeyMap.put(R.id.buttonF6, VK_F6);
        vKeyMap.put(R.id.buttonF7, VK_F7);
        vKeyMap.put(R.id.buttonF8, VK_F8);
        vKeyMap.put(R.id.buttonF9, VK_F9);
        vKeyMap.put(R.id.buttonF10, VK_F10);
        vKeyMap.put(R.id.buttonF11, VK_F11);
        vKeyMap.put(R.id.buttonF12, VK_F12);
    }

    private void initScanCodeMap() {
//        scanCodeMap.put(R.id.button0, (short) 0x8B);
//        scanCodeMap.put(R.id.button1, (short) 0x82);
//        scanCodeMap.put(R.id.button2, (short) 0x83);
//        scanCodeMap.put(R.id.button3, (short) 0x84);
//        scanCodeMap.put(R.id.button4, (short) 0x85);
//        scanCodeMap.put(R.id.button5, (short) 0x86);
//        scanCodeMap.put(R.id.button6, (short) 0x87);
//        scanCodeMap.put(R.id.button7, (short) 0x88);
//        scanCodeMap.put(R.id.button8, (short) 0x89);
//        scanCodeMap.put(R.id.button9, (short) 0x8A);
//
//        scanCodeMap.put(R.id.buttonA, (short) 'a');
//        scanCodeMap.put(R.id.buttonB, (short) 'b');
//        scanCodeMap.put(R.id.buttonC, (short) 'c');
//        scanCodeMap.put(R.id.buttonD, (short) 'd');
//        scanCodeMap.put(R.id.buttonE, (short) 'e');
//        scanCodeMap.put(R.id.buttonI, (short) 'i');
//        scanCodeMap.put(R.id.buttonJ, (short) 'j');
//        scanCodeMap.put(R.id.buttonK, (short) 'k');
//        scanCodeMap.put(R.id.buttonL, (short) 'l');
//        scanCodeMap.put(R.id.buttonM, (short) 'm');
//        scanCodeMap.put(R.id.buttonO, (short) 'o');
//        scanCodeMap.put(R.id.buttonP, (short) 'p');
//        scanCodeMap.put(R.id.buttonQ, (short) 'q');
//        scanCodeMap.put(R.id.buttonR, (short) 'r');
//        scanCodeMap.put(R.id.buttonS, (short) 's');
//        scanCodeMap.put(R.id.buttonT, (short) 't');
//        scanCodeMap.put(R.id.buttonU, (short) 'u');
//        scanCodeMap.put(R.id.buttonV, (short) 'v');
//        scanCodeMap.put(R.id.buttonW, (short) 'w');
//        scanCodeMap.put(R.id.buttonX, (short) 'x');
//        scanCodeMap.put(R.id.buttonY, (short) 'y');
//        scanCodeMap.put(R.id.buttonZ, (short) 'z');
    }

    public short getVKCode(int button) {
        return this.vKeyMap.get(button);
    }

    public short getScanCode(int button) {
        return this.scanCodeMap.get(button);
    }
}
