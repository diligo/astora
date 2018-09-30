package com.github.astora.common;

public final class Formats {

    private static final String ARGUMENT_PATTERN = "{}";
    private static final char ARGUMENT_PATTERN_START_CHARACTER = '{';
    private static final char ESCAPE_CHARACTER = '\\';

    private Formats() {
    }

    private static void appendBooleanArray(StringBuilder builder, boolean[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendByteArray(StringBuilder builder, byte[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendCharArray(StringBuilder builder, char[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendDoubleArray(StringBuilder builder, double[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }

        }

        builder.append(']');
    }

    private static void appendFloatArray(StringBuilder builder, float[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendIntArray(StringBuilder builder, int[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendLongArray(StringBuilder builder, long[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendObjectArray(StringBuilder builder, Object[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            appendObjectRecursively(builder, array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    private static void appendObjectRecursively(StringBuilder builder, Object o) {
        if (o == null) {
            builder.append("null");
            return;
        }

        // TODO add toString() caching using identity hash map

        if (!o.getClass().isArray()) {
            safeObjectAppend(builder, o);
        } else {
            if (o instanceof boolean[]) {
                appendBooleanArray(builder, (boolean[]) o);
            } else if (o instanceof byte[]) {
                appendByteArray(builder, (byte[]) o);
            } else if (o instanceof char[]) {
                appendCharArray(builder, (char[]) o);
            } else if (o instanceof short[]) {
                appendShortArray(builder, (short[]) o);
            } else if (o instanceof int[]) {
                appendIntArray(builder, (int[]) o);
            } else if (o instanceof long[]) {
                appendLongArray(builder, (long[]) o);
            } else if (o instanceof float[]) {
                appendFloatArray(builder, (float[]) o);
            } else if (o instanceof double[]) {
                appendDoubleArray(builder, (double[]) o);
            } else {
                appendObjectArray(builder, (Object[]) o);
            }
        }
    }

    private static void appendShortArray(StringBuilder builder, short[] array) {
        builder.append('[');

        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);

            if (i != array.length - 1) {
                builder.append(',').append(' ');
            }
        }

        builder.append(']');
    }

    public static String format(String messagePattern, Object... args) {
        if (messagePattern == null || args.length == 0) {
            return messagePattern;
        }

        StringBuilder builder = new StringBuilder(messagePattern.length() + 64);
        int delimiterIndex;
        int fromIndex = 0;

        for (int argumentIndex = 0; argumentIndex < args.length; argumentIndex++) {
            delimiterIndex = messagePattern.indexOf(ARGUMENT_PATTERN, fromIndex);

            if (delimiterIndex == -1) {
                if (fromIndex == 0) {
                    return messagePattern;
                } else {
                    builder.append(messagePattern, fromIndex, messagePattern.length());
                    return builder.toString();
                }
            } else {
                if (isEscapedDelimeter(messagePattern, delimiterIndex)) {
                    if (!isDoubleEscaped(messagePattern, delimiterIndex)) {
                        argumentIndex--;
                        builder.append(messagePattern, fromIndex, delimiterIndex - 1);
                        builder.append(ARGUMENT_PATTERN_START_CHARACTER);
                        fromIndex = delimiterIndex + 1;
                    } else {
                        builder.append(messagePattern, fromIndex, delimiterIndex - 1);
                        appendObjectRecursively(builder, args[argumentIndex]);
                        fromIndex = delimiterIndex + 2;
                    }
                } else {
                    builder.append(messagePattern, fromIndex, delimiterIndex);
                    appendObjectRecursively(builder, args[argumentIndex]);
                    fromIndex = delimiterIndex + 2;
                }
            }
        }

        builder.append(messagePattern, fromIndex, messagePattern.length());
        return builder.toString();
    }

    private static boolean isDoubleEscaped(String messagePattern, int delimeterStartIndex) {
        return delimeterStartIndex >= 2 && messagePattern.charAt(delimeterStartIndex - 2) == ESCAPE_CHARACTER;
    }

    private static boolean isEscapedDelimeter(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex == 0) {
            return false;
        }

        return messagePattern.charAt(delimeterStartIndex - 1) == ESCAPE_CHARACTER;
    }

    private static void safeObjectAppend(StringBuilder builder, Object object) {
        try {
            String objectStr = object.toString();
            builder.append(objectStr);
        } catch (RuntimeException e) {
            builder.append("[toString() ERROR]");
        }
    }
}