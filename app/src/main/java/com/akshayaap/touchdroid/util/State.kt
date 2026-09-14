package com.akshayaap.touchdroid.util

class State {
    private var state: Int = -1
    private var prevState: Int = -1
    private var pCount: Int = 0
    private var prevCount: Int = 0
    private var time: Int = 0 // in milliseconds
    private var prevTime: Int = 0 // in milliseconds
    private var event: Int = -1
    private var prevEvent: Int = -1

    @Synchronized
    fun getState(): Int = this.state

    @Synchronized
    fun setState(state: Int) {
        this.prevState = this.state
        this.state = state
    }

    @Synchronized
    fun getPrevState(): Int = this.prevState

    @Synchronized
    fun setPrevState(state: Int) {
        this.prevState = state
    }

    @Synchronized
    fun setCount(count: Int) {
        this.prevCount = this.pCount
        this.pCount = count
    }

    @Synchronized
    fun getCount(count: Int = 0): Int = this.pCount

    @Synchronized
    fun getPrevCount(): Int = this.prevCount

    @Synchronized
    fun setPrevCount(count: Int) {
        this.prevCount = count
    }

    @Synchronized
    fun getTime(): Int = this.time

    @Synchronized
    fun setTime(time: Int) {
        this.prevTime = this.time
        this.time = time
    }

    @Synchronized
    fun getEvent(): Int = this.event

    @Synchronized
    fun setEvent(event: Int) {
        this.prevEvent = this.event
        this.event = event
    }

    @Synchronized
    fun getPrevEvent(): Int = this.prevEvent

    @Synchronized
    fun setPrevEvent(prevEvent: Int) {
        this.prevEvent = prevEvent
    }
}
