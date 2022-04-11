package org.sandbox.intrf.framework;

/**
 * {@link Foo} companion class designed to operate on {@link Foo} instances.
 * This was the way to create interface-based frameworks prior Java 8.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public abstract class Foos {

    private Foos() {} // to ensure immutability and non-instantiability
    
    public static Foo create() {
        return new Bar();
    }
    
    public static void update(final Foo foo) {
        foo.method();
    }
    
}
