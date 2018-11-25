package tech.diligo.astora.runner;

import org.junit.AssumptionViolatedException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

public class RunnersTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldRunSingleTestWithSuccess() throws InitializationError {
        SingleTestResult result = Runners.runSingleTest(new BlockJUnit4ClassRunner(SingleTestExecutorTarget.class),
                "shouldSucceed");

        assertEquals("shouldSucceed", result.getName());
        assertEquals("shouldSucceed(tech.diligo.astora.runner.RunnersTest$SingleTestExecutorTarget)", result.getDisplayName());
        assertEquals(TestState.SUCCESS, result.getState());
        assertEquals(null, result.getException());
    }

    @Test
    public void shouldRunSingleTestWithFailure() throws InitializationError {
        SingleTestResult result = Runners.runSingleTest(new BlockJUnit4ClassRunner(SingleTestExecutorTarget.class),
                "shouldFail");

        assertEquals("shouldFail", result.getName());
        assertEquals("shouldFail(tech.diligo.astora.runner.RunnersTest$SingleTestExecutorTarget)", result.getDisplayName());
        assertEquals(TestState.FAILURE, result.getState());
        assertThat(result.getException(), instanceOf(RuntimeException.class));
        assertEquals("custom exception", result.getException().getMessage());
    }

    @Test
    public void shouldRunSingleTestWithAssumptionFailure() throws InitializationError {
        SingleTestResult result = Runners.runSingleTest(new BlockJUnit4ClassRunner(SingleTestExecutorTarget.class),
                "shouldFailAssumption");

        assertEquals("shouldFailAssumption", result.getName());
        assertEquals("shouldFailAssumption(tech.diligo.astora.runner.RunnersTest$SingleTestExecutorTarget)", result.getDisplayName());
        assertEquals(TestState.ASSUMPTION_FAILURE, result.getState());
        assertThat(result.getException(), instanceOf(AssumptionViolatedException.class));
        assertEquals("got: <false>, expected: is <true>", result.getException().getMessage());
    }

    @Test
    public void shouldRunSingleTestWithIgnore() throws InitializationError {
        SingleTestResult result = Runners.runSingleTest(new BlockJUnit4ClassRunner(SingleTestExecutorTarget.class),
                "shouldIgnore");

        assertEquals("shouldIgnore", result.getName());
        assertEquals("shouldIgnore(tech.diligo.astora.runner.RunnersTest$SingleTestExecutorTarget)", result.getDisplayName());
        assertEquals(TestState.IGNORED, result.getState());
        assertEquals(null, result.getException());
    }

    @Test
    public void shouldThrowExceptionWhenNoMatchingTest() throws InitializationError {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Unable to run test");

        Runners.runSingleTest(new BlockJUnit4ClassRunner(SingleTestExecutorTarget.class), "foo");
    }

    public static final class SingleTestExecutorTarget {

        @Test
        public void shouldSucceed() {
        }

        @Test
        public void shouldFail() {
            throw new RuntimeException("custom exception");
        }

        @Test
        public void shouldFailAssumption() {
            assumeTrue(false);
        }

        @Test
        @Ignore
        public void shouldIgnore() {
        }
    }
}
