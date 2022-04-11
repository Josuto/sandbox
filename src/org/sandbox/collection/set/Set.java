package org.sandbox.collection.set;

public interface Set<T> {

    public boolean isEmpty();
    
    public int size();
    
    public boolean contains(final T element);

    public void add(final T element);
    
    public void remove(final T element);
    
}
