package com.github.astora.time;

import java.util.concurrent.TimeUnit;

public final class SystemTimeSource implements TimeSource {

    /**
     * {@inheritDoc}
     */
    @Override
    public long currentTimeMicros() {
        return TimeUnit.MILLISECONDS.toMicros(currentTimeMillis());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long currentTimeNanos() {
        return TimeUnit.MILLISECONDS.toNanos(currentTimeMillis());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nanoTime() {
        return System.nanoTime();
    }
}
