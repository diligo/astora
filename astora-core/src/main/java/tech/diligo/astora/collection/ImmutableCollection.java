package tech.diligo.astora.collection;

import java.util.Collection;

import static tech.diligo.astora.common.Requirements.requireNonNull;

public interface ImmutableCollection<E> extends Collection<E> {

    public static final ImmutableCollection<?> EMPTY_COLLECTION = new EmptyImmutableCollection<>();

    public static <E> ImmutableCollection<E> emptyCollection() {
        return (ImmutableCollection<E>) EMPTY_COLLECTION;
    }

    public static <E> ImmutableCollection<E> wrap(Collection<E> collection) {
        return new ImmutableCollectionDelegate<>(collection);
    }

    public static final class EmptyImmutableCollection<E> implements ImmutableCollection<E> {

        private static final Object[] EMPTY_ARRAY = new Object[0];

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableIterator<E> iterator() {
            return ImmutableIterator.empty();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEmpty() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean contains(Object o) {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object[] toArray() {
            return EMPTY_ARRAY;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> T[] toArray(T[] a) {
            return a;
        }

        @Override
        public boolean add(E e) {
            throw new UnsupportedOperationException("immutable");
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
        public boolean containsAll(Collection<?> c) {
            return false;
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
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc
         */
        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc
         */
        @Override
        public void clear() {
            throw new UnsupportedOperationException("immutable");
        }
    }

    public static final class ImmutableCollectionDelegate<E> implements ImmutableCollection<E> {

        final Collection<E> target;

        public ImmutableCollectionDelegate(Collection<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableCollectionDelegate ? ((ImmutableCollectionDelegate<E>) target).target : target;
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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null) {
                return false;
            }

            if (getClass() == o.getClass()) {
                return target.equals(((ImmutableCollectionDelegate<?>) o).target);
            }

            return target.equals(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableCollection{" + "target=" + target + '}';
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableIterator<E> iterator() {
            return new ImmutableIterator.ImmutableIteratorDelegate<>(this.target.iterator());
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
            return this.target.toArray();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> T[] toArray(T[] a) {
            return this.target.toArray(a);
        }
    }

    ImmutableIterator<E> iterator();
}
