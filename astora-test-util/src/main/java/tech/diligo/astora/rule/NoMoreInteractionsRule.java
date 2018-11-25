package tech.diligo.astora.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.UnnecessaryStubbingException;
import org.mockito.internal.junit.UnnecessaryStubbingsReporter;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.MockingProgressImpl;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.listeners.MockCreationListener;
import org.mockito.listeners.MockitoListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Verify that all mocks created for the test run have no more interactions.
 */
public final class NoMoreInteractionsRule implements TestRule {

    private static final String LISTENERS_FIELD_NAME = "listeners";
    private static final String MOCKS_FIELD_NAME = "mocks";

    private NoMoreInteractionsRule() {
    }

    public static NoMoreInteractionsRule create() {
        return new NoMoreInteractionsRule();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Statement apply(Statement base, Description description) {
        List<Object> mocks = new ArrayList<>();
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();

        /**
         * Mocks created by {@link org.mockito.junit.MockitoJUnitRunner} with {@link org.mockito.Mock} annotation have
         * already been crated. Try to get them via built in Mockito interceptor.
         */
        if (mockingProgress instanceof MockingProgressImpl) {
            try {
                Field listenersFields = MockingProgressImpl.class.getDeclaredField(LISTENERS_FIELD_NAME);
                listenersFields.setAccessible(true);
                Set<MockitoListener> listeners = (Set<MockitoListener>) listenersFields.get(mockingProgress);

                for (MockitoListener listener : listeners) {
                    if (!(listener instanceof UnnecessaryStubbingsReporter)) {
                        continue;
                    }

                    Field mocksField = UnnecessaryStubbingsReporter.class.getDeclaredField(MOCKS_FIELD_NAME);
                    mocksField.setAccessible(true);
                    List<Object> listenerMocks = (List<Object>) mocksField.get(listener);
                    mocks.addAll(listenerMocks);
                    break;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Unable to obtain existing mocks", e);
            }
        }

        MockCreationListener listener = ((MockCreationListener) (mock, settings) -> mocks.add(mock));
        Mockito.framework().addListener(listener);

        return new NoMoreInteractionsStatement(base, mocks, listener);
    }

    private static final class NoMoreInteractionsStatement extends Statement {

        private final Statement next;
        private final List<Object> mocks;
        private final MockCreationListener listener;

        private NoMoreInteractionsStatement(Statement next, List<Object> mocks, MockCreationListener listener) {
            this.next = next;
            this.mocks = mocks;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void evaluate() throws Throwable {
            try {
                next.evaluate();

                if (mocks.size() > 0) {
                    Mockito.verifyNoMoreInteractions(mocks.stream().toArray(Object[]::new));
                }
            } finally {
                Mockito.framework().removeListener(listener);
            }
        }
    }
}
