package org.sandbox.patterns.singleton;

public final class SingersMain {

    public static void main(String[] args) {
        
        Elvis elvis = Elvis.INSTANCE;
        
        elvis.sing();
        
        Elvis elvis2 = Elvis.INSTANCE;
        
        elvis2.sing();
        
        // ----
        
        Lennon lennon = Lennon.INSTANCE;
        
        lennon.sing();
        
        Lennon lennon2 = Lennon.INSTANCE;
        
        lennon2.sing();

    }

}
