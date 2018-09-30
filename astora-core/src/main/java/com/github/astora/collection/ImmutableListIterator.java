package com.github.astora.collection;

import java.util.ListIterator;

import static com.github.astora.common.Requirements.requireNonNull;

public interface ImmutableListIterator<E> extends ListIterator<E> {

    public static <E> ImmutableListIterator<E> wrap(ListIterator<E> listIterator) {
        return new ImmutableListIteratorDelegate<>(listIterator);
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

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("immutable");
        }
    }
}
