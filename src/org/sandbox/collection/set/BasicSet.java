package org.sandbox.collection.set;

public class BasicSet<T> implements Set<T> {

    @SuppressWarnings("unchecked") // Safe since T refers to any Object
    private T[] content = (T[])new Object[10]; 
    private int size = 0;
    
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(final T element) {
        content[size++] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(final T element) {
        return indexOf(element) >= 0;
    }

    @Override
    public void remove(final T element) {
        int index = indexOf(element);
        if (index >= 0) {
            content[index] = content[--size];
            content[size] = null;
        }
    }
    
    // Since we do not want to expose Set implementation details, this method is private 
    private int indexOf(final T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(content[i])) {
                return i;
            }
        }
        return -1;
    }

}
