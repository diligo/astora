package tech.diligo.astora.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.junit.MockitoJUnitRunner;
import tech.diligo.astora.runner.Runners;
import tech.diligo.astora.runner.SingleTestResult;
import tech.diligo.astora.runner.TestState;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class NoMoreInteractionsRuleTest {

    @Test
    public void shouldSucceedWhenAllInvocationsVerified() throws Exception {
        SingleTestResult result = Runners.runSingleTest(new MockitoJUnitRunner(NoMoreInteractionsTarget.class),
                "shouldSucceedWhenAllInvocationsVerified");

        assertEquals("shouldSucceedWhenAllInvocationsVerified", result.getName());
        assertEquals(
                "shouldSucceedWhenAllInvocationsVerified(tech.diligo.astora.rule.NoMoreInteractionsRuleTest$NoMoreInteractionsTarget)",
                result.getDisplayName());
        Assert.assertEquals(TestState.SUCCESS, result.getState());
        assertEquals(null, result.getException());
    }

    @Test
    public void shouldThrowExceptionWhenAnnotatedMockInvocationNotVerified() throws InvocationTargetException {
        SingleTestResult result = Runners.runSingleTest(new MockitoJUnitRunner(NoMoreInteractionsTarget.class),
                "shouldThrowExceptionWhenAnnotatedMockInvocationNotVerified");

        assertEquals("shouldThrowExceptionWhenAnnotatedMockInvocationNotVerified", result.getName());
        assertEquals(
                "shouldThrowExceptionWhenAnnotatedMockInvocationNotVerified(tech.diligo.astora.rule.NoMoreInteractionsRuleTest$NoMoreInteractionsTarget)",
                result.getDisplayName());
        assertEquals(TestState.FAILURE, result.getState());
        assertThat(result.getException(), instanceOf(NoInteractionsWanted.class));
    }

    @Test
    public void shouldThrowExceptionWhenCustomMockInvocationNotVerified() throws InvocationTargetException {
        SingleTestResult result = Runners.runSingleTest(new MockitoJUnitRunner(NoMoreInteractionsTarget.class),
                "shouldThrowExceptionWhenCustomMockInvocationNotVerified");

        assertEquals("shouldThrowExceptionWhenCustomMockInvocationNotVerified", result.getName());
        assertEquals(
                "shouldThrowExceptionWhenCustomMockInvocationNotVerified(tech.diligo.astora.rule.NoMoreInteractionsRuleTest$NoMoreInteractionsTarget)",
                result.getDisplayName());
        assertEquals(TestState.FAILURE, result.getState());
        assertThat(result.getException(), instanceOf(NoInteractionsWanted.class));
    }

    public static class NoMoreInteractionsTarget {

        @Rule
        public NoMoreInteractionsRule underTest = NoMoreInteractionsRule.create();

        @Mock
        private List<String> list;
        @Mock
        private Map<String, String> map;
        private Closeable closeable;

        @Before
        public void setUp() {
            closeable = mock(Closeable.class);
        }

        @Test
        public void shouldSucceedWhenAllInvocationsVerified() throws IOException {
            list.size();
            list.get(13);
            list.size();

            closeable.close();
            closeable.close();
            closeable.close();

            map.put("a", "b");
            map.put("c", "d");
            map.size();

            verify(list, times(2)).size();
            verify(list).get(13);

            verify(closeable, times(3)).close();

            verify(map).put("a", "b");
            verify(map).put("c", "d");
            verify(map).size();
        }

        @Test
        public void shouldThrowExceptionWhenAnnotatedMockInvocationNotVerified() {
            map.put("a", "b");
            map.put("c", "d");
            map.size();

            verify(map).put("a", "b");
            // map.put("c", "d")
            verify(map).size();
        }

        @Test
        public void shouldThrowExceptionWhenCustomMockInvocationNotVerified() throws IOException {
            list.size();
            list.get(13);
            list.size();

            closeable.close();

            verify(list, times(2)).size();
            verify(list).get(13);

            // verify(closeable).close();
        }
    }
}
