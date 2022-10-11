package com.akshayaap.mouseremote.io;

import com.akshayaap.mouseremote.R;

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
        keyMap.put(R.id.buttonF, (int) 'f');


    }

    public int getKeyCode(int uiButtonCode) {
        return this.keyMap.get(uiButtonCode);
    }
}
