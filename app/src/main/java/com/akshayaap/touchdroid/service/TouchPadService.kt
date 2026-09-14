package com.akshayaap.touchdroid.service;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.akshayaap.touchdroid.io.Event;
import com.akshayaap.touchdroid.ui.fragments.Touchpad;
import com.akshayaap.touchdroid.util.State;

public class TouchPadService {
    private final Touchpad touchpad;
    private final View.OnTouchListener touchListener;

    private int Xp = 0;
    private int Yp = 0;

    private int X = 0;
    private int Y = 0;

    private int dx = 0;
    private int dy = 0;

    private final Event event = new Event();
    private final State state = new State();

    public TouchPadService(Touchpad touchpad) {
        this.touchpad = touchpad;
        this.touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int eventType = motionEvent.getActionMasked();
                TouchPadService.this.state.setEvent(eventType);
                Log.d("TOUCH_EVENT", "onTouch: " + motionEvent.getActionMasked());
                switch (eventType) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ACTION_DOWN", "TouchCount: " + motionEvent.getPointerCount());
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                    case MotionEvent.ACTION_BUTTON_PRESS:
                        break;
                    case MotionEvent.ACTION_BUTTON_RELEASE:
                        break;
                    case MotionEvent.ACTION_SCROLL:
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("ACTION_UP", "TouchCount: " + motionEvent.getPointerCount());
                        Xp = 0;
                        Yp = 0;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("ACTION_UP", "TouchCount: " + motionEvent.getPointerCount());
                        X = (int) motionEvent.getX();
                        Y = (int) motionEvent.getY();
                        dx = X - Xp;
                        dy = Y - Yp;
                        if (Xp != 0 && Yp != 0) {
                            event.setDwFlags(Event.MOUSEEVENTF_MOVE);
                            event.setXY(dx, dy);
                            TouchPadService.this.touchpad.sendEvent(TouchPadService.this.event);
                        }
                        Xp = X;
                        Yp = Y;
                        break;

                    default:
                        break;
                }
                return true;
            }
        };
    }

    public View.OnTouchListener getTouchListener() {
        return touchListener;
    }

    private static class EventTimeout extends Thread {
        private State state;

        public EventTimeout(State state) {
            this.state = state;
        }

        @Override
        public void run() {

        }

    }
}
