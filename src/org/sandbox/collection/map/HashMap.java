package org.sandbox.collection.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * This class is a custom and simple implementation of Java {@link Map}.
 * <p>
 * This class follows the canonical implementation of hash map as an array of
 * buckets, where each bucket specifies a {@link LinkedList} of entries which
 * key resolve to the same hashcode value. This may suppose a limitation in the
 * case of multiple key hashcode collisions (i.e., if the hashcode value for two
 * or more different entry keys is the same). In the worst case scenario, all
 * entries could end up in the same bucket, meaning that its time complexity is
 * {@code O(n)}, where {@code n} represents the total amount of entries. Still,
 * this implementation offers a good balance between performance and data
 * structure complexity for hash maps that will not include several thousands of
 * entries. Such that be the case, a better solution consists of converting the
 * bucket list to a balanced tree structure (time complexity drops to
 * {@code O(log n)}), as done in {@link java.util.HashMap} since Java 8.
 * <p>
 * One could ask herself why not using {@link ArrayList} to represent the list
 * of buckets of the hash map, instead of {@link LinkedList}. Since we do not
 * need to use {@link LinkedList#get(int)}, which time complexity is
 * {@code O(n)} (vs better {@link ArrayList}'s counterpart: {@code O(1)}), the
 * main reason is that, in the case of {@link ArrayList}, whenever the capacity
 * of a bucket is complete (i.e., the {@link ArrayList} inner array reached its
 * full capacity), there is an extra operation for adding more capacity to such
 * inner array needed. This is never the case in {@link LinkedList}. Another
 * good reason is that element removal operation in {@link LinkedList} is
 * cheaper in complexity ({@code O(1)}) than in {@link ArrayList}
 * ({@code O(n)}).
 * 
 * @implSpec This class is mutable and is not thread safe.
 * 
 * @author josumartinez
 *
 * @param <K> the type of the {@link Map} keys.
 * @param <V> the type of the {@link Map} values.
 */
public class HashMap<K, V> implements Map<K, V> {

    private final static int INITIAL_CAPACITY = 10;
    
    private final List<Entry<K, V>>[] array;
    
    private int size = 0;
    
    
    /**
     * Assuming that all the methods of this class will initialize {@link #array} as
     * a {@link LinkedList} of {@link Entry} elements, it is safe to suppress
     * compiler warnings.
     */
    @SuppressWarnings("unchecked")
    public HashMap() {
        array = (LinkedList<Entry<K, V>>[]) new LinkedList[INITIAL_CAPACITY];
    }
    
    /**
     * Assuming that all the methods of this class will initialize {@link #array} as
     * a {@link LinkedList} of {@link Entry} elements, it is safe to suppress
     * compiler warnings.
     */
    @SuppressWarnings("unchecked")
    public HashMap(int initialCapacity) {
        array = (LinkedList<Entry<K, V>>[]) new LinkedList[initialCapacity];
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object key) {
        return this.get(key) != null;
    }

    /**
     * {@inheritDoc}
     * 
     * @implNote since neither buckets nor bucket entries are ordered, the time
     *           complexity of this method is {@code O(n^2)}.
     */
    @Override
    public boolean containsValue(Object value) {
        for (List<Entry<K, V>> bucket : array) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get(Object key) {
        int index = this.calculateKeyIndex(key);
        // Retrieve the bucket associated to the given key, if any 
        List<Entry<K, V>> bucket = array[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
    
    /**
     * Calculates the position index corresponding to the given key in the
     * {@link HashMap} array.
     * 
     * @param key the given key.
     * @return the position index of the key in the {@link HashMap} array, if it
     *         exists; {@code null} otherwise.
     * @throws IllegalArgumentException if the given key is {@code null}.
     */
    private int calculateKeyIndex(final Object key) {
        // Precondition
        if (key == null) {
            throw new IllegalArgumentException("The given key cannot be null!");
        }
        return Math.abs(key.hashCode()) % array.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        V result = null;
        // Calculate the position index corresponding to the given key in the buckets array
        int index = this.calculateKeyIndex((K)key);
        // Retrieve the bucket associated to the given key, if any 
        List<Entry<K, V>> bucket = array[index];
        if (bucket != null) {
            // Look for an entry with the given key and update it  
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    result = entry.getValue();
                    entry.setValue(value);
                    break;
                }
            }
            // Such entry does not yet exist
            if (result == null) {
                bucket.add(new SimpleEntry<>(key, value));
                size++;
            }
        }
        else {
            bucket = new LinkedList<>();
            bucket.add(new SimpleEntry<>(key, value));
            array[index] = bucket;
            size++;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(Object key) {
        V result = null;
        int index = this.calculateKeyIndex(key);
        List<Entry<K, V>> bucket = array[index];
        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).getKey().equals(key)) {
                    result = (V)bucket.remove(i).getValue();
                    size--;
                    break;
                }
            }
            // Buckets array space optimization
            if (bucket.isEmpty()) {
                array[index] = null;
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        map.forEach((key, value) -> this.put(key, value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<K> keySet() {
        return this.createSet(entry -> entry.getKey());
    }
    
    /**
     * Traverses all the entries included in the buckets of this hash map and
     * creates a {@link Set} out of the values specified by the given
     * {@link Function}.
     * <p>
     * This function is product of refactoring {@link #keySet()}, {@link #values()},
     * and {@link #entrySet()} common logic.
     * 
     * @param <E>      The type of the elements to be included in the resulting
     *                 {@link Set}.
     * @param function Specifies the values to be extracted in the resulting
     *                 {@link Set}.
     * @return a {@link Set} with the values specified by the given
     *         {@link Function}.
     */
    private <E> Set<E> createSet(final Function<Entry<K, V>, E> function) {
        Set<E> elems = new HashSet<>();
        for (List<Entry<K, V>> bucket : array) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    elems.add(function.apply(entry));
                }
            }
        }
        return elems;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<V> values() {
        return this.createSet(entry -> entry.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.createSet(entry -> entry);
    }
    
}
