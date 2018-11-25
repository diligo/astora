package tech.diligo.astora.collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class EmptyImmutableIteratorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ImmutableIterator underTest;

    @Before
    public void setUp() {
        underTest = ImmutableIterator.empty();
    }

    @Test
    public void shouldReturnFalseWhenCheckingHasNext() {
        assertEquals(false, underTest.hasNext());
    }

    @Test
    public void shouldThrowExceptionWhenGettingNextElement() {
        expectedException.expect(NoSuchElementException.class);
        underTest.next();
    }

    @Test
    public void shouldReturnStringRepresentation() {
        assertEquals("EmptyImmutableIterator{}", underTest.toString());
    }
}
