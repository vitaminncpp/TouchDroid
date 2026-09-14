package com.akshayaap.touchdroid.debug

import com.akshayaap.touchdroid.util.logger.LoggMessage

class DebugDatabase {
    private val database: MutableMap<String, ArrayList<LoggMessage>> = HashMap()

    fun addMessage(message: LoggMessage) {
        val tag = message.tag ?: "default"
        val messages = database.getOrPut(tag) { ArrayList() }
        messages.add(message)
    }

    fun getMessages(tag: String): ArrayList<LoggMessage>? {
        return database[tag]
    }

    fun getAllMessages(): ArrayList<LoggMessage> {
        val list = ArrayList<LoggMessage>()
        for (messages in database.values) {
            list.addAll(messages)
        }
        return list
    }
}
