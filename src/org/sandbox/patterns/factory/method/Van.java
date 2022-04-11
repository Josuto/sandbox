package org.sandbox.patterns.factory.method;

public final class Van implements Vehicle {

    @Override
    public int getPrice() {
        return 10000;
    }
    
    @Override
    public void drive() {
        System.out.println("I am driving a van");
    }

}
