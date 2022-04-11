package org.sandbox.patterns.factory.method;

public final class Car implements Vehicle {

    @Override
    public int getPrice() {
        return 5000;
    }    
    
    @Override
    public void drive() {
        System.out.println("I am driving a car");
    }

}
