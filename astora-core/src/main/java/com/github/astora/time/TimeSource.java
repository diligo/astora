package com.github.astora.time;

public interface TimeSource {

    /**
     * Returns the current time in microseconds. Note that while the unit of time of
     * the return value is a microsecond, the granularity of the value depends on
     * the underlying operating system and may be smaller or larger.
     *
     * @return current time in microseconds
     */
    long currentTimeMicros();

    /**
     * Returns the current time in milliseconds. Note that while the unit of time of
     * the return value is a millisecond, the granularity of the value depends on
     * the underlying operating system and may be smaller or larger.
     *
     * @return current time in milliseconds
     */
    long currentTimeMillis();

    /**
     * Returns the current time in nanoseconds. Note that while the unit of time of
     * the return value is a nanosecond, the granularity of the value depends on the
     * underlying operating system and may be smaller or larger.
     *
     * @return current time in nanoseconds
     */
    long currentTimeNanos();

    /**
     * Returns the time value in nanoseconds relative to some arbitrary point of
     * time. Note that while the unit of time of the return value is a nanosecond,
     * the granularity of the value depends on the underlying operating system and
     * may be smaller or larger.
     *
     * @return time value relative to some arbitrary point of time
     */
    long nanoTime();
}
