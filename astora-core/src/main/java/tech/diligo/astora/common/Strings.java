package tech.diligo.astora.common;

import java.lang.reflect.Field;

import static tech.diligo.astora.common.Requirements.requireNonNull;

public final class Strings {

    public static final String EMPTY_STRING = "";
    private static final String STRING_FIELD_VALUE = "value";

    private Strings() {
    }

    public static String empty() {
        return EMPTY_STRING;
    }

    public static char[] getUnderlyingCharArray(String str) {
        requireNonNull(str);

        Field valueField = Reflections.getDeclaredFieldAndSetAccessible(String.class, STRING_FIELD_VALUE);

        try {
            return (char[]) valueField.get(str);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Unable to get String underlying char array", e);
        }
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
