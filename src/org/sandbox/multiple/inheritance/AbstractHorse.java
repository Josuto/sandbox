package org.sandbox.multiple.inheritance;

import org.sandbox.multiple.inheritance.Animal.Horse;

/**
 * Skeletal implementation of the {@link Horse} interface. I decided to make it
 * package-private so that it is not part of its package's exported API, and
 * thus, changeable in a future release.
 * 
 * @author Josu Martinez
 * @version 1.0
 *
 */
abstract class AbstractHorse implements Horse {

    @Override
    public void gallop() { }
    
    @Override
    public void eat() { }

}
