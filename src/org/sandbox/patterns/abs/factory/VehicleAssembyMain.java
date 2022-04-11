package org.sandbox.patterns.abs.factory;

public final class VehicleAssembyMain {

    public static void main(String[] args) {
        VehicleStore store = new BerlinStore();
        Vehicle vehicle = store.assembleVehicle(Car.class);
        vehicle.drive();
        
        store = new DetroitStore();
        vehicle = store.assembleVehicle(Van.class);
        vehicle.drive();
    }

}
