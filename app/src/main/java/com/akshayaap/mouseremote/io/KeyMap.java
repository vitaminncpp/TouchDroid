package com.akshayaap.mouseremote.io;

import com.akshayaap.mouseremote.R;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
    private Map<Integer, Integer> keymap = null;

    public KeyMap() {
        keymap = new HashMap<>();
        initMap();
    }

    private void initMap() {

        keymap.put(R.id.button0, (int) '0');
        keymap.put(R.id.button1, (int) '1');
        keymap.put(R.id.button2, (int) '2');
        keymap.put(R.id.button3, (int) '3');
        keymap.put(R.id.button4, (int) '4');
        keymap.put(R.id.button5, (int) '5');
        keymap.put(R.id.button6, (int) '6');
        keymap.put(R.id.button7, (int) '7');
        keymap.put(R.id.button8, (int) '8');
        keymap.put(R.id.button9, (int) '9');

        keymap.put(R.id.buttonA, (int) 'a');
        keymap.put(R.id.buttonB, (int) 'b');
        keymap.put(R.id.buttonC, (int) 'c');
        keymap.put(R.id.buttonD, (int) 'd');
        keymap.put(R.id.buttonE, (int) 'e');
        keymap.put(R.id.buttonF, (int) 'f');


    }
}
