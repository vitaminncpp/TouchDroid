package com.akshayaap.touchdroid.service

import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.akshayaap.touchdroid.io.Event
import com.akshayaap.touchdroid.ui.fragments.Touchpad
import com.akshayaap.touchdroid.util.State

class TouchPadService(private val touchpad: Touchpad) {
    val touchListener: View.OnTouchListener

    private var xp = 0
    private var yp = 0

    private var x = 0
    private var y = 0

    private var dx = 0
    private var dy = 0

    private val event = Event()
    private val state = State()

    init {
        touchListener = View.OnTouchListener { _, motionEvent ->
            val eventType = motionEvent.actionMasked
            state.setEvent(eventType)
            Log.d("TOUCH_EVENT", "onTouch: $eventType")
            when (eventType) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("ACTION_DOWN", "TouchCount: ${motionEvent.pointerCount}")
                }
                MotionEvent.ACTION_CANCEL,
                MotionEvent.ACTION_BUTTON_PRESS,
                MotionEvent.ACTION_BUTTON_RELEASE,
                MotionEvent.ACTION_SCROLL -> {
                }
                MotionEvent.ACTION_UP -> {
                    Log.d("ACTION_UP", "TouchCount: ${motionEvent.pointerCount}")
                    xp = 0
                    yp = 0
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("ACTION_UP", "TouchCount: ${motionEvent.pointerCount}")
                    x = motionEvent.x.toInt()
                    y = motionEvent.y.toInt()
                    dx = x - xp
                    dy = y - yp
                    if (xp != 0 && yp != 0) {
                        event.dwFlags = Event.MOUSEEVENTF_MOVE
                        event.setXY(dx, dy)
                        touchpad.sendEvent(event)
                    }
                    xp = x
                    yp = y
                }
                else -> {}
            }
            true
        }
    }

    private class EventTimeout(private val state: State) : Thread() {
        override fun run() {
        }
    }
}
