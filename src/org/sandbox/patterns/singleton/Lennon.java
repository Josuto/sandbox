package org.sandbox.patterns.singleton;

/**
 * Thread-safe Singleton design pattern implementation using a public static
 * final field.
 * 
 * @author josumartinez
 *
 */
public final class Lennon {

    // The JVM creates a unique instance of the class when this is first loaded.
    // This operation occurs before any thread accesses INSTANCE
    public static final Lennon INSTANCE = new Lennon();

    
    /**
     * Throws an exception if any malicious code tries to create a second instance
     * of {@link Lennon} using reflection.
     */
    private Lennon() { 
        if (INSTANCE != null) {
            throw new RuntimeException("Cannot create an instance of this class reflectivey!");
        }
    }
    
    public void sing() {
        System.out.println("The Java reference to the object Lennon is " + INSTANCE.toString());
    }
    
    // Only required if declaring INSTANCE 'private' or if we need to return
    // different instances for each thread.
//    public static Lennon getInstance() {
//        return INSTANCE;
//    }
    
}
