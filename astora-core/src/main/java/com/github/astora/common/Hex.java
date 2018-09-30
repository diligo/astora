package com.github.astora.common;

public final class Hex {

    private static final String[] HEXES = new String[256];

    static {
        initHexes();
    }

    private Hex() {
    }

    private static void initHexes() {
        for (int i = 0; i < HEXES.length; i++) {
            String hex = Integer.toHexString((i - 128) & 0xff);
            HEXES[i] = hex.length() == 2 ? hex : "0" + hex;
        }
    }

    public static String toHexString(byte... bytes) {
        if (bytes == null) {
            return null;
        }

        if (bytes.length == 0) {
            return Strings.EMPTY_STRING;
        }

        StringBuilder builder = new StringBuilder(bytes.length << 1);

        for (int i = 0; i < bytes.length; i++) {
            builder.append(HEXES[bytes[i] + 128]);
        }

        return builder.toString();
    }

    public static String toHexString(int number) {
        return toHexString((byte) ((number >> 24) & 0xff), (byte) ((number >> 16) & 0xff),
                           (byte) ((number >> 8) & 0xff), (byte) (number & 0xff));
    }

    public static String toHexString(long number) {
        return toHexString((byte) ((number >> 56) & 0xff), (byte) ((number >> 48) & 0xff),
                           (byte) ((number >> 40) & 0xff), (byte) ((number >> 32) & 0xff),
                           (byte) ((number >> 24) & 0xff), (byte) ((number >> 16) & 0xff),
                           (byte) ((number >> 8) & 0xff), (byte) (number & 0xff));
    }
}
