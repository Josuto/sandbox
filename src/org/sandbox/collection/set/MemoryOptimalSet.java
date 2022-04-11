package org.sandbox.collection.set;

/**
 * Set implementation that adapts its heap consumption to its current state.
 * 
 * @author josumartinez
 *
 * @param <T> the type of the elements of the set.
 */
public class MemoryOptimalSet<T> implements Set<T> {
    
    private static final int CAPACITY = 2;
    @SuppressWarnings("unchecked") // Safe since T refers to any Object
    private T[] content = (T[])new Object[CAPACITY];
    private int size = 0;
    
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    // Package private method to perform validation, safe since it's pure
    int arrayLength() {
        return content.length;
    }
    
    @Override
    public void add(final T element) {
        if (!(contains(element))) {
            if (size >= content.length) {
                adaptArrayToSize(size);
            }
            content[size++] = element;
        }
    }
    
    @Override
    public boolean contains(final T element) {
        return indexOf(element) >= 0;
    }
    
    private int indexOf(final T element) {
        for (int i = 0; i < size; i++) {
            if (content[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    private void adaptArrayToSize(final int newSize) {
        int newArrayCapacity = ((newSize / CAPACITY) * CAPACITY) + CAPACITY;  
        @SuppressWarnings("unchecked") // Safe since T refers to any Object
        T[] newArray = (T[])new Object[newArrayCapacity];
        int newArraySize = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] != null)
                newArray[newArraySize++] = content[i];
        }
        content = newArray;
        size = newArraySize;
    }
    
    @Override
    public void remove(final T element) {
        int index = indexOf(element);
        if (index >= 0) {
            content[index] = content[--size];
            content[size] = null;
            if (size % CAPACITY == 0) {
                adaptArrayToSize(size - 1);
            }
        }
    }
    
}
