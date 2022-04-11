package org.sandbox.collection.stack;

import java.util.Optional;

/**
 * Implementation of {@link Stack} using a Java array.
 * 
 * @implNote Two important properties of {@link ArrayStack} are that (1) its
 *           length is fixed at construction time and cannot be dynamically
 *           changed (unlike some other array-based {@link Stack}
 *           implementations that e.g., double its length when the maximum is
 *           reached), and (2) it is not thread-safe.
 * 
 * @author josumartinez
 *
 * @param <E> the type of the elements included in the {@link ArrayStack}.
 */
public final class ArrayStack<E> implements Stack<E> {

	private final E[] array;
	
	private int size = 0;
	
	
	/*
     * It is safe to suppress the type safety warning as 'array' is a private
     * instance field and the argument of the only mutator of the class, 'push', is
     * of type E.
     */
	@SuppressWarnings("unchecked")
	public ArrayStack(final int length) {
		// Precondition
		if (length < 0) 
			throw new IllegalArgumentException("Negative length arrays are illegal!");
		// Cast required as generic arrays are illegal in Java
		array = (E[])new Object[length];
	}
	
	
	@Override
	public void push(final E element) {
		try {
			array[size++] = element;
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			throw new IllegalStateException("The stack is full!", exception);
		}
	}
	
	@Override
	public Optional<E> pop() {
		try {
			if (isEmpty())
				return Optional.empty();
			Optional<E> element = Optional.ofNullable(array[--size]);
			array[size] = null;
			return element;
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			return Optional.empty();
		}
	}
	
	public int size() {
		return size;
	}

}
