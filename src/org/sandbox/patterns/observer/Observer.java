package org.sandbox.patterns.observer;

public interface Observer<T> {
    
    /**
     * Observable state push operation.
     */
    public void update(final T newState);
    
    /**
     * Observer state pull operation.
     */
    public void update();
    
    public void unsubscribe();

}
