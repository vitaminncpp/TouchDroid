package com.akshayaap.touchdroid.util.logger

interface Logger {
    fun log(message: LoggMessage)
    fun log(tag: String, message: String)
}
