package org.sandbox.patterns.abs.factory;

import java.util.List;

/**
 * Abstract factory class.
 * 
 * @author josumartinez
 *
 */
public interface VehicleComponentFactory {

    public Wheel assembleWeel();
    
    public List<Tyre> assembleTyres();
    
}
