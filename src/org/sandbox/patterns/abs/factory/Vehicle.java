package org.sandbox.patterns.abs.factory;

import java.util.List;

public abstract class Vehicle {

    private Wheel wheel;
    
    private List<Tyre> tyres;
    
    private final VehicleComponentFactory componentFactory;
    
    
    public Vehicle(final VehicleComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
        this.assembleComponents();
    }
    
    private void assembleComponents() {
        this.wheel = this.componentFactory.assembleWeel();
        this.tyres = this.componentFactory.assembleTyres();
    }
    
    public void drive() {
        System.out.println("I am driving a " + this.getType() + " with a " + this.wheel.getType() 
            + " wheel and some " + tyres.get(0).getType() + " tyres");
    }
    
    private String getType() {
        return this.getClass().getSimpleName().toLowerCase();
    }
    
}
