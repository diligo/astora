package tech.diligo.astora.time;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SystemTimeSourceTest {

    private SystemTimeSource underTest;

    @Before
    public void setUp() {
        underTest = new SystemTimeSource();
    }

    @Test
    public void shouldReturnCurrentTimeInMilliseconds() {
        assertTrue(underTest.currentTimeMillis() > 0L);
    }

    @Test
    public void shouldReturnCurrentTimeInMicroseconds() {
        assertTrue(underTest.currentTimeMicros() > 0L);
    }

    @Test
    public void shouldReturnCurrentTimeInNanoseconds() {
        assertTrue(underTest.currentTimeNanos() > 0L);
    }

    @Test
    public void shouldReturnNanoTime() {
        assertTrue(underTest.nanoTime() > 0L);
    }
}
