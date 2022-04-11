package org.sandbox.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();
    private boolean changed = false;
    
    
    public void addObserver(final Observer<T> observer) {
        this.observers.add(observer);
    }
    
    public void removeObserver(final Observer<T> observer) {
        this.observers.remove(observer);
    }
    
    public abstract T getState();
    
    protected void setChanged() {
        changed = true;
    }
    
    public void notifyObservers(final T newState) {
        if (this.changed) { // to prevent observers from notifying their peers at will
            for (Observer<T> observer : this.observers) {
                observer.update(newState); // push the new state to the observers
            }
            this.changed = false;
        }
    }
    
}
