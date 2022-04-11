package org.sandbox.patterns.abs.factory;

public abstract class VehicleStore {

    /**
     * @implNote The logic of this method assumes that all the stores sell exactly
     *           the same type of vehicles. If that is not the case, refactor the
     *           logic of this method to each concrete store.
     */
    public Vehicle assembleVehicle(final Class<? extends Vehicle> type) {
        if (Car.class.equals(type)) {
            return new Car(this.getComponentFactory());
        }
        else if (Van.class.equals(type)) {
            return new Van(this.getComponentFactory());
        }
        else throw new IllegalArgumentException("The given vehicle type is not yet supported!");
    };
    
    protected abstract VehicleComponentFactory getComponentFactory();
    
}
