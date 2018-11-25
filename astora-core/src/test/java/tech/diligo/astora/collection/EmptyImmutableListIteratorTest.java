package tech.diligo.astora.collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class EmptyImmutableListIteratorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ImmutableListIterator<Object> undertTest;

    @Before
    public void setUp() {
        undertTest = ImmutableListIterator.empty();
    }

    @Test
    public void shouldReturnFalseWhenCheckingNext() {
        assertEquals(false, undertTest.hasNext());
    }

    @Test
    public void shouldReturnFalseWhenCheckingPrevious() {
        assertEquals(false, undertTest.hasPrevious());
    }

    @Test
    public void shouldReturnMinusOneWhenGettingNextIndex() {
        assertEquals(-1, undertTest.nextIndex());
    }

    @Test
    public void shouldReturnMinOneWhenGettingPreviousIndex() {
        assertEquals(-1, undertTest.previousIndex());
    }

    @Test
    public void shouldThrowExceptionWhenGettingNext() {
        expectedException.expect(NoSuchElementException.class);

        undertTest.next();
    }

    @Test
    public void shouldThrowExceptionWhenGettingPrevious() {
        expectedException.expect(NoSuchElementException.class);

        undertTest.previous();
    }

    @Test
    public void shouldReturnStringRepresentation() {
        assertEquals("EmptyImmutableListIterator{}", undertTest.toString());
    }
}
