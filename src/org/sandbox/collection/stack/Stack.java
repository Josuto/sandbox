package org.sandbox.collection.stack;

import java.util.Optional;

/**
 * Main type for different stack implementations.
 * 
 * @author josumartinez
 *
 * @param <E> the type of the elements included in the {@link Stack}.
 */
public interface Stack<E> {

	public void push(E element);
	
	public Optional<E> pop();
	
	/**
     * Retrieves the amount of elements included in the {@link Stack}.
     * 
     * @return the amount of elements included in the {@link Stack}.
     */
	public int size();
	
	/**
     * Determines whether the {@link Stack} specifies at least one element or not.
     * 
     * @return {@code true} if the {@link Stack} is empty, {@code false} otherwise.
     */
    public default boolean isEmpty() {
        return size() == 0;
    }
	
}
