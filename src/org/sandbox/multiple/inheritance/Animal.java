package org.sandbox.multiple.inheritance;

/**
 * Animal type.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
public interface Animal {
    
    public void eat();

    /**
     * Bird type
     */
    public interface Bird extends Animal {
        
        public void sing();

    }
    
    /**
     * Horse type.
     */
    public interface Horse extends Animal {

        public void gallop();
        
    }

}
