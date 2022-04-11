package org.sandbox.collection.queue;

import java.util.Optional;

/**
 * Implementation of a circular {@link Queue} using a Java array.
 * 
 * @implNote Two important properties of {@link ArrayQueue} are that (1) its
 *           length is fixed at construction time and cannot be dynamically
 *           changed, and (2) it is not thread-safe.
 * 
 * @author josumartinez
 *
 * @param <E> the type of the elements included in the {@link ArrayQueue}.
 */
public final class ArrayQueue<E> implements Queue<E> {

    private static final int INITIAL_CAPACITY = 10;
    
	private final E[] array;
	
	private int size = 0, front = -1, back = 0;
	

	public ArrayQueue() {
	    this(INITIAL_CAPACITY);
    }
	
	/*
	 * It is safe to suppress the type safety warning as 'array' is a private
	 * instance field and the argument of the only mutator of the class, 'enqueue',
	 * is of type E.
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(final int length) {
		// Precondition
		if (length < 0) 
			throw new IllegalArgumentException("Negative length arrays are illegal!");
		// Cast required as generic arrays are illegal in Java
		array = (E[])new Object[length];
	}
	
	@Override
	public void enqueue(final E element) {
	    if (isFull())
	        throw new IllegalStateException("The queue is full!");
	    int front = ++this.front % array.length;
	    array[front] = element;
	    size++;
	}
	
	private boolean isFull() {
	    return size == array.length;
	}

	@Override
	public Optional<E> dequeue() {
		if (isEmpty())
		    return Optional.empty();
		int back = this.back++ % array.length;
		Optional<E> element = Optional.of(array[back]);
		array[back] = null;
		size--;
		return element;
	}
	
	@Override
	public int size() {
	    return size;
	}

}
