package com.github.astora.common;

import java.lang.reflect.Field;

public final class Strings {

    public static final String EMPTY_STRING = "";

    private Strings() {
    }

    public static String empty() {
        return EMPTY_STRING;
    }

    public static char[] underlyingCharArray(String str) {
        try {
            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            return (char[]) valueField.get(str);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Unable to get String class underlying char array", e);
        }
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
