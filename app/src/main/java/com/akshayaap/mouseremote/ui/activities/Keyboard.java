package com.akshayaap.mouseremote.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.akshayaap.mouseremote.R;

public class Keyboard extends AppCompatActivity {


    KeyPressedHandler handler;
    Button buttonUp;
    Button buttonLeft;
    Button buttonDown;
    Button buttonRight;

    Button buttonA;
    Button buttonB;
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonG;
    Button buttonH;
    Button buttonI;
    Button buttonJ;
    Button buttonK;
    Button buttonL;
    Button buttonM;
    Button buttonN;
    Button buttonO;
    Button buttonP;
    Button buttonQ;
    Button buttonR;
    Button buttonS;
    Button buttonT;
    Button buttonU;
    Button buttonV;
    Button buttonW;
    Button buttonX;
    Button buttonY;
    Button buttonZ;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;

    Button buttonTiddle;
    Button buttonUnderscore;
    Button buttonEquals;
    Button buttonBackspace;
    Button buttonTab;
    Button buttonSqOpen;
    Button buttonSqClose;
    Button buttonBackslash;
    Button buttonCaps;
    Button buttonSemiColon;
    Button buttonQuote;
    Button buttonEnter;
    Button buttonLShift;
    Button buttonComma;
    Button buttonDot;
    Button buttonSlash;
    Button buttonRShift;
    Button buttonLCtrl;
    Button buttonWindows;
    Button buttonLAlt;
    Button buttonSpace;
    Button buttonRAlt;
    Button buttonRCtrl;

    Button buttonPrintScr;
    Button buttonInsert;
    Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        initKeys();
        handler=new KeyPressedHandler();
        addActionListenertoKeys();

    }

    private void addActionListenertoKeys() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("keyevent", "onClick: button0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("keyevent", "onClick: button1");
            }
        });
    }

    private void initKeys() {

        buttonUp = findViewById(R.id.buttonUp);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonDown = findViewById(R.id.buttonDown);
        buttonRight = findViewById(R.id.buttonRight);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
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

    class KeyPressedHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.d("keyPressed", "Yess"+view.toString());
            int keyID = view.getId();
            switch (keyID) {
                case R.id.button0:
                    Log.d("keyevent", "onClick: button0");
                    break;
                case R.id.button1:
                    Log.d("keyevent", "onClick: button1");
                    break;

                default:
                    break;
            }
        }
    }
}