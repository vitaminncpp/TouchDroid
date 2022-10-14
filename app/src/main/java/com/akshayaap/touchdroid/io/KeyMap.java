package com.akshayaap.touchdroid.io;

import com.akshayaap.touchdroid.R;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
    private Map<Integer, Short> keyMap = null;

    public KeyMap() {
        keyMap = new HashMap<>();
        initMap();
    }

    private void initMap() {

        keyMap.put(R.id.button0, (short) '0');
        keyMap.put(R.id.button1, (short) '1');
        keyMap.put(R.id.button2, (short) '2');
        keyMap.put(R.id.button3, (short) '3');
        keyMap.put(R.id.button4, (short) '4');
        keyMap.put(R.id.button5, (short) '5');
        keyMap.put(R.id.button6, (short) '6');
        keyMap.put(R.id.button7, (short) '7');
        keyMap.put(R.id.button8, (short) '8');
        keyMap.put(R.id.button9, (short) '9');

        keyMap.put(R.id.buttonA, (short) 'a');
        keyMap.put(R.id.buttonB, (short) 'b');
        keyMap.put(R.id.buttonC, (short) 'c');
        keyMap.put(R.id.buttonD, (short) 'd');
        keyMap.put(R.id.buttonE, (short) 'e');
        keyMap.put(R.id.buttonI, (short) 'i');

        keyMap.put(R.id.buttonJ, (short) 'j');
        keyMap.put(R.id.buttonK, (short) 'k');
        keyMap.put(R.id.buttonL, (short) 'l');
        keyMap.put(R.id.buttonM, (short) 'm');
        keyMap.put(R.id.buttonO, (short) 'o');
        keyMap.put(R.id.buttonP, (short) 'p');

        keyMap.put(R.id.buttonQ, (short) 'q');
        keyMap.put(R.id.buttonR, (short) 'r');
        keyMap.put(R.id.buttonS, (short) 's');
        keyMap.put(R.id.buttonT, (short) 't');
        keyMap.put(R.id.buttonU, (short) 'u');
        keyMap.put(R.id.buttonV, (short) 'v');

        keyMap.put(R.id.buttonW, (short) 'v');
        keyMap.put(R.id.buttonX, (short) 'x');
        keyMap.put(R.id.buttonY, (short) 'y');
        keyMap.put(R.id.buttonZ, (short) 'z');


    }

    public short getKeyCode(int uiButtonCode) {
        return this.keyMap.get(uiButtonCode);
    }
}
