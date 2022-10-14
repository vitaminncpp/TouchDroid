package com.akshayaap.touchdroid.io;

import com.akshayaap.touchdroid.R;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
    private Map<Integer, Short> vKeyMap = null;
    private Map<Integer, Short> scanCodeMap = null;

    public KeyMap() {
        vKeyMap = new HashMap<>();
        scanCodeMap = new HashMap<>();
        initVKeyMap();
        initScanCodeMap();
    }

    private void initVKeyMap() {

        vKeyMap.put(R.id.button0, (short) '0');
        vKeyMap.put(R.id.button1, (short) '1');
        vKeyMap.put(R.id.button2, (short) '2');
        vKeyMap.put(R.id.button3, (short) '3');
        vKeyMap.put(R.id.button4, (short) '4');
        vKeyMap.put(R.id.button5, (short) '5');
        vKeyMap.put(R.id.button6, (short) '6');
        vKeyMap.put(R.id.button7, (short) '7');
        vKeyMap.put(R.id.button8, (short) '8');
        vKeyMap.put(R.id.button9, (short) '9');

        vKeyMap.put(R.id.buttonA, (short) 'A');
        vKeyMap.put(R.id.buttonB, (short) 'B');
        vKeyMap.put(R.id.buttonC, (short) 'C');
        vKeyMap.put(R.id.buttonD, (short) 'D');
        vKeyMap.put(R.id.buttonE, (short) 'E');
        vKeyMap.put(R.id.buttonF, (short) 'F');

        vKeyMap.put(R.id.buttonG, (short) 'G');
        vKeyMap.put(R.id.buttonH, (short) 'H');
        vKeyMap.put(R.id.buttonI, (short) 'I');
        vKeyMap.put(R.id.buttonJ, (short) 'J');
        vKeyMap.put(R.id.buttonK, (short) 'K');
        vKeyMap.put(R.id.buttonL, (short) 'L');

        vKeyMap.put(R.id.buttonM, (short) 'M');
        vKeyMap.put(R.id.buttonN, (short) 'N');
        vKeyMap.put(R.id.buttonO, (short) 'O');
        vKeyMap.put(R.id.buttonP, (short) 'P');
        vKeyMap.put(R.id.buttonQ, (short) 'Q');
        vKeyMap.put(R.id.buttonR, (short) 'R');

        vKeyMap.put(R.id.buttonS, (short) 'S');
        vKeyMap.put(R.id.buttonT, (short) 'T');
        vKeyMap.put(R.id.buttonU, (short) 'U');
        vKeyMap.put(R.id.buttonV, (short) 'V');
        vKeyMap.put(R.id.buttonW, (short) 'W');
        vKeyMap.put(R.id.buttonX, (short) 'X');

        vKeyMap.put(R.id.buttonY, (short) 'Y');
        vKeyMap.put(R.id.buttonZ, (short) 'Z');

    }

    private void initScanCodeMap() {
        scanCodeMap.put(R.id.button0, (short) 0x8B);
        scanCodeMap.put(R.id.button1, (short) 0x82);
        scanCodeMap.put(R.id.button2, (short) 0x83);
        scanCodeMap.put(R.id.button3, (short) 0x84);
        scanCodeMap.put(R.id.button4, (short) 0x85);
        scanCodeMap.put(R.id.button5, (short) 0x86);
        scanCodeMap.put(R.id.button6, (short) 0x87);
        scanCodeMap.put(R.id.button7, (short) 0x88);
        scanCodeMap.put(R.id.button8, (short) 0x89);
        scanCodeMap.put(R.id.button9, (short) 0x8A);

        scanCodeMap.put(R.id.buttonA, (short) 'a');
        scanCodeMap.put(R.id.buttonB, (short) 'b');
        scanCodeMap.put(R.id.buttonC, (short) 'c');
        scanCodeMap.put(R.id.buttonD, (short) 'd');
        scanCodeMap.put(R.id.buttonE, (short) 'e');
        scanCodeMap.put(R.id.buttonI, (short) 'i');
        scanCodeMap.put(R.id.buttonJ, (short) 'j');
        scanCodeMap.put(R.id.buttonK, (short) 'k');
        scanCodeMap.put(R.id.buttonL, (short) 'l');
        scanCodeMap.put(R.id.buttonM, (short) 'm');
        scanCodeMap.put(R.id.buttonO, (short) 'o');
        scanCodeMap.put(R.id.buttonP, (short) 'p');
        scanCodeMap.put(R.id.buttonQ, (short) 'q');
        scanCodeMap.put(R.id.buttonR, (short) 'r');
        scanCodeMap.put(R.id.buttonS, (short) 's');
        scanCodeMap.put(R.id.buttonT, (short) 't');
        scanCodeMap.put(R.id.buttonU, (short) 'u');
        scanCodeMap.put(R.id.buttonV, (short) 'v');
        scanCodeMap.put(R.id.buttonW, (short) 'w');
        scanCodeMap.put(R.id.buttonX, (short) 'x');
        scanCodeMap.put(R.id.buttonY, (short) 'y');
        scanCodeMap.put(R.id.buttonZ, (short) 'z');
    }

    public short getVKCode(int uiButtonCode) {
        return this.vKeyMap.get(uiButtonCode);
    }

    public short getScanCode(int uiButtonCode) {
        return this.scanCodeMap.get(uiButtonCode);
    }
}
