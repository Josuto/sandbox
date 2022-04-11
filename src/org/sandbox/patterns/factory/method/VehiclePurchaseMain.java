package org.sandbox.patterns.factory.method;

public final class VehiclePurchaseMain {

    public static void main(String[] args) {
        VehicleStore store = new VitoriaStore();
        Vehicle vehicle = store.purchase();
        vehicle.drive();
    }

}
