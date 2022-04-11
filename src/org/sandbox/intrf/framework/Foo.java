package org.sandbox.intrf.framework;

/**
 * Prior to Java 8, this interface used to specify the logic to be implemented
 * by concrete classes e.g., {@link Bar}. Java 8 introduced static methods at
 * interfaces, and thus this class may also have include {@link Foos}'s logic.
 * Drawback: the Java 8+ version of this interface is tightly coupled to its
 * implementations.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public interface Foo {

    public void method();
    
    // Alternative to Foos.create in Java 8+
    public static Foo create() {
        return new Bar();
    }
    
    // Alternative to Foos.update in Java 8+
    public static void update(final Foo foo) {
        foo.method();
    }
    
}
