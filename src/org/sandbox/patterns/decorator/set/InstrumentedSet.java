package org.sandbox.patterns.decorator.set;

import java.util.Collection;
import java.util.Set;

/**
 * This class decorates any {@link Set} with the responsibility of incrementing
 * by one a counter each time that a new element is successfully added to the
 * {@link Set}.
 * <p>
 * It is based on an exercise proposed by Josh Bloch in his book Effective Java,
 * 3rd Edition, page 90.
 * 
 * @author josumartinez
 *
 * @param <E> the type of elements to be included in the {@link Set}.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> implements Set<E> {
    
    private int addCount = 0;
    
    
    public InstrumentedSet(Set<E> set) {
        super(set);
    }
    
    public int getAddCount() {
        return addCount;
    }
    
    @Override
    public boolean add(E element) {
        if (super.add(element)) {
            addCount++;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addAll(Collection<? extends E> elements) {
        boolean modified = false;
        for (E element : elements) {
            modified |= this.add(element);
        }
        return modified;
        /*
         * The following code is a copy of Josh Bloch's solution:
         * 
         * addCount += elements.size(); 
         * return super.addAll(elements);
         * 
         * This code does not meet the exercise's requirements, as in the case that
         * elements includes duplicated objects, these are also counted as added
         * elements. Thus, addAll method required an implementation review.
         */
    }

}
