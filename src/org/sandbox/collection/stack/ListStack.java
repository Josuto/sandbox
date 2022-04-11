package org.sandbox.collection.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link Stack} using a Java {@link List}. Two important
 * properties of {@link ListStack} are that (1) its length is not fixed at
 * construction time, and (2) it is not thread-safe.
 * 
 * @author josumartinez
 *
 * @param <E> the type of the elements included in the {@link ListStack}.
 */
public final class ListStack<E> implements Stack<E> {

    private final List<E> list;
    
    
    public ListStack() {
        list = new ArrayList<>();
    }
    
    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public Optional<E> pop() {
        if (isEmpty())
            return Optional.empty();
        Optional<E> element = Optional.of(list.get(getLastOccupiedIndex()));
        list.remove(getLastOccupiedIndex());
        return element;
    }
    
    private int getLastOccupiedIndex() {
        return size() - 1;
    }

    @Override
    public int size() {
        return list.size();
    }

}
