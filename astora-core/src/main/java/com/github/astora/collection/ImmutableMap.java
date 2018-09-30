package com.github.astora.collection;

import com.github.astora.collection.ImmutableCollection.ImmutableCollectionDelegate;
import com.github.astora.collection.ImmutableSet.ImmutableSetDelegate;

import java.util.Map;

import static com.github.astora.common.Requirements.requireNonNull;

public interface ImmutableMap<K, V> extends Map<K, V> {

    public static <K, V> ImmutableMap<K, V> wrap(Map<K, V> map) {
        return new ImmutableMapDelegate<>(map);
    }

    public static final class ImmutableMapDelegate<K, V> implements ImmutableMap<K, V> {

        final Map<K, V> target;

        public ImmutableMapDelegate(Map<K, V> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableMapDelegate ? ((ImmutableMapDelegate<K, V>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableSet<Entry<K, V>> entrySet() {
            return new ImmutableSetDelegate<>(this.target.entrySet());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableSet<K> keySet() {
            return new ImmutableSetDelegate<>(this.target.keySet());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ImmutableCollection<V> values() {
            return new ImmutableCollectionDelegate<>(this.target.values());
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
        public boolean containsKey(Object key) {
            return this.target.containsKey(key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean containsValue(Object value) {
            return this.target.containsValue(value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V get(Object key) {
            return this.target.get(key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V put(Object key, Object value) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException("immutable");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
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

            if (getClass().isAssignableFrom(o.getClass())) {
                return target.equals(((ImmutableMapDelegate<?, ?>) o).target);
            }

            return target.equals(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableMap{" + "target=" + target + '}';
        }
    }

    ImmutableSet<Entry<K, V>> entrySet();

    ImmutableSet<K> keySet();

    ImmutableCollection<V> values();
}