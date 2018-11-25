package tech.diligo.astora.common;

import org.hamcrest.core.IsNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RequirementsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotThrowExceptionWhenExpressionIsTrue() {
        Requirements.requireArgument(true);
    }

    @Test
    public void shouldThrowExceptionWithNoMessageWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(IsNull.nullValue(String.class));

        Requirements.requireArgument(false);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenExpressionIsTrue() {
        Requirements.requireArgument(true, "error message");
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("error message");

        Requirements.requireArgument(false, "error message");
    }

    @Test
    public void shouldNotThrowExceptionWithOneMessageArgumentWhenExpressionIsTrue() {
        Requirements.requireArgument(true, "error message: {}", "foo");
    }

    @Test
    public void shouldThrowExceptionWithOneMessageArgumentWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("error message: foo");

        Requirements.requireArgument(false, "error message: {}", "foo");
    }

    @Test
    public void shouldNotThrowExceptionWithTwoMessageArgumentWhenExpressionIsTrue() {
        Requirements.requireArgument(true, "error message: {}, {}", "foo", 10);
    }

    @Test
    public void shouldThrowExceptionWithTwoMessageArgumentWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("error message: foo, 10");

        Requirements.requireArgument(false, "error message: {}, {}", "foo", 10);
    }

    @Test
    public void shouldNotThrowExceptionWithThreeMessageArgumentWhenExpressionIsTrue() {
        Requirements.requireArgument(true, "error message: {}, {}, {}", "foo", 10, 12.34);
    }

    @Test
    public void shouldThrowExceptionWithThreeMessageArgumentWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("error message: foo, 10, 12.34");

        Requirements.requireArgument(false, "error message: {}, {}, {}", "foo", 10, 12.34);
    }

    @Test
    public void shouldNotThrowExceptionWithFourMessageArgumentWhenExpressionIsTrue() {
        Requirements.requireArgument(true, "error message: {}, {}, {}, {}", "foo", 10, 12.34, new int[]{5, 3, 1});
    }

    @Test
    public void shouldThrowExceptionWithFourMessageArgumentWhenExpressionIsFalse() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("error message: foo, 10, 12.34, [5, 3, 1]");

        Requirements.requireArgument(false, "error message: {}, {}, {}, {}", "foo", 10, 12.34, new int[]{5, 3, 1});
    }

    @Test
    public void shouldNotThrowExceptionWhenIntSizeIsAvailable() {
        Requirements.requireSpace(5, 10, 15);
    }

    @Test
    public void shouldThrowExceptionWhenIntSizeIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("size must not be negative, was: -1");

        Requirements.requireSpace(-1, 10, 15);
    }

    @Test
    public void shouldThrowExceptionWhenIntOffsetIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("offset must not be negative, was: -1");

        Requirements.requireSpace(5, -1, 15);
    }

    @Test
    public void shouldThrowExceptionWhenIntOffsetIsGreaterThanLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("offset: 16 must not be greater than length: 15");

        Requirements.requireSpace(5, 16, 15);
    }

    @Test
    public void shouldThrowExceptionWhenIntLengthIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be negative, was: -1");

        Requirements.requireSpace(5, 10, -1);
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughIntSpace() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("not enough space: 6, available: 5");

        Requirements.requireSpace(6, 10, 15);
    }

    @Test
    public void shouldNotThrowExceptionWhenLongSizeIsAvailable() {
        Requirements.requireSpace(5L, 10L, 15L);
    }

    @Test
    public void shouldThrowExceptionWhenLongSizeIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("size must not be negative, was: -1");

        Requirements.requireSpace(-1L, 10L, 15L);
    }

    @Test
    public void shouldThrowExceptionWhenLongOffsetIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("offset must not be negative, was: -1");

        Requirements.requireSpace(5L, -1L, 15L);
    }

    @Test
    public void shouldThrowExceptionWhenLongOffsetIsGreaterThanLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("offset: 16 must not be greater than length: 15");

        Requirements.requireSpace(5L, 16L, 15L);
    }

    @Test
    public void shouldThrowExceptionWhenLongLengthIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be negative, was: -1");

        Requirements.requireSpace(5L, 10L, -1L);
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughLongSpace() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("not enough space: 6, available: 5");

        Requirements.requireSpace(6L, 10L, 15L);
    }

    @Test
    public void shouldNotThrowExceptionWhenIntElementIndexWithinBounds() {
        Requirements.requireElementIndex(9, 10);
    }

    @Test
    public void shouldThrowExceptionWhenIntElementIndexIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("index must not be negative, was: -1");

        Requirements.requireElementIndex(-1, 10);
    }

    @Test
    public void shouldThrowExceptionWhenIntElementIndexSizeIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be negative, was: -10");

        Requirements.requireElementIndex(1, -10);
    }

    @Test
    public void shouldThrowExceptionWhenIntElementIndexIsOutOfBounds() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("index: 1, length: 1");

        Requirements.requireElementIndex(1, 1);
    }

    @Test
    public void shouldNotThrowExceptionWhenLongElementIndexWithinBounds() {
        Requirements.requireElementIndex(9L, 10L);
    }

    @Test
    public void shouldThrowExceptionWhenLongElementIndexIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("index must not be negative, was: -1");

        Requirements.requireElementIndex(-1L, 10L);
    }

    @Test
    public void shouldThrowExceptionWhenLongElementIndexSizeIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be negative, was: -10");

        Requirements.requireElementIndex(1L, -10L);
    }

    @Test
    public void shouldThrowExceptionWhenLongElementIndexIsOutOfBounds() {
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("index: 1, length: 1");

        Requirements.requireElementIndex(1L, 1L);
    }

    // negative int

    @Test
    public void shouldNotThrowExceptionWhenIntNumberIsNegative() {
        Requirements.requireNegative(Integer.MIN_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenIntNumberIsNegative() {
        Requirements.requireNegative(-1, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenIntNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("2147483647 must be < 0");

        Requirements.requireNegative(Integer.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenIntNumberIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be < 0");

        Requirements.requireNegative(0);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenIntNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=12345 must be < 0");

        Requirements.requireNegative(12345, "varName");
    }

    // negative long

    @Test
    public void shouldNotThrowExceptionWhenLongNumberIsNegative() {
        Requirements.requireNegative(Long.MIN_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenLongNumberIsNegative() {
        Requirements.requireNegative(-1L, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenLongNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("9223372036854775807 must be < 0");

        Requirements.requireNegative(Long.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenLongNumberIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be < 0");

        Requirements.requireNegative(0L);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenLongNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=12345 must be < 0");

        Requirements.requireNegative(12345L, "varName");
    }

    // negative float

    @Test
    public void shouldNotThrowExceptionWhenFloatNumberIsNegative() {
        Requirements.requireNegative(-Float.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenFloatNumberIsNegative() {
        Requirements.requireNegative(-1.0f, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenFloatNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("3.4028235E38 must be < 0");

        Requirements.requireNegative(Float.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenFloatNumberIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be < 0");

        Requirements.requireNegative(0.0f);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenFloatNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=12345.0 must be < 0");

        Requirements.requireNegative(12345.0f, "varName");
    }

    // negative double

    @Test
    public void shouldNotThrowExceptionWhenDoubleNumberIsNegative() {
        Requirements.requireNegative(-Double.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenDoubleNumberIsNegative() {
        Requirements.requireNegative(-1.0, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenDoubleNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("1.7976931348623157E308 must be < 0");

        Requirements.requireNegative(Double.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenDoubleNumberIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be < 0");

        Requirements.requireNegative(0.0);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenDoubleNumberIsPositive() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=12345.0 must be < 0");

        Requirements.requireNegative(12345.0, "varName");
    }

    // non negative int

    @Test
    public void shouldNotThrowExceptionWhenIntNumberIsNonNegative() {
        Requirements.requireNonNegative(Integer.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenIntNumberIsNonNegative() {
        Requirements.requireNonNegative(1, "varName");
    }

    @Test
    public void shouldNotThrowExceptionWhenIntNumberIsZero() {
        Requirements.requireNonNegative(0);
    }

    @Test
    public void shouldThrowExceptionWhenIntNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-2147483648 must be >= 0");

        Requirements.requireNonNegative(Integer.MIN_VALUE);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenIntNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345 must be >= 0");

        Requirements.requireNonNegative(-12345, "varName");
    }

    // non negative long

    @Test
    public void shouldNotThrowExceptionWhenLongNumberIsNonNegative() {
        Requirements.requireNonNegative(Long.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenLongNumberIsNonNegative() {
        Requirements.requireNonNegative(1L, "varName");
    }

    @Test
    public void shouldNotThrowExceptionWhenLongNumberIsZero() {
        Requirements.requireNonNegative(0L);
    }

    @Test
    public void shouldThrowExceptionWhenLongNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-9223372036854775808 must be >= 0");

        Requirements.requireNonNegative(Long.MIN_VALUE);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenLongNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345 must be >= 0");

        Requirements.requireNonNegative(-12345L, "varName");
    }

    // non negative float

    @Test
    public void shouldNotThrowExceptionWhenFloatNumberIsNonNegative() {
        Requirements.requireNonNegative(Float.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenFloatNumberIsNonNegative() {
        Requirements.requireNonNegative(1.0f, "varName");
    }

    @Test
    public void shouldNotThrowExceptionWhenFloatNumberIsZero() {
        Requirements.requireNonNegative(0.0f);
    }

    @Test
    public void shouldThrowExceptionWhenFloatNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-3.4028235E38 must be >= 0");

        Requirements.requireNonNegative(-Float.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenFloatNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345.0 must be >= 0");

        Requirements.requireNonNegative(-12345.0f, "varName");
    }

    // non negative double

    @Test
    public void shouldNotThrowExceptionWhenDoubleNumberIsNonNegative() {
        Requirements.requireNonNegative(Double.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenDoubleNumberIsNonNegative() {
        Requirements.requireNonNegative(1.0, "varName");
    }

    @Test
    public void shouldNotThrowExceptionWhenDoubleNumberIsZero() {
        Requirements.requireNonNegative(0.0);
    }

    @Test
    public void shouldThrowExceptionWhenDoubleNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-1.7976931348623157E308 must be >= 0");

        Requirements.requireNonNegative(-Double.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenDoubleNumberIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345.0 must be >= 0");

        Requirements.requireNonNegative(-12345.0, "varName");
    }

    // positive int

    @Test
    public void shouldNotThrowExceptionWhenIntValueIsPositive() {
        Requirements.requirePositive(Integer.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenIntValueIsPositive() {
        Requirements.requirePositive(1, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenIntValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-2147483648 must be > 0");

        Requirements.requirePositive(Integer.MIN_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenIntValueIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be > 0");

        Requirements.requirePositive(0);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenIntValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345 must be > 0");

        Requirements.requirePositive(-12345, "varName");
    }

    // positive long

    @Test
    public void shouldNotThrowExceptionWhenLongValueIsPositive() {
        Requirements.requirePositive(Long.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenLongValueIsPositive() {
        Requirements.requirePositive(1L, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenLongValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-9223372036854775808 must be > 0");

        Requirements.requirePositive(Long.MIN_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenLongValueIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0 must be > 0");

        Requirements.requirePositive(0L);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenLongValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345 must be > 0");

        Requirements.requirePositive(-12345L, "varName");
    }

    // positive float

    @Test
    public void shouldNotThrowExceptionWhenFloatValueIsPositive() {
        Requirements.requirePositive(Float.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenFloatValueIsPositive() {
        Requirements.requirePositive(1.0f, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenFloatValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-3.4028235E38 must be > 0");

        Requirements.requirePositive(-Float.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenFloatValueIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0.0 must be > 0");

        Requirements.requirePositive(0.0f);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenFloatValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345.0 must be > 0");

        Requirements.requirePositive(-12345.0f, "varName");
    }

    // positive double

    @Test
    public void shouldNotThrowExceptionWhenDoubleValueIsPositive() {
        Requirements.requirePositive(Double.MAX_VALUE);
    }

    @Test
    public void shouldNotThrowExceptionWithMessageWhenDoubleValueIsPositive() {
        Requirements.requirePositive(1.0, "varName");
    }

    @Test
    public void shouldThrowExceptionWhenDoubleValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("-1.7976931348623157E308 must be > 0");

        Requirements.requirePositive(-Double.MAX_VALUE);
    }

    @Test
    public void shouldThrowExceptionWhenDoubleValueIsZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("0.0 must be > 0");

        Requirements.requirePositive(0.0);
    }

    @Test
    public void shouldThrowExceptionWithMessageWhenDoubleValueIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("varName=-12345.0 must be > 0");

        Requirements.requirePositive(-12345.0, "varName");
    }

    // TODO non positive int
    // TODO non positive long
    // TODO non positive float
    // TODO non positive double
}
