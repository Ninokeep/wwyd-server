package com.walkwithmydog.walkwithmydog.utils.dog;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    UNKNOW("unknow");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}