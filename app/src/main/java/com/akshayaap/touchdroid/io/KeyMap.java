package com.akshayaap.touchdroid.io;

import com.akshayaap.touchdroid.R;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
    private Map<Integer, Integer> keyMap = null;

    public KeyMap() {
        keyMap = new HashMap<>();
        initMap();
    }

    private void initMap() {

        keyMap.put(R.id.button0, (int) '0');
        keyMap.put(R.id.button1, (int) '1');
        keyMap.put(R.id.button2, (int) '2');
        keyMap.put(R.id.button3, (int) '3');
        keyMap.put(R.id.button4, (int) '4');
        keyMap.put(R.id.button5, (int) '5');
        keyMap.put(R.id.button6, (int) '6');
        keyMap.put(R.id.button7, (int) '7');
        keyMap.put(R.id.button8, (int) '8');
        keyMap.put(R.id.button9, (int) '9');

        keyMap.put(R.id.buttonA, (int) 'a');
        keyMap.put(R.id.buttonB, (int) 'b');
        keyMap.put(R.id.buttonC, (int) 'c');
        keyMap.put(R.id.buttonD, (int) 'd');
        keyMap.put(R.id.buttonE, (int) 'e');
        keyMap.put(R.id.buttonI, (int) 'i');

        keyMap.put(R.id.buttonJ, (int) 'j');
        keyMap.put(R.id.buttonK, (int) 'k');
        keyMap.put(R.id.buttonL, (int) 'l');
        keyMap.put(R.id.buttonM, (int) 'm');
        keyMap.put(R.id.buttonO, (int) 'o');
        keyMap.put(R.id.buttonP, (int) 'p');

        keyMap.put(R.id.buttonQ, (int) 'q');
        keyMap.put(R.id.buttonR, (int) 'r');
        keyMap.put(R.id.buttonS, (int) 's');
        keyMap.put(R.id.buttonT, (int) 't');
        keyMap.put(R.id.buttonU, (int) 'u');
        keyMap.put(R.id.buttonV, (int) 'v');

        keyMap.put(R.id.buttonW, (int) 'v');
        keyMap.put(R.id.buttonX, (int) 'x');
        keyMap.put(R.id.buttonY, (int) 'y');
        keyMap.put(R.id.buttonZ, (int) 'z');


    }

    public int getKeyCode(int uiButtonCode) {
        return this.keyMap.get(uiButtonCode);
    }
}
