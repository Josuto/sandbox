package org.sandbox.patterns.abs.factory;

public final class BerlinStore extends VehicleStore {

    @Override
    protected VehicleComponentFactory getComponentFactory() {
        return new GermanyComponentFactory();
    }

}
