package org.sandbox.patterns.iterator;

/**
 * This class is a synonym of Java {@link java.util.Iterator}. It exists just so
 * that it appears in the UML diagram of the Iterator design pattern.
 * 
 * @author josumartinez
 *
 * @param <T> the type of elements handled by an instance of {@link Iterator}.
 */
public interface Iterator<T> {
    
    boolean hasNext();
    
    T next();

}
