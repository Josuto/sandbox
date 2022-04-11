package org.sandbox.patterns.factory.method;

public abstract class VehicleStore {

    public Vehicle purchase() {
        Vehicle vehicle = this.takeFromGarage();
        this.charge(vehicle);
        return vehicle;
    }
    
    /**
     * Factory method. The application is currently designed so that each concrete
     * store sells one {@link Vehicle} type for simplicity purposes. However, if we
     * wanted them to sell any type of vehicle with some distinctive attributes
     * (e.g., colored or distinct gas type cars and vans, where such attributes
     * are vehicle instance fields) then this method could take input parameters
     * used by its concrete implementations using e.g., the simple factory idiom or
     * the Decorator Pattern.
     */
    protected abstract Vehicle takeFromGarage();
    
    private void charge(final Vehicle vehicle) {
        System.out.println("Charging " + vehicle.getPrice() + " to the customer");
    }
    
}
