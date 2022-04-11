package org.sandbox.collection.queue;

import java.util.Optional;

/**
 * Main type for different queue implementations.
 * 
 * @author josumartinez
 *
 * @param <E> the type of the elements included in the {@link Queue}.
 */
public interface Queue<E> {

	public void enqueue(E element);
	
	public Optional<E> dequeue();
	
	/**
     * Retrieves the amount of elements included in the {@link Queue}.
     * 
     * @return the amount of elements included in the {@link Queue}.
     */
	public int size();
	
	/**
     * Determines whether the {@link Queue} specifies at least one element or not.
     * 
     * @return {@code true} if the {@link Queue} is empty, {@code false} otherwise.
     */
	public default boolean isEmpty() {
	    return size() == 0;
	}
	
}
