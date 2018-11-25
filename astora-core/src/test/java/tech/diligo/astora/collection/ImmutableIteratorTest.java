package tech.diligo.astora.collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.diligo.astora.rule.NoMoreInteractionsRule;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableIteratorTest {

    @Rule
    public NoMoreInteractionsRule noMoreInteractions = NoMoreInteractionsRule.create();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ImmutableIterator<?> underTest;
    @Mock
    private Iterator<?> target;

    @Before
    public void setUp() {
        underTest = ImmutableIterator.wrap(target);
    }

    @Test
    public void shouldDelegateHasNextToTarget() {
        underTest.hasNext();
        verify(target).hasNext();
    }

    @Test
    public void shouldDelegateNextToTarget() {
        underTest.next();
        verify(target).next();
    }

    @Test
    public void shouldThrowExceptionWhenRemoving() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("immutable");

        underTest.remove();
    }

    @Test
    public void shouldReturnStringRepresentation() {
        assertEquals("ImmutableIteratorDelegate{target=target}", underTest.toString());
    }
}
