package org.sandbox.patterns.iterator;

import java.util.Collection;

public final class ArrayAggregate<T> implements Aggregate<T> {

    private static final int INITIAL_CAPACITY = 10;
    
    private final T[] array;
    
    
    public ArrayAggregate() {
        this(INITIAL_CAPACITY);
    }
    
    /*
     * It is safe to suppress the type checking warning since the formal parameter T
     * represents any Object.
     */
    @SuppressWarnings("unchecked")
    public ArrayAggregate(final int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
    }
    
    /*
     * It is safe to suppress the type checking warning since the elements contained
     * in the given collection are of type T.
     */
    @SuppressWarnings("unchecked")
    public ArrayAggregate(final Collection<T> elems) {
        // the Collection.toArray() contract specifies that this method must return a
        // new array instance so that the client may perform any operation with it.
        this.array = (T[]) elems.toArray(); 
    }
    
    public boolean add(final T elem) {
        for (int index = 0; index < this.array.length; index++) {
            if (this.array[index] == null) {
                this.array[index] = elem;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }
    
    
    /**
     * {@link Iterator} representation of the aggregate array. Thus, this class is
     * considered an Adapter, according to Joshua Bloch (Effective Java).
     * 
     * @author josumartinez
     *
     */
    private class IteratorImpl implements Iterator<T> {

        private int index = 0;
        
        
        @Override
        public boolean hasNext() {
            if (index >= array.length || array[index] == null)
                return false;
            else return true;
        }

        @Override
        public T next() {
            return array[index++];
        }
        
    }

}
