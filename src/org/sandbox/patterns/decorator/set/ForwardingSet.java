package org.sandbox.patterns.decorator.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Forwarding class that composes the {@link Set} given at construction. IT IS
 * NOT the decorated object; a forwarding class is a clean code convenience that
 * simply wraps the decorated object ({@link Set} in this case).
 * <p>
 * This class shows the benefits of composition over inheritance, specially the
 * fact that ensures encapsulation.
 * 
 * @author josumartinez
 *
 * @param <E> the type of elements to be included in the {@link Set}.
 */
public class ForwardingSet<E> implements Set<E> {

    private final Set<E> set;
    
    
    public ForwardingSet(Set<E> set) {
        this.set = set;
    }
    
    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> o) {
        return set.addAll(o);
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }
    
    @Override
    public String toString() {
        return set.toString();
    }

}
