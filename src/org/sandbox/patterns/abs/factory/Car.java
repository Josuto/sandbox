package org.sandbox.patterns.abs.factory;

public final class Car extends Vehicle {

    public Car(final VehicleComponentFactory componentFactory) {
        super(componentFactory);
    }

}
