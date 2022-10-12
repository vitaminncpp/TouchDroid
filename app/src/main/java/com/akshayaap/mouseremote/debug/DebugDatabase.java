package com.akshayaap.mouseremote.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DebugDatabase {
    private final Map<String, ArrayList<LoggMessage>> database;

    public DebugDatabase() {
        database = new HashMap<>();
    }

    public void addMessage(LoggMessage message) {
        ArrayList<LoggMessage> messages = database.get(message.getTag());
        if (messages == null) {
            messages = new ArrayList<>();
            database.put(message.getTag(), messages);
        }
        messages.add(message);
    }

    public ArrayList<LoggMessage> getMessages(String tag) {
        return database.get(tag);
    }

    public ArrayList<LoggMessage> getAllMessages() {
        ArrayList<LoggMessage> list = new ArrayList<>();
        for (String key : database.keySet()) {
            list.addAll(database.get(key));
        }
        return list;
    }
}
