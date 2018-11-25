package tech.diligo.astora.collection;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import static tech.diligo.astora.common.Requirements.requireNonNull;

public interface ImmutableListIterator<E> extends ListIterator<E> {

    public static ImmutableListIterator<?> EMPTY_LIST_ITERATOR = new EmptyImmutableListIterator<>();

    public static <E> ImmutableListIterator<E> wrap(ListIterator<E> listIterator) {
        return new ImmutableListIteratorDelegate<>(listIterator);
    }

    public static <E> ImmutableListIterator<E> empty() {
        return (ImmutableListIterator<E>) EMPTY_LIST_ITERATOR;
    }

    public static final class EmptyImmutableListIterator<E> implements ImmutableListIterator<E> {

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
            return "EmptyImmutableListIterator{}";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            throw new NoSuchElementException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasPrevious() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E previous() {
            throw new NoSuchElementException();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int nextIndex() {
            return -1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int previousIndex() {
            return -1;
        }
    }

    public static final class ImmutableListIteratorDelegate<E> implements ImmutableListIterator<E> {

        private final ListIterator<E> target;

        public ImmutableListIteratorDelegate(ListIterator<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableListIteratorDelegate ? ((ImmutableListIteratorDelegate<E>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableListIteratorDelegate{" + "target=" + target + '}';
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

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasPrevious() {
            return this.target.hasPrevious();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E previous() {
            return this.target.previous();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int nextIndex() {
            return this.target.nextIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int previousIndex() {
            return this.target.previousIndex();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public default void remove() {
        throw new UnsupportedOperationException("immutable");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public default void set(E e) {
        throw new UnsupportedOperationException("immutable");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public default void add(E e) {
        throw new UnsupportedOperationException("immutable");
    }
}
