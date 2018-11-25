package tech.diligo.astora.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void isNullOrEmptyShouldReturnTrueWhenStringIsNull() {
        assertEquals(true, Strings.isNullOrEmpty(null));
    }

    @Test
    public void isNullOrEmptyShouldReturnTrueWhenStringIsEmpty() {
        assertEquals(true, Strings.isNullOrEmpty(""));
    }

    @Test
    public void isNullOrEmptyShouldReturnFalseWhenStringIsNotEmpty() {
        assertEquals(false, Strings.isNullOrEmpty("abc"));
    }

    @Test
    public void isNullOrEmptyShouldReturnFalseWhenStringIsBlank() {
        assertEquals(false, Strings.isNullOrEmpty("   "));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsNull() {
        assertEquals(true, Strings.isNullOrBlank(null));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsEmpty() {
        assertEquals(true, Strings.isNullOrBlank(""));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsBlank() {
        assertEquals(true, Strings.isNullOrBlank("   "));
    }

    @Test
    public void isNullOrBlankSouldReturnTrueWhenStringIsNotEmpty() {
        assertEquals(false, Strings.isNullOrBlank("abc"));
    }

    @Test
    public void shouldReturnEmptyString() {
        assertEquals(true, Strings.empty().isEmpty());
    }

    @Test
    public void shouldGetUnderlayingStringCharacterArray() {
        String str = "abcdef";
        char[] chars = Strings.underlyingCharArray(str);
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '3';
        chars[3] = '4';
        chars[4] = '5';
        chars[5] = '6';

        assertEquals("123456", str);
    }
}
