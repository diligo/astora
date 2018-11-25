package tech.diligo.astora.collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.diligo.astora.rule.NoMoreInteractionsRule;

import java.util.ListIterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableListIteratorTest {

    @Rule
    public NoMoreInteractionsRule noMoreInteractions = NoMoreInteractionsRule.create();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ImmutableListIterator underTest;
    @Mock
    private ListIterator<?> target;

    @Before
    public void setUp() {
        underTest = ImmutableListIterator.wrap(target);
    }

    @Test
    public void shouldDelegateHashNextToTarget() {
        underTest.hasNext();

        verify(target).hasNext();
    }

    @Test
    public void shouldDelegateNextToTarget() {
        underTest.next();

        verify(target).next();
    }

    @Test
    public void shouldDelegateNextIndexToTarget() {
        underTest.nextIndex();

        verify(target).nextIndex();
    }

    @Test
    public void shouldDelegateHasPreviousToTarget() {
        underTest.hasPrevious();

        verify(target).hasPrevious();
    }

    @Test
    public void shouldDelegatePreviousToTarget() {
        underTest.previous();

        verify(target).previous();
    }

    @Test
    public void shoouldDelegatePreviousIndexToTarget() {
        underTest.previousIndex();

        verify(target).previousIndex();
    }

    @Test
    public void shouldThrowExceptionWhenRemoving() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("immutable");

        underTest.remove();
    }

    @Test
    public void shouldThrowExceptionWhenAdding() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("immutable");

        underTest.add(new Object());
    }

    @Test
    public void shouldThrowExceptionWhenSetting() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("immutable");

        underTest.set(new Object());
    }

    @Test
    public void shouldReturnStringRepresentation() {
        assertEquals("ImmutableListIteratorDelegate{target=target}", underTest.toString());
    }
}
