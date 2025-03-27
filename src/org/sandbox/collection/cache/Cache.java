package org.sandbox.collection.cache;

import java.util.Optional;

public interface Cache<K, V> {
    public Optional<V> get(final K key);

    public void put(final K key, final V value);

    public int size();

    public boolean isEmpty();
}
