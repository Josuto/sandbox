package org.sandbox.collection.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.sandbox.collection.cache.DoubleLinkedList.Node;

/**
 * Models a Least Recently Used (LRU) eviction cache. This means that whenever the maximum
 * capacity of the cache is hit, then the least recently used item is removed from the cache.
 * The invocation of both <code>get</code> and <code>put</code> methods result in the input
 * item to be considered the most recently used item.
 */
public final class LruCache<K, V> implements Cache<K, V> {

    private final int capacity; // Maximum cache item capacity
    private final Map<K, Node<K, V>> cache; // Enables O(1) item access
    private final DoubleLinkedList<K, V> list; // Enables O(1) item insertion and eviction

    public LruCache(final int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException(
                "The cache must be able to contain at least one item"
            );
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoubleLinkedList<>();
    }

    @Override
    public Optional<V> get(final K key) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            list.remove(node);
            list.addToHead(node);
            return Optional.of(node.getValue());
        }
        return Optional.empty();
    }

    @Override
    public void put(final K key, final V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.setValue(value);
            list.remove(node);
            list.addToHead(node);
        } else {
            node = new Node<>(key, value);
            list.addToHead(node);
            cache.put(key, node);
            if (cache.size() > capacity) {
                K tailKey = list.removeTail();
                cache.remove(tailKey);
            }
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
