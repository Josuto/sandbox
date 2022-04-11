package org.sandbox.nested.classes;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class exercises the use of anonymous classes in static and nonstatic
 * contexts (i.e., methods).
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public class AnonymousClass {
    
    private int a;
    private static int b;
    

    // disable instantiability and inheritance
    private AnonymousClass() { }
    
    /**
     * Can only access static members of enclosing instance. Less heap consuming.
     */
    public static List<Integer> staticAsList(final int[] array) {
        return new AbstractList<Integer>() {
            
            int c;
            // static int d = 0; // Illegal since an anonymous class cannot define any static member
            final int e = -1; // Legal declaration + instantiation of a constant variable

            @Override
            public Integer get(int index) {
                return array[index];
            }

            @Override
            public int size() {
                return array.length;
            }
            
            @Override
            public Iterator<Integer> iterator() {
                if (array.length > 0) {
                    return Arrays.stream(array).boxed().iterator();
                }
                else return new MyStaticIterator(/*a,*/ b, c, e); // // 'a' is illegal since it is not a static member of the enclosing class
                // else return new MyNonstaticIterator(/*a,*/ b); // Illegal since MyNonstaticIterator is not a static member of the enclosing class
            }
        };
    }
    
    /**
     * Can access all members of enclosing instance. Heap consuming, since it has a
     * reference to enclosing class.
     */
    public List<Integer> nonstaticAsList(final int[] array) {
        return new AbstractList<Integer>() {

            int c;
            // static int d = 0; // Illegal since an anonymous class cannot define any static member
            final int e = -1; // Legal declaration + instantiation of a constant variable
            
            @Override
            public Integer get(int index) {
                return array[index];
            }

            @Override
            public int size() {
                return array.length;
            }
            
            @Override
            public Iterator<Integer> iterator() {
                if (array.length > 0) {
                    return Arrays.stream(array).boxed().iterator();
                }
                else return new MyNonstaticIterator(a, b, c, e); // Legal since anonymous class resides in a nonstatic context
                // else return new MyStaticIterator(a, b, c, e); // Also legal since anonymous class resides in a nonstatic context
            } 
        };
    }
    
    /*
     * Custom static implementation of Iterator. This class has no reference to its
     * enclosing class.
     */
    private static class MyStaticIterator implements Iterator<Integer> {

        public MyStaticIterator(int... integers) { }
        
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
    /*
     * Custom nonstatic implementation of Iterator. This class keeps a reference to
     * its enclosing class.
     */
    private class MyNonstaticIterator implements Iterator<Integer> {

        public MyNonstaticIterator(int... integers) { }
        
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
}
