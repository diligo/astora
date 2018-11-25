package tech.diligo.astora.runner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SingleTestResultTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenExceptionNonProvidedForFailedTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Missing exception for failed test");

        new SingleTestResult("aaa", "bbb", TestState.FAILURE, null);
    }

    @Test
    public void shouldConvertToString() {
        assertEquals(
                "SingleTestResult{name='aaa', displayName='bbb', state=FAILURE, exception=java.lang.RuntimeException}",
                new SingleTestResult("aaa", "bbb", TestState.FAILURE, new RuntimeException()).toString());
    }
}
