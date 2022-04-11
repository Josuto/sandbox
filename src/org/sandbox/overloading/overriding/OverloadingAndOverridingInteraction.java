package org.sandbox.overloading.overriding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * This class presents two classes, the second inheriting the first. Both
 * specify overloaded versions of the same method, each with different argument
 * types from the Collections Framework.
 * <p>
 * To see consequences of overloading execute the {@link #main(String[])}
 * method; the method to execute is decided based on the compile-time type of
 * the overloaded method's argument i.e., {@link Collection}, not its runtime
 * type. This method is {@link SuperClass#overloadedMethod(Collection)}.
 * <p>
 * However, as it is the case, if {@link SubClass} overrides
 * {@link SuperClass#overloadedMethod(Collection)}, then method overriding kicks
 * in, and {@link SubClass#overloadedMethod(Collection)} executes instead.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public class OverloadingAndOverridingInteraction {
    
    public static class SuperClass {
        
        public String overloadedMethod(final Collection<?> collection) {
            return "Super class collection";
        }
        
        public String overloadedMethod(final Set<?> set) {
            return "Super class set";
        }
        
    }
    
    public static class SubClass extends SuperClass {
        
        @Override
        public String overloadedMethod(final Collection<?> collection) {
            return "Sub class collection";
        }
        
        @Override
        public String overloadedMethod(final Set<?> set) {
            return "Sub class set";
        }
        
        public String overloadedMethod(final List<?> list) {
            return "Sub class list";
        }
        
    }
    
    public static void main(String[] args) {
        Collection<?>[] collections = {
                new Vector<>(),
                new HashSet<>(), 
                new ArrayList<>()
        };

        SuperClass superClass = new SuperClass();
        for (Collection<?> collection : collections) {
            System.out.println(superClass.overloadedMethod(collection));
        }
        
        SubClass subClass = new SubClass();
        for (Collection<?> collection : collections) {
            System.out.println(subClass.overloadedMethod(collection));
        }
    }

}
