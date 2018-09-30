package com.github.astora.common;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

public final class Requirements {

    private Requirements() {
    }

    public static void requireArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void requireArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void requireArgument(boolean expression, String errorMessagePattern, Object errorArg1) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }
    }

    public static void requireArgument(boolean expression, String errorMessagePattern,
                                       Object... errorMessageArguments) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }
    }

    public static void requireArgument(boolean expression, String errorMessagePattern, Object errorArg1,
                                       Object errorArg2) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }
    }

    public static void requireArgument(boolean expression, String errorMessagePattern, Object errorArg1,
                                       Object errorArg2, Object errorArg3) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }
    }

    public static void requireBounds(int size, int offset, int length) {
        if (size < 0) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (offset < 0) {
            throw new IllegalArgumentException("offset must not be negative, was: " + offset);
        } else if (length < 0) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (size < offset + length) {
            throw new IndexOutOfBoundsException(
                    "offset: " + offset + " + length: " + length + " must not be greatear than size: " + size);
        }
    }

    public static void requireBounds(long size, long offset, long length) {
        if (size < 0L) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (offset < 0L) {
            throw new IllegalArgumentException("offset must not be negative, was: " + offset);
        } else if (length < 0L) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (size < offset + length) {
            throw new IndexOutOfBoundsException(
                    "offset: " + offset + " + length: " + length + " must not be greatear than size: " + size);
        }
    }

    public static void requireElement(boolean expression) {
        if (!expression) {
            throw new NoSuchElementException();
        }
    }

    public static void requireElement(boolean expression, String errorMessage) {
        if (!expression) {
            throw new NoSuchElementException(errorMessage);
        }
    }

    public static void requireElement(boolean expression, String errorMessagePattern, Object errorArg1) {
        if (!expression) {
            throw new NoSuchElementException(Formats.format(errorMessagePattern, errorArg1));
        }
    }

    public static void requireElement(boolean expression, String errorMessagePattern, Object... errorMessageArguments) {
        if (!expression) {
            throw new NoSuchElementException(Formats.format(errorMessagePattern, errorMessageArguments));
        }
    }

    public static void requireElement(boolean expression, String errorMessagePattern, Object errorArg1,
                                      Object errorArg2) {
        if (!expression) {
            throw new NoSuchElementException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }
    }

    public static void requireElement(boolean expression, String errorMessagePattern, Object errorArg1,
                                      Object errorArg2, Object errorArg3) {
        if (!expression) {
            throw new NoSuchElementException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }
    }

    public static int requireElementIndex(int index, int size) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index must not be negative, was: " + index);
        } else if (size < 0) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " must be lesser than size: " + size);
        }

        return index;
    }

    public static long requireElementIndex(long index, long size) {
        if (index < 0L) {
            throw new IndexOutOfBoundsException("index must not be negative, was: " + index);
        } else if (size < 0L) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " must be lesser than size: " + size);
        }

        return index;
    }

    public static double requireNegative(double argument) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException("argument must be negative, was: " + argument);
        }

        return argument;
    }

    public static double requireNegative(double argument, String errorMessage) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static double requireNegative(double argument, String errorMessagePattern, Object errorArg1) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static double requireNegative(double argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static double requireNegative(double argument, String errorMessagePattern, Object errorArg1,
                                         Object errorArg2) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static double requireNegative(double argument, String errorMessagePattern, Object errorArg1,
                                         Object errorArg2, Object errorArg3) {
        if (argument >= 0.0) {
            throw new IllegalArgumentException(
                    MessageFormat.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static float requireNegative(float argument) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException("argument must be negative, was: " + argument);
        }

        return argument;
    }

    public static float requireNegative(float argument, String errorMessage) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static float requireNegative(float argument, String errorMessagePattern, Object errorArg1) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static float requireNegative(float argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static float requireNegative(float argument, String errorMessagePattern, Object errorArg1,
                                        Object errorArg2) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static float requireNegative(float argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                        Object errorArg3) {
        if (argument >= 0.0f) {
            throw new IllegalArgumentException(
                    MessageFormat.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static int requireNegative(int argument) {
        if (argument >= 0) {
            throw new IllegalArgumentException("argument must be negative, was: " + argument);
        }

        return argument;
    }

    public static int requireNegative(int argument, String errorMessage) {
        if (argument >= 0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static int requireNegative(int argument, String errorMessagePattern, Object errorArg1) {
        if (argument >= 0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static int requireNegative(int argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument >= 0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static int requireNegative(int argument, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (argument >= 0) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static int requireNegative(int argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                      Object errorArg3) {
        if (argument >= 0) {
            throw new IllegalArgumentException(
                    MessageFormat.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static long requireNegative(long argument) {
        if (argument >= 0L) {
            throw new IllegalArgumentException("argument must be negative, was: " + argument);
        }

        return argument;
    }

    public static long requireNegative(long argument, String errorMessage) {
        if (argument >= 0L) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static long requireNegative(long argument, String errorMessagePattern, Object errorArg1) {
        if (argument >= 0L) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static long requireNegative(long argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument >= 0L) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static long requireNegative(long argument, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (argument >= 0L) {
            throw new IllegalArgumentException(MessageFormat.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static long requireNegative(long argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                       Object errorArg3) {
        if (argument >= 0L) {
            throw new IllegalArgumentException(
                    MessageFormat.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static double requireNonNegative(double argument) {
        if (argument < 0.0) {
            throw new IllegalArgumentException("argument must be non negative, was: " + argument);
        }

        return argument;
    }

    public static double requireNonNegative(double argument, String errorMessage) {
        if (argument < 0.0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static float requireNonNegative(float argument) {
        if (argument < 0.0f) {
            throw new IllegalArgumentException("argument must be non negative, was: " + argument);
        }

        return argument;
    }

    public static float requireNonNegative(float argument, String errorMessage) {
        if (argument < 0.0f) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static int requireNonNegative(int argument) {
        if (argument < 0) {
            throw new IllegalArgumentException("argument must be non negative, was: " + argument);
        }

        return argument;
    }

    public static int requireNonNegative(int argument, String errorMessage) {
        if (argument < 0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static long requireNonNegative(long argument) {
        if (argument < 0L) {
            throw new IllegalArgumentException("argument must be non negative, was: " + argument);
        }

        return argument;
    }

    public static long requireNonNegative(long argument, String errorMessage) {
        if (argument < 0L) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static long requireNonNegative(long argument, String errorMessagePattern, Object errorArg1) {
        if (argument < 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static long requireNonNegative(long argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument < 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static long requireNonNegative(long argument, String errorMessagePattern, Object errorArg1,
                                          Object errorArg2) {
        if (argument < 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static long requireNonNegative(long argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                          Object errorArg3) {
        if (argument < 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static <T> T requireNonNull(T object) {
        if (object == null) {
            throw new NullPointerException();
        }

        return object;
    }

    public static <T> T requireNonNull(T object, String errorMessage) {
        if (object == null) {
            throw new NullPointerException(errorMessage);
        }

        return object;
    }

    public static <T> T requireNonNull(T object, String errorMessagePattern, Object errorArg1) {
        if (object == null) {
            throw new NullPointerException(Formats.format(errorMessagePattern, errorArg1));
        }

        return object;
    }

    public static <T> T requireNonNull(T object, String errorMessagePattern, Object... errorMessageArguments) {
        if (object == null) {
            throw new NullPointerException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return object;
    }

    public static <T> T requireNonNull(T object, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (object == null) {
            throw new NullPointerException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return object;
    }

    public static <T> T requireNonNull(T object, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                       Object errorArg3) {
        if (object == null) {
            throw new NullPointerException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return object;
    }

    public static double requireNonPositive(double argument) {
        if (argument > 0.0) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static double requireNonPositive(double argument, String errorMessage) {
        if (argument > 0.0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static float requireNonPositive(float argument) {
        if (argument > 0.0f) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static float requireNonPositive(float argument, String errorMessage) {
        if (argument > 0.0f) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static int requireNonPositive(int argument) {
        if (argument > 0) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static int requireNonPositive(int argument, String errorMessage) {
        if (argument > 0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static int requireNonPositive(int argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument > 0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static long requireNonPositive(long argument) {
        if (argument > 0L) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static long requireNonPositive(long argument, String errorMessage) {
        if (argument > 0L) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static long requireNonPositive(long argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument > 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static double requirePositive(double argument) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static double requirePositive(double argument, String errorMessage) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static double requirePositive(double argument, String errorMessagePattern, Object errorArg1) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static double requirePositive(double argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static double requirePositive(double argument, String errorMessagePattern, Object errorArg1,
                                         Object errorArg2) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static double requirePositive(double argument, String errorMessagePattern, Object errorArg1,
                                         Object errorArg2, Object errorArg3) {
        if (argument <= 0.0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static float requirePositive(float argument) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static float requirePositive(float argument, String errorMessage) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static float requirePositive(float argument, String errorMessagePattern, Object errorArg1) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static float requirePositive(float argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static float requirePositive(float argument, String errorMessagePattern, Object errorArg1,
                                        Object errorArg2) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static float requirePositive(float argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                        Object errorArg3) {
        if (argument <= 0.0f) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static int requirePositive(int argument) {
        if (argument <= 0) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static int requirePositive(int argument, String errorMessage) {
        if (argument <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static int requirePositive(int argument, String errorMessagePattern, Object errorArg1) {
        if (argument <= 0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static int requirePositive(int argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument <= 0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static int requirePositive(int argument, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (argument <= 0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static int requirePositive(int argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                      Object errorArg3) {
        if (argument <= 0) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static long requirePositive(long argument) {
        if (argument <= 0L) {
            throw new IllegalArgumentException("argument must be positive, was: " + argument);
        }

        return argument;
    }

    public static long requirePositive(long argument, String errorMessage) {
        if (argument <= 0L) {
            throw new IllegalArgumentException(errorMessage);
        }

        return argument;
    }

    public static long requirePositive(long argument, String errorMessagePattern, Object errorArg1) {
        if (argument <= 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1));
        }

        return argument;
    }

    public static long requirePositive(long argument, String errorMessagePattern, Object... errorMessageArguments) {
        if (argument <= 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }

        return argument;
    }

    public static long requirePositive(long argument, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (argument <= 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }

        return argument;
    }

    public static long requirePositive(long argument, String errorMessagePattern, Object errorArg1, Object errorArg2,
                                       Object errorArg3) {
        if (argument <= 0L) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return argument;
    }

    public static void requireState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void requireState(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalStateException(errorMessage);
        }
    }

    public static void requireState(boolean expression, String errorMessage, Object... errorMessageArguments) {
        if (!expression) {
            throw new IllegalStateException(Formats.format(errorMessage, errorMessageArguments));
        }
    }
}