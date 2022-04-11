package org.sandbox.multiple.inheritance;

import org.sandbox.multiple.inheritance.Animal.Bird;

/**
 * Skeletal implementation of the {@link Bird} interface. I decided to make it
 * package-private so that it is not part of its package's exported API, and
 * thus, changeable in a future release.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
abstract class AbstractBird implements Bird {

    @Override
    public void sing() { }
    
    @Override
    public void eat() { }
    
}
