package tech.diligo.astora.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static tech.diligo.astora.common.Requirements.requireNonNull;

public interface ImmutableIterator<E> extends Iterator<E> {

    public static final ImmutableIterator<?> EMPTY_ITERATOR = new EmptyImmutableIterator();

    public static <E> ImmutableIterator<E> wrap(Iterator<E> iterator) {
        return new ImmutableIteratorDelegate<>(iterator);
    }

    public static <E> ImmutableIterator<E> empty() {
        return (ImmutableIterator<E>) EMPTY_ITERATOR;
    }

    public static final class EmptyImmutableIterator<E> implements ImmutableIterator<E> {

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "EmptyImmutableIterator{}";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            throw new NoSuchElementException();
        }
    }

    public static final class ImmutableIteratorDelegate<E> implements ImmutableIterator<E> {

        final Iterator<E> target;

        public ImmutableIteratorDelegate(Iterator<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableIteratorDelegate ? ((ImmutableIteratorDelegate<E>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableIteratorDelegate{" + "target=" + target + '}';
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return this.target.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return this.target.next();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void remove() {
        throw new UnsupportedOperationException("immutable");
    }
}
