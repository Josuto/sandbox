package org.sandbox.collection.set;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Implementation of the mathematical bag concept, also known as
 * <i>multiset</i>. A {@link Bag} may include duplicated elements e.g., {@code {
 * a, b, a }}. Thus, each element included in a {@link Bag} specifies some
 * <i>multiplicity</i> i.e., the number of times that it appears in the
 * {@link Bag}.
 * 
 * @implNote This class is not thread-safe.
 * 
 * @author josumartinez
 *
 * @param <E> the type of elements included in the {@link Bag}.
 */
public class Bag<E> extends AbstractSet<E> {

    /*
     * The bag is implemented as a map which keys are the set elements and which
     * values are the multiplicity value of each element.
     */
    private final NavigableMap<E, Integer> map;
    
    
    public Bag() {
        map = new TreeMap<>();
    }
    
    public Bag(final Collection<E> collection) {
        map = new TreeMap<>();
        for (E element : collection) {
            _add(element);
        }
    }
    
    private boolean _add(E element) {
        return map.merge(element, 1, (oldValue, value) -> oldValue + 1) != null;
    }

    @Override
    public boolean add(E element) {
        return _add(element);
    }
    
    @Override
    public boolean remove(Object object) {
        try {
            // It is safe to suppress the warning as in the case that the object 
            // is not of type E the resulting ClassCastException will be handled
            @SuppressWarnings("unchecked")
            E element = (E) object;
            return map.computeIfPresent(element, (key, value) -> value == 1 ? null : value - 1) != null;
        }
        catch (ClassCastException exception) { // if the given object is not of type E
            return false;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<E> {
        private E currentKey = map.firstKey();
        private int currentElementIndex = 1;
        
        @Override
        public boolean hasNext() {
            if (map.isEmpty()) 
                return false;
            else {
                E lastKey = map.lastKey();
                return !(currentKey.equals(lastKey) && (currentElementIndex == map.get(lastKey)));
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                int currentElementFrequecy = map.get(currentKey);
                if (currentElementIndex <= currentElementFrequecy) {
                    currentElementIndex++;
                }
                else {
                    currentKey = map.higherKey(currentKey);
                    currentElementIndex = 1;
                }
                return currentKey;
            }
        }
        
    }
    
    @Override
    public int size() {
        int cardinality = 0;
        
        for (Entry<E, Integer> entry : map.entrySet()) {
            cardinality += entry.getValue();
        }
        return cardinality;
    }

}
