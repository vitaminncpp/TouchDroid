package com.akshayaap.touchdroid.ui.activities;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.abstractfactory.GlobalFactory;
import com.akshayaap.touchdroid.io.Event;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Keyboard extends AppCompatActivity {

    private Event event = new Event();

    private KeyPressedHandler handler;
    private Button buttonUp;
    private Button buttonLeft;
    private Button buttonDown;
    private Button buttonRight;

    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;
    private Button buttonG;
    private Button buttonH;
    private Button buttonI;
    private Button buttonJ;
    private Button buttonK;
    private Button buttonL;
    private Button buttonM;
    private Button buttonN;
    private Button buttonO;
    private Button buttonP;
    private Button buttonQ;
    private Button buttonR;
    private Button buttonS;
    private Button buttonT;
    private Button buttonU;
    private Button buttonV;
    private Button buttonW;
    private Button buttonX;
    private Button buttonY;
    private Button buttonZ;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;

    private Button buttonTiddle;
    private Button buttonUnderscore;
    private Button buttonEquals;
    private Button buttonBackspace;
    private Button buttonTab;
    private Button buttonSqOpen;
    private Button buttonSqClose;
    private Button buttonBackslash;
    private Button buttonCaps;
    private Button buttonSemiColon;
    private Button buttonQuote;
    private Button buttonEnter;
    private Button buttonLShift;
    private Button buttonComma;
    private Button buttonDot;
    private Button buttonSlash;
    private Button buttonRShift;
    private Button buttonLCtrl;
    private Button buttonWindows;
    private Button buttonLAlt;
    private Button buttonSpace;
    private Button buttonRAlt;
    private Button buttonRCtrl;

    private Button buttonPrintScr;
    private Button buttonInsert;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        initKeys();
        handler = new KeyPressedHandler();
        addActionListenersToKeys();
        event.setType(Event.INPUT_KEYBOARD);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void addActionListenersToKeys() {
        button0.setOnTouchListener(handler);
        button1.setOnTouchListener(handler);
        button2.setOnTouchListener(handler);
        button3.setOnTouchListener(handler);
        button4.setOnTouchListener(handler);
        button5.setOnTouchListener(handler);
        button6.setOnTouchListener(handler);
        button7.setOnTouchListener(handler);
        button8.setOnTouchListener(handler);
        button9.setOnTouchListener(handler);

        buttonA.setOnTouchListener(handler);
        buttonB.setOnTouchListener(handler);
        buttonC.setOnTouchListener(handler);
        buttonD.setOnTouchListener(handler);
        buttonE.setOnTouchListener(handler);
        buttonF.setOnTouchListener(handler);

        buttonG.setOnTouchListener(handler);
        buttonH.setOnTouchListener(handler);
        buttonI.setOnTouchListener(handler);
        buttonJ.setOnTouchListener(handler);
        buttonK.setOnTouchListener(handler);
        buttonL.setOnTouchListener(handler);

        buttonM.setOnTouchListener(handler);
        buttonN.setOnTouchListener(handler);
        buttonO.setOnTouchListener(handler);
        buttonP.setOnTouchListener(handler);
        buttonQ.setOnTouchListener(handler);
        buttonS.setOnTouchListener(handler);

        buttonT.setOnTouchListener(handler);
        buttonU.setOnTouchListener(handler);
        buttonV.setOnTouchListener(handler);
        buttonW.setOnTouchListener(handler);
        buttonX.setOnTouchListener(handler);
        buttonY.setOnTouchListener(handler);
        buttonZ.setOnTouchListener(handler);

    }

    private void initKeys() {

        buttonUp = findViewById(R.id.buttonUp);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonDown = findViewById(R.id.buttonDown);
        buttonRight = findViewById(R.id.buttonRight);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        buttonE = findViewById(R.id.buttonE);
        buttonF = findViewById(R.id.buttonF);
        buttonG = findViewById(R.id.buttonG);
        buttonH = findViewById(R.id.buttonH);
        buttonI = findViewById(R.id.buttonI);
        buttonJ = findViewById(R.id.buttonJ);
        buttonK = findViewById(R.id.buttonK);
        buttonL = findViewById(R.id.buttonL);
        buttonM = findViewById(R.id.buttonM);
        buttonN = findViewById(R.id.buttonN);
        buttonO = findViewById(R.id.buttonO);
        buttonP = findViewById(R.id.buttonP);
        buttonQ = findViewById(R.id.buttonQ);
        buttonR = findViewById(R.id.buttonR);
        buttonS = findViewById(R.id.buttonS);
        buttonT = findViewById(R.id.buttonT);
        buttonU = findViewById(R.id.buttonU);
        buttonV = findViewById(R.id.buttonV);
        buttonW = findViewById(R.id.buttonW);
        buttonX = findViewById(R.id.buttonX);
        buttonY = findViewById(R.id.buttonY);
        buttonZ = findViewById(R.id.buttonZ);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonTiddle = findViewById(R.id.buttonTiddle);
        buttonUnderscore = findViewById(R.id.buttonUnderscore);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonTab = findViewById(R.id.buttonTab);
        buttonSqOpen = findViewById(R.id.buttonSqOpen);
        buttonSqClose = findViewById(R.id.buttonSqClose);
        buttonBackslash = findViewById(R.id.buttonBackslash);
        buttonCaps = findViewById(R.id.buttonCaps);
        buttonSemiColon = findViewById(R.id.buttonSemiColon);
        buttonQuote = findViewById(R.id.buttonQuote);
        buttonEnter = findViewById(R.id.buttonEnter);
        buttonLShift = findViewById(R.id.buttonLShift);
        buttonComma = findViewById(R.id.buttonComma);
        buttonDot = findViewById(R.id.buttonDot);
        buttonSlash = findViewById(R.id.buttonSlash);
        buttonRShift = findViewById(R.id.buttonRShift);
        buttonLCtrl = findViewById(R.id.buttonLCtrl);
        buttonWindows = findViewById(R.id.buttonWindows);
        buttonLAlt = findViewById(R.id.buttonLAlt);
        buttonSpace = findViewById(R.id.buttonSpace);
        buttonRAlt = findViewById(R.id.buttonRAlt);
        buttonRCtrl = findViewById(R.id.buttonRCtrl);
        buttonPrintScr = findViewById(R.id.buttonPrintScr);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonDelete = findViewById(R.id.buttonDelete);
    }

    private void initAnimation() {

    }

    class KeyPressedHandler implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //TODO Animate the button
            int type = motionEvent.getActionMasked();
            switch (type) {
                case MotionEvent.ACTION_DOWN:
                    event.setDwFlags(0);
                    break;
                case MotionEvent.ACTION_UP:
                    event.setDwFlags(Event.KEYEVENTF_KEYUP);
                    break;
                case MotionEvent.ACTION_MOVE:
                    return true;
                default:
                    break;
            }
            event.setwVk((short) GlobalFactory.getFactory().getKeyMap().getVKCode(view.getId()));
            try {
                GlobalFactory.getFactory().getMessageSender().send(event.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                GlobalFactory.getFactory().getLogger().log("networkerr", "Error Sending KeyEvent: " + e.getMessage());
            }
            return true;
        }
    }
}