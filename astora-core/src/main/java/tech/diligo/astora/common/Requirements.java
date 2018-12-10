package tech.diligo.astora.common;

public final class Requirements {

    private Requirements() {
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

    public static <T> T requireNonNull(
            T object, String errorMessagePattern, Object errorArg1, Object errorArg2, Object errorArg3) {
        if (object == null) {
            throw new NullPointerException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }

        return object;
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

    public static void requireArgument(
            boolean expression, String errorMessagePattern, Object errorArg1, Object errorArg2) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2));
        }
    }

    public static void requireArgument(
            boolean expression, String errorMessagePattern, Object errorArg1, Object errorArg2, Object errorArg3) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorArg1, errorArg2, errorArg3));
        }
    }

    public static void requireArgument(
            boolean expression, String errorMessagePattern, Object... errorMessageArguments) {
        if (!expression) {
            throw new IllegalArgumentException(Formats.format(errorMessagePattern, errorMessageArguments));
        }
    }

    public static void requireSpace(int size, int offset, int length) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset must not be negative, was: " + offset);
        } else if (length < 0) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (offset > length) {
            throw new IllegalArgumentException("offset: " + offset + " must not be greater than length: " + length);
        } else if (size < 0) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (size > length - offset) {
            throw new IndexOutOfBoundsException("not enough space: " + size + ", available: " + (length - offset));
        }
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

    public static void requireSpace(long size, long offset, long length) {
        if (offset < 0L) {
            throw new IllegalArgumentException("offset must not be negative, was: " + offset);
        } else if (length < 0L) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (offset > length) {
            throw new IllegalArgumentException("offset: " + offset + " must not be greater than length: " + length);
        } else if (size < 0L) {
            throw new IllegalArgumentException("size must not be negative, was: " + size);
        } else if (size > length - offset) {
            throw new IndexOutOfBoundsException("not enough space: " + size + ", available: " + (length - offset));
        }
    }

    public static int requireElementIndex(int index, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (index < 0) {
            throw new IllegalArgumentException("index must not be negative, was: " + index);
        } else if (index >= length) {
            throw new IndexOutOfBoundsException("index: " + index + ", length: " + length);
        }

        return index;
    }

    public static long requireElementIndex(long index, long length) {
        if (length < 0L) {
            throw new IllegalArgumentException("length must not be negative, was: " + length);
        } else if (index < 0L) {
            throw new IllegalArgumentException("index must not be negative, was: " + index);
        } else if (index >= length) {
            throw new IndexOutOfBoundsException("index: " + index + ", length: " + length);
        }

        return index;
    }

    public static int requireNegative(int value) {
        if (value >= 0L) {
            throw new IllegalArgumentException(value + " must be < 0");
        }

        return value;
    }

    public static int requireNegative(int value, String name) {
        if (value >= 0L) {
            throw new IllegalArgumentException(name + "=" + value + " must be < 0");
        }

        return value;
    }

    public static long requireNegative(long value) {
        if (value >= 0L) {
            throw new IllegalArgumentException(value + " must be < 0");
        }

        return value;
    }

    public static long requireNegative(long value, String name) {
        if (value >= 0L) {
            throw new IllegalArgumentException(name + "=" + value + " must be < 0");
        }

        return value;
    }

    public static float requireNegative(float value) {
        if (value >= 0.0f) {
            throw new IllegalArgumentException(value + " must be < 0");
        }

        return value;
    }

    public static float requireNegative(float value, String name) {
        if (value >= 0.0f) {
            throw new IllegalArgumentException(name + "=" + value + " must be < 0");
        }

        return value;
    }

    public static double requireNegative(double value) {
        if (value >= 0.0) {
            throw new IllegalArgumentException(value + " must be < 0");
        }

        return value;
    }

    public static double requireNegative(double value, String name) {
        if (value >= 0.0) {
            throw new IllegalArgumentException(name + "=" + value + " must be < 0");
        }

        return value;
    }

    public static int requireNonNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(value + " must be >= 0");
        }

        return value;
    }

    public static int requireNonNegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + "=" + value + " must be >= 0");
        }

        return value;
    }

    public static long requireNonNegative(long value) {
        if (value < 0L) {
            throw new IllegalArgumentException(value + " must be >= 0");
        }

        return value;
    }

    public static long requireNonNegative(long value, String name) {
        if (value < 0L) {
            throw new IllegalArgumentException(name + "=" + value + " must be >= 0");
        }

        return value;
    }

    public static float requireNonNegative(float value) {
        if (value < 0.0f) {
            throw new IllegalArgumentException(value + " must be >= 0");
        }

        return value;
    }

    public static float requireNonNegative(float value, String name) {
        if (value < 0.0f) {
            throw new IllegalArgumentException(name + "=" + value + " must be >= 0");
        }

        return value;
    }

    public static double requireNonNegative(double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException(value + " must be >= 0");
        }

        return value;
    }

    public static double requireNonNegative(double value, String name) {
        if (value < 0.0) {
            throw new IllegalArgumentException(name + "=" + value + " must be >= 0");
        }

        return value;
    }

    public static int requirePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(value + " must be > 0");
        }

        return value;
    }

    public static int requirePositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + "=" + value + " must be > 0");
        }

        return value;
    }

    public static long requirePositive(long value) {
        if (value <= 0L) {
            throw new IllegalArgumentException(value + " must be > 0");
        }

        return value;
    }

    public static long requirePositive(long value, String name) {
        if (value <= 0L) {
            throw new IllegalArgumentException(name + "=" + value + " must be > 0");
        }

        return value;
    }

    public static float requirePositive(float value) {
        if (value <= 0.0f) {
            throw new IllegalArgumentException(value + " must be > 0");
        }

        return value;
    }

    public static float requirePositive(float value, String name) {
        if (value <= 0.0f) {
            throw new IllegalArgumentException(name + "=" + value + " must be > 0");
        }

        return value;
    }

    public static double requirePositive(double value) {
        if (value <= 0.0) {
            throw new IllegalArgumentException(value + " must be > 0");
        }

        return value;
    }

    public static double requirePositive(double value, String name) {
        if (value <= 0.0) {
            throw new IllegalArgumentException(name + "=" + value + " must be > 0");
        }

        return value;
    }

    public static int requireNonPositive(int value) {
        if (value > 0) {
            throw new IllegalArgumentException(value + " must be <= 0");
        }

        return value;
    }

    public static int requireNonPositive(int value, String name) {
        if (value > 0) {
            throw new IllegalArgumentException(name + "=" + value + " must be <= 0");
        }

        return value;
    }

    public static long requireNonPositive(long value) {
        if (value > 0L) {
            throw new IllegalArgumentException(value + " must be <= 0");
        }

        return value;
    }

    public static long requireNonPositive(long value, String name) {
        if (value > 0L) {
            throw new IllegalArgumentException(name + "=" + value + " must be <= 0");
        }

        return value;
    }

    public static float requireNonPositive(float value) {
        if (value > 0.0f) {
            throw new IllegalArgumentException(value + " must be <= 0");
        }

        return value;
    }

    public static float requireNonPositive(float value, String name) {
        if (value > 0.0f) {
            throw new IllegalArgumentException(name + "=" + value + " must be <= 0");
        }

        return value;
    }

    public static double requireNonPositive(double value) {
        if (value > 0.0) {
            throw new IllegalArgumentException(value + " must be <= 0");
        }

        return value;
    }

    public static double requireNonPositive(double value, String name) {
        if (value > 0.0) {
            throw new IllegalArgumentException(name + "=" + value + " must be <= 0");
        }

        return value;
    }
}