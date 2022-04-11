package org.sandbox.patterns.factory.method;

public final class VitoriaStore extends VehicleStore {

    @Override
    protected Vehicle takeFromGarage() {
        return new Van();
    }

}
