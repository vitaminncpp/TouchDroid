package com.akshayaap.touchdroid.util.logger;

import java.util.Arrays;

public class LoggMessage {
    String tag;
    String message;
    String longMessage;
    String description;
    StackTraceElement stackTrace[] = null;

    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    public LoggMessage(String tag, String message, StackTraceElement[] stackTrace) {
        this.tag = tag;
        this.message = message;
        this.stackTrace = stackTrace;

        this.longMessage = null;
        this.description = null;
    }

    public LoggMessage(String tag, String message, String longMessage, StackTraceElement[] stackTrace) {
        this.tag = tag;
        this.message = message;
        this.longMessage = longMessage;
        this.stackTrace = stackTrace;

        this.description = null;
    }

    public LoggMessage(String tag, String message, String longMessage, String description, StackTraceElement[] stackTrace) {
        this.tag = tag;
        this.message = message;
        this.longMessage = longMessage;
        this.description = description;
        this.stackTrace = stackTrace;
    }

    public LoggMessage(String tag, String message) {
        this.tag = tag;
        this.message = message;

        this.longMessage = null;
        this.description = null;
        this.stackTrace = Thread.currentThread().getStackTrace();
    }


    @Override
    public String toString() {
        return "{" +
                "\"tag\":\"" + tag + '\"' +
                ", \"message\":\"" + message + '\"' +
                ", \"longMessage\":\"" + longMessage + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"stackTrace\":\"" + Arrays.toString(stackTrace) + '\"' +
                '}';
    }
}
