package com.akshayaap.touchdroid.util.logger

import java.util.Arrays

class LoggMessage {
    var tag: String? = null
    var message: String? = null
    var longMessage: String? = null
    var description: String? = null
    var stackTrace: Array<StackTraceElement>? = null

    constructor(tag: String?, message: String?, stackTrace: Array<StackTraceElement>?) {
        this.tag = tag
        this.message = message
        this.stackTrace = stackTrace
        this.longMessage = null
        this.description = null
    }

    constructor(tag: String?, message: String?, longMessage: String?, stackTrace: Array<StackTraceElement>?) {
        this.tag = tag
        this.message = message
        this.longMessage = longMessage
        this.stackTrace = stackTrace
        this.description = null
    }

    constructor(
        tag: String?,
        message: String?,
        longMessage: String?,
        description: String?,
        stackTrace: Array<StackTraceElement>?
    ) {
        this.tag = tag
        this.message = message
        this.longMessage = longMessage
        this.description = description
        this.stackTrace = stackTrace
    }

    constructor(tag: String?, message: String?) {
        this.tag = tag
        this.message = message
        this.longMessage = null
        this.description = null
        this.stackTrace = Thread.currentThread().stackTrace
    }

    override fun toString(): String {
        return "{" +
                "\"tag\":\"" + tag + '\"' +
                ", \"message\":\"" + message + '\"' +
                ", \"longMessage\":\"" + longMessage + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"stackTrace\":\"" + Arrays.toString(stackTrace) + '\"' +
                '}'
    }
}
