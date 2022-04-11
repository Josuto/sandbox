package org.sandbox.patterns.iterator;

public interface Aggregate<T> {

    boolean add(final T elem);
    
    // TODO Implement addAll, but first decide if it should be treated as an atomic operation (all elems are added, or else none is added) or not 
//    boolean addAll(final Collection<T> elems);
    
    Iterator<T> iterator();
    
}
