package org.sandbox.patterns.abs.factory;

public final class DetroitStore extends VehicleStore {

    @Override
    protected VehicleComponentFactory getComponentFactory() {
        return new UsaComponentFactory();
    }

}
