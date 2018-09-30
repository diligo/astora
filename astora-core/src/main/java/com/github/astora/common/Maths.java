package com.github.astora.common;

import static com.github.astora.common.Requirements.requireArgument;

public final class Maths {

    public static final int MAX_INT_POWER_OF_TWO = 1073741824;
    public static final long MAX_LONG_POWER_OF_TWO = 4611686018427387904L;

    private Maths() {
    }

    /**
     * Check if long number is a power of two.
     *
     * @param num the number to be checked
     * @return true when the number is a power of two, false otherwise
     */
    public static boolean isPowerOfTwo(int num) {
        return ((num != 0) && ((num & (~num + 1)) == num));
    }

    /**
     * Check if int number is a power of two.
     *
     * @param num the number to be checked
     * @return true when the number is a power of two, false otherwise
     */
    public static boolean isPowerOfTwo(long num) {
        return ((num != 0L) && ((num & (~num + 1L)) == num));
    }

    /**
     * Find next power of two if the specified int number is not already a power of
     * two.
     *
     * @param num the number to be rounded
     * @return next power of two
     */
    public static int nextPowerOfTwo(int num) {
        return (int) nextPowerOfTwo((long) num);
    }

    /**
     * Find next power of two if the specified long number is not already a power of
     * two.
     *
     * @param num the number to be rounded
     * @return next power of two
     */
    public static long nextPowerOfTwo(long num) {
        requireArgument(num > 0 && num <= MAX_LONG_POWER_OF_TWO);
        num--;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        num++;
        return num;
    }

    /**
     * Find an exponent for base of two that gives specified int number.
     *
     * @param num value for power of two exponent
     * @return base of two exponent
     */
    public static int powerOfTwoExponent(int num) {
        requireArgument(isPowerOfTwo(num));
        return 32 - Integer.numberOfLeadingZeros(num - 1);
    }

    /**
     * Find an exponent for base of two that gives specified long number.
     *
     * @param num value for power of two exponent
     * @return base of two exponent
     */
    public static int powerOfTwoExponent(long num) {
        requireArgument(isPowerOfTwo(num));
        return 64 - Long.numberOfLeadingZeros(num - 1L);
    }
}
