package org.sandbox.collection.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.sandbox.collection.cache.DoubleLinkedList.Node;

public final class LruCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> cache; // Enables item access
    private final DoubleLinkedList<K, V> list;

    public LruCache(final int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoubleLinkedList<>();
    }

    public Optional<V> get(final K key) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            list.remove(node);
            list.addToHead(node);
            return Optional.of(node.getValue());
        }
        return Optional.empty();
    }

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

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
