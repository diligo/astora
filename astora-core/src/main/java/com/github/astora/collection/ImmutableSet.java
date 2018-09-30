package com.github.astora.collection;

import com.github.astora.collection.ImmutableIterator.ImmutableIteratorDelegate;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import static com.github.astora.common.Requirements.requireNonNull;

public interface ImmutableSet<E> extends Set<E>, ImmutableCollection<E> {

    // TODO empty set

    public static <E> ImmutableSet<E> wrap(Set<E> set) {
        return new ImmutableSetDelegate<>(set);
    }

    public static final class ImmutableSetDelegate<E> implements ImmutableSet<E> {

        final Set<E> target;

        public ImmutableSetDelegate(Set<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableSetDelegate ? ((ImmutableSetDelegate<E>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableIterator<E> iterator() {
            return new ImmutableIteratorDelegate<>(target.iterator());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return this.target.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEmpty() {
            return this.target.isEmpty();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean contains(Object o) {
            return this.target.contains(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(E e) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean containsAll(Collection<?> c) {
            return this.target.containsAll(c);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object[] toArray() {
            return target.toArray();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> T[] toArray(T[] a) {
            return target.toArray(a);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null) {
                return false;
            }

            if (getClass() == o.getClass()) {
                return target.equals(((ImmutableSetDelegate<?>) o).target);
            }

            return target.equals(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return target.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableSet{" + "target=" + target + '}';
        }
    }

    ImmutableIterator<E> iterator();
}
