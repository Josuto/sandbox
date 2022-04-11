package org.sandbox.patterns.singleton;

/**
 * Thread-safe Singleton design pattern implementation using an enum. This
 * approach is better than the one exposed at {@link Lennon} as it is more
 * concise, it provides serialization for free, and provides ironclad guarantee
 * against multiple instantiation. However, it is not useful if we need the
 * singleton entity to inherit responsibilities from another class.
 * 
 * @author josumartinez
 *
 */
public enum Elvis {
    
    INSTANCE;
    
    
    public void sing() {
        System.out.println("The Java reference to the object Elvis is " + INSTANCE.toString());
    }

}
