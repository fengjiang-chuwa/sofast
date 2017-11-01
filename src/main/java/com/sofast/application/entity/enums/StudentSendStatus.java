package com.sofast.application.entity.enums;


import java.util.HashMap;
import java.util.Map;

public enum StudentSendStatus {

    REPLIED("replied", "Replied"),

    SENT("sent", "Sent"),

    NEW("new", "new");


    private static final Map<String, StudentSendStatus> NAME_TO_VALUE_MAP = new HashMap<>();

    static {
        for (StudentSendStatus code : StudentSendStatus.values()) {
            NAME_TO_VALUE_MAP.put(code.key, code);
        }
    }

    private final String key;
    private final String name;

    StudentSendStatus(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static StudentSendStatus forName(String name) {
        return NAME_TO_VALUE_MAP.get(name);
    }

    @Override
    public String toString() {
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}