package tech.diligo.astora.runner;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import static org.junit.runner.Description.createTestDescription;
import static org.junit.runner.manipulation.Filter.matchMethodDescription;

public final class Runners {

    private Runners() {
    }

    public static <T extends Runner & Filterable> SingleTestResult runSingleTest(T runner, String name) {
        try {
            return runSingleTestInternal(runner, name);
        } catch (ClassNotFoundException | NoTestsRemainException e) {
            throw new RuntimeException("Unable to run test", e);
        }
    }

    private static <T extends Runner & Filterable> SingleTestResult runSingleTestInternal(
            T runner, String name) throws ClassNotFoundException, NoTestsRemainException {
        final TestState[] successful = {TestState.SUCCESS};
        final Throwable[] exception = {null};

        RunNotifier notifier = new RunNotifier();
        notifier.addListener(new RunListener() {
            @Override
            public void testFailure(Failure failure) throws Exception {
                successful[0] = TestState.FAILURE;
                exception[0] = failure.getException();
            }

            @Override
            public void testAssumptionFailure(Failure failure) {
                successful[0] = TestState.ASSUMPTION_FAILURE;
                exception[0] = failure.getException();
            }

            @Override
            public void testIgnored(Description description) throws Exception {
                successful[0] = TestState.IGNORED;
            }
        });

        Description description = createTestDescription(Class.forName(runner.getDescription().getClassName()), name);
        runner.filter(matchMethodDescription(description));
        runner.run(notifier);

        return new SingleTestResult(description.getMethodName(), description.getDisplayName(), successful[0],
                exception[0]);
    }
}
