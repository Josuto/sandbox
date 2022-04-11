package org.sandbox.patterns.factory.method;

public final class VicStore extends VehicleStore {

    @Override
    protected Vehicle takeFromGarage() {
        return new Car();
    }

}
