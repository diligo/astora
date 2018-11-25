package tech.diligo.astora.common;

import org.junit.Test;

import static org.junit.Assert.*;

public final class MathsTest {

    @Test
    public void shouldReturnTrueWhenIntNumberIsPowerOfTwo() {
        assertTrue(Maths.isPowerOfTwo(1));
        assertTrue(Maths.isPowerOfTwo(2));
        assertTrue(Maths.isPowerOfTwo(4));
        assertTrue(Maths.isPowerOfTwo(8));
        assertTrue(Maths.isPowerOfTwo(16));
        assertTrue(Maths.isPowerOfTwo(32));
        assertTrue(Maths.isPowerOfTwo(64));
        assertTrue(Maths.isPowerOfTwo(128));
        assertTrue(Maths.isPowerOfTwo(256));
        assertTrue(Maths.isPowerOfTwo(512));
        assertTrue(Maths.isPowerOfTwo(1024));
        assertTrue(Maths.isPowerOfTwo(2048));
        assertTrue(Maths.isPowerOfTwo(4096));
        assertTrue(Maths.isPowerOfTwo(8192));
        assertTrue(Maths.isPowerOfTwo(16384));
        assertTrue(Maths.isPowerOfTwo(32768));
        assertTrue(Maths.isPowerOfTwo(65536));
        assertTrue(Maths.isPowerOfTwo(131072));
        assertTrue(Maths.isPowerOfTwo(262144));
        assertTrue(Maths.isPowerOfTwo(524288));
        assertTrue(Maths.isPowerOfTwo(1048576));
        assertTrue(Maths.isPowerOfTwo(2097152));
        assertTrue(Maths.isPowerOfTwo(4194304));
        assertTrue(Maths.isPowerOfTwo(8388608));
        assertTrue(Maths.isPowerOfTwo(16777216));
        assertTrue(Maths.isPowerOfTwo(33554432));
        assertTrue(Maths.isPowerOfTwo(67108864));
        assertTrue(Maths.isPowerOfTwo(134217728));
        assertTrue(Maths.isPowerOfTwo(268435456));
        assertTrue(Maths.isPowerOfTwo(536870912));
        assertTrue(Maths.isPowerOfTwo(1073741824));
    }

    @Test
    public void shouldReturnFalseWhenIntNumberIsNotPowerOfTwo() {
        assertFalse(Maths.isPowerOfTwo(-64));
        assertFalse(Maths.isPowerOfTwo(-1));
        assertFalse(Maths.isPowerOfTwo(0));
        assertFalse(Maths.isPowerOfTwo(3));
        assertFalse(Maths.isPowerOfTwo(13));
        assertFalse(Maths.isPowerOfTwo(17));
    }

    @Test
    public void shouldFindNextIntPowerOfTwo() {
        assertEquals(4, Maths.nextPowerOfTwo(3));
        assertEquals(16, Maths.nextPowerOfTwo(15));
        assertEquals(16, Maths.nextPowerOfTwo(16));
        assertEquals(32, Maths.nextPowerOfTwo(17));
        assertEquals(1073741824, Maths.nextPowerOfTwo(1073741823));
        assertEquals(1073741824, Maths.nextPowerOfTwo(1073741824));
    }

    @Test
    public void shouldReturnTrueWhenLongNumberIsPowerOfTwo() {
        assertTrue(Maths.isPowerOfTwo(1L));
        assertTrue(Maths.isPowerOfTwo(2L));
        assertTrue(Maths.isPowerOfTwo(4L));
        assertTrue(Maths.isPowerOfTwo(8L));
        assertTrue(Maths.isPowerOfTwo(16L));
        assertTrue(Maths.isPowerOfTwo(32L));
        assertTrue(Maths.isPowerOfTwo(64L));
        assertTrue(Maths.isPowerOfTwo(128L));
        assertTrue(Maths.isPowerOfTwo(256L));
        assertTrue(Maths.isPowerOfTwo(512L));
        assertTrue(Maths.isPowerOfTwo(1024L));
        assertTrue(Maths.isPowerOfTwo(2048L));
        assertTrue(Maths.isPowerOfTwo(4096L));
        assertTrue(Maths.isPowerOfTwo(8192L));
        assertTrue(Maths.isPowerOfTwo(16384L));
        assertTrue(Maths.isPowerOfTwo(32768L));
        assertTrue(Maths.isPowerOfTwo(65536L));
        assertTrue(Maths.isPowerOfTwo(131072L));
        assertTrue(Maths.isPowerOfTwo(262144L));
        assertTrue(Maths.isPowerOfTwo(524288L));
        assertTrue(Maths.isPowerOfTwo(1048576L));
        assertTrue(Maths.isPowerOfTwo(2097152L));
        assertTrue(Maths.isPowerOfTwo(4194304L));
        assertTrue(Maths.isPowerOfTwo(8388608L));
        assertTrue(Maths.isPowerOfTwo(16777216L));
        assertTrue(Maths.isPowerOfTwo(33554432L));
        assertTrue(Maths.isPowerOfTwo(67108864L));
        assertTrue(Maths.isPowerOfTwo(134217728L));
        assertTrue(Maths.isPowerOfTwo(268435456L));
        assertTrue(Maths.isPowerOfTwo(536870912L));
        assertTrue(Maths.isPowerOfTwo(1073741824L));
        assertTrue(Maths.isPowerOfTwo(2147483648L));
        assertTrue(Maths.isPowerOfTwo(4294967296L));
        assertTrue(Maths.isPowerOfTwo(8589934592L));
        assertTrue(Maths.isPowerOfTwo(17179869184L));
        assertTrue(Maths.isPowerOfTwo(34359738368L));
        assertTrue(Maths.isPowerOfTwo(68719476736L));
        assertTrue(Maths.isPowerOfTwo(137438953472L));
        assertTrue(Maths.isPowerOfTwo(274877906944L));
        assertTrue(Maths.isPowerOfTwo(549755813888L));
        assertTrue(Maths.isPowerOfTwo(1099511627776L));
        assertTrue(Maths.isPowerOfTwo(2199023255552L));
        assertTrue(Maths.isPowerOfTwo(4398046511104L));
        assertTrue(Maths.isPowerOfTwo(8796093022208L));
        assertTrue(Maths.isPowerOfTwo(17592186044416L));
        assertTrue(Maths.isPowerOfTwo(35184372088832L));
        assertTrue(Maths.isPowerOfTwo(70368744177664L));
        assertTrue(Maths.isPowerOfTwo(140737488355328L));
        assertTrue(Maths.isPowerOfTwo(281474976710656L));
        assertTrue(Maths.isPowerOfTwo(562949953421312L));
        assertTrue(Maths.isPowerOfTwo(1125899906842624L));
        assertTrue(Maths.isPowerOfTwo(2251799813685248L));
        assertTrue(Maths.isPowerOfTwo(4503599627370496L));
        assertTrue(Maths.isPowerOfTwo(9007199254740992L));
        assertTrue(Maths.isPowerOfTwo(18014398509481984L));
        assertTrue(Maths.isPowerOfTwo(36028797018963968L));
        assertTrue(Maths.isPowerOfTwo(72057594037927936L));
        assertTrue(Maths.isPowerOfTwo(144115188075855872L));
        assertTrue(Maths.isPowerOfTwo(288230376151711744L));
        assertTrue(Maths.isPowerOfTwo(576460752303423488L));
        assertTrue(Maths.isPowerOfTwo(1152921504606846976L));
        assertTrue(Maths.isPowerOfTwo(2305843009213693952L));
        assertTrue(Maths.isPowerOfTwo(4611686018427387904L));
    }

    @Test
    public void shouldReturnFalseWhenLongNumberIsNotPowerOfTwo() {
        assertFalse(Maths.isPowerOfTwo(-64L));
        assertFalse(Maths.isPowerOfTwo(-1L));
        assertFalse(Maths.isPowerOfTwo(0L));
        assertFalse(Maths.isPowerOfTwo(3L));
        assertFalse(Maths.isPowerOfTwo(13L));
        assertFalse(Maths.isPowerOfTwo(17L));
    }

    @Test
    public void shouldFindNextLongPowerOfTwo() {
        assertEquals(4L, Maths.nextPowerOfTwo(3L));
        assertEquals(16L, Maths.nextPowerOfTwo(15L));
        assertEquals(16L, Maths.nextPowerOfTwo(16L));
        assertEquals(32L, Maths.nextPowerOfTwo(17L));
        assertEquals(1073741824L, Maths.nextPowerOfTwo(1073741823L));
        assertEquals(1073741824L, Maths.nextPowerOfTwo(1073741824L));
        assertEquals(4611686018427387904L, Maths.nextPowerOfTwo(4611686018427387903L));
        assertEquals(4611686018427387904L, Maths.nextPowerOfTwo(4611686018427387904L));
    }

    @Test
    public void shouldFindPowerOfTwoExponentForInt() {
        assertEquals(0, Maths.powerOfTwoExponent(1));
        assertEquals(6, Maths.powerOfTwoExponent(64));
        assertEquals(30, Maths.powerOfTwoExponent(1073741824));
    }

    @Test
    public void shouldFindPowerOfTwoExponentForLong() {
        assertEquals(0, Maths.powerOfTwoExponent(1L));
        assertEquals(6, Maths.powerOfTwoExponent(64L));
        assertEquals(30, Maths.powerOfTwoExponent(1073741824L));
        assertEquals(62, Maths.powerOfTwoExponent(4611686018427387904L));
    }

    @Test
    public void shouldReturnSquareRootOfIntNumber() {
        assertEquals(2, Maths.sqrt(4));
        assertEquals(2, Maths.sqrt(5));
        assertEquals(3, Maths.sqrt(13));
        assertEquals(10, Maths.sqrt(100));
        assertEquals(46340, Maths.sqrt(Integer.MAX_VALUE));
    }

    @Test
    public void shouldReturnSquareRootOfLongNumber() {
        assertEquals(2L, Maths.sqrt(4L));
        assertEquals(2L, Maths.sqrt(5L));
        assertEquals(3L, Maths.sqrt(13L));
        assertEquals(10, Maths.sqrt(100L));
        assertEquals(3037000499L, Maths.sqrt(Long.MAX_VALUE));
    }

    @Test
    public void shouldReturnTrueWhenIntNumberIsPrime() {
        assertTrue(Maths.isPrime(2));
        assertTrue(Maths.isPrime(3));
        assertTrue(Maths.isPrime(13));
        assertTrue(Maths.isPrime(29));
        assertTrue(Maths.isPrime(65_521));
    }

    @Test
    public void shouldReturnFlaseWhenIntNumberIsNotPrime() {
        assertFalse(Maths.isPrime(-1));
        assertFalse(Maths.isPrime(0));
        assertFalse(Maths.isPrime(1));
        assertFalse(Maths.isPrime(4));
        assertFalse(Maths.isPrime(8));
        assertFalse(Maths.isPrime(27));
        assertFalse(Maths.isPrime(100));
        assertFalse(Maths.isPrime(128));
        assertFalse(Maths.isPrime(65_535));
    }

    @Test
    public void shouldReturnFalseWhenLongNumberIsPrime() {
        assertTrue(Maths.isPrime(2L));
        assertTrue(Maths.isPrime(3L));
        assertTrue(Maths.isPrime(13L));
        assertTrue(Maths.isPrime(29L));
        assertTrue(Maths.isPrime(65_521L));
        assertTrue(Maths.isPrime(2_147_483_647L));
    }

    @Test
    public void shouldReturnFalseWhenLongNumberIsNotPrime() {
        assertFalse(Maths.isPrime(-1L));
        assertFalse(Maths.isPrime(0L));
        assertFalse(Maths.isPrime(1L));
        assertFalse(Maths.isPrime(4L));
        assertFalse(Maths.isPrime(8L));
        assertFalse(Maths.isPrime(27L));
        assertFalse(Maths.isPrime(100L));
        assertFalse(Maths.isPrime(128L));
        assertFalse(Maths.isPrime(65_535L));
        assertFalse(Maths.isPrime(9_223_372_036_854_775_807L));
    }
}

