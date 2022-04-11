package org.sandbox.patterns.abs.factory;

import java.util.Arrays;
import java.util.List;

public final class GermanyComponentFactory implements VehicleComponentFactory {

    @Override
    public Wheel assembleWeel() {
        return new LeatherWheel();
    }

    @Override
    public List<Tyre> assembleTyres() {
        Tyre[] tyres = new Tyre[4];
        for (int i = 0; i < 4; i++) {
            tyres[i] = new NormalTyre();
        }
        return Arrays.asList(tyres);
    }

}
