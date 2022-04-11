package org.sandbox.concurrent.synchronizers.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentArray<T> {

    private final static int INITIAL_CAPACITY = 10;
    
    private final T[] array;
    
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    
    @SuppressWarnings("unchecked") // Safe since T represents any Object
    public ConcurrentArray() {
        this.array = (T[])new Object[INITIAL_CAPACITY];
    }
    
    @SuppressWarnings("unchecked") // Safe since T represents any Object
    public ConcurrentArray(final int initialCapacity) {
        this.array = (T[])new Object[initialCapacity];
    }
    
    public T get(final int index) {
        if (index >= array.length)
            throw new IllegalArgumentException("The given index must be smaller than the array length!");
        
        Lock rLock = rwLock.readLock();
        rLock.lock();
        try {
            return array[index];
        }
        finally {
            rLock.unlock();
        }
    }
    
    public void set(final int index, final T elem) {
        if (index >= array.length)
            throw new IllegalArgumentException("The given index must be smaller than the array length!");
        
        Lock wLock = rwLock.writeLock();
        wLock.lock();
        try {
            array[index] = elem;
        }
        finally {
            wLock.unlock();
        }
    }
    
    public int size() {
        return array.length;
    }
    
}
