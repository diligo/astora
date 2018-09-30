package com.github.astora.collection;

import com.github.astora.collection.ImmutableIterator.ImmutableIteratorDelegate;
import com.github.astora.collection.ImmutableListIterator.ImmutableListIteratorDelegate;

import java.util.*;

import static com.github.astora.common.Requirements.requireNonNull;

public interface ImmutableList<E> extends List<E>, ImmutableCollection<E> {

    // TODO write internal empty list
    public static final ImmutableList<?> EMPTY_LIST = new ImmutableListDelegate<>();

    public static <E> ImmutableList<E> copyOf(Iterator<E> iterator) {
        if (!iterator.hasNext()) {
            return emptyList();
        }

        List<E> list = new ArrayList<>();

        do {
            E element = iterator.next();
            list.add(element);
        } while (iterator.hasNext());

        return wrap(list);
    }

    @SuppressWarnings("unchecked")
    public static <E> ImmutableList<E> emptyList() {
        return (ImmutableList<E>) EMPTY_LIST;
    }

    public static <E> ImmutableList<E> wrap(List<E> list) {
        return new ImmutableListDelegate<>(list);
    }

    public static final class ImmutableListDelegate<E> implements ImmutableList<E> {

        final List<E> target;

        public ImmutableListDelegate() {
            this(Collections.emptyList());
        }

        public ImmutableListDelegate(List<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableListDelegate ? ((ImmutableListDelegate<E>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableIterator<E> iterator() {
            return new ImmutableIteratorDelegate<>(this.target.iterator());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableListIterator<E> listIterator() {
            return new ImmutableListIteratorDelegate<>(this.target.listIterator());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableListIterator<E> listIterator(int index) {
            return new ImmutableListIteratorDelegate<>(this.target.listIterator(index));
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
        }        /**
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
        public void add(int index, E element) {
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
        public boolean addAll(int index, Collection<? extends E> c) {
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
        public E get(int index) {
            return this.target.get(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int indexOf(Object o) {
            return this.target.indexOf(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int lastIndexOf(Object o) {
            return this.target.lastIndexOf(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E remove(int index) {
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
        public E set(int index, E element) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return new ImmutableListDelegate<>(this.target.subList(fromIndex, toIndex));
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

    ImmutableListIterator<E> listIterator();

    ImmutableListIterator<E> listIterator(int index);
}
