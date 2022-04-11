package org.sandbox.multiple.inheritance;

import org.sandbox.multiple.inheritance.Animal.Bird;

/**
 * Example of simulated multiple inheritance (Effective Java, Item 20, page
 * 102). A class inherits an skeletal implementation class (some class designed
 * for inheritance) as well as an interface to be implemented by some private
 * inner class, that may in turn inherit an skeletal implementation class.
 * 
 * Similarly to the wrapper idiom, the class forwards the methods of the
 * inherited interface to the instance of the private inner class, which in turn
 * may be forwarded to the instance of its skeletal implementation.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public class Pegasus extends AbstractHorse implements Bird {

    private Bird bird;

    
    public Pegasus() {
        this.bird = new Eagle();
    }
    
    /**
     * Constructor that enables Dependency Inversion.
     */
    public Pegasus(final Bird bird) {
        this.bird = bird;
    }
    
    // This method forwards to the logic specified at the private inner class. 
    @Override
    public void sing() {
        this.bird.sing();
    }
    
    // This method illustrates the diamond problem resolution: a Pegasus eats like a horse. 
    @Override
    public void eat() {
        super.eat();
    }
    
    
    /**
     * Private inner class that enables simulated multiple inheritance.
     */
    private static class Eagle extends AbstractBird {
        
        @Override
        public void sing() {
            super.sing();
        }
        
    }
    
}
