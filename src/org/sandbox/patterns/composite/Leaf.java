package org.sandbox.patterns.composite;

import java.util.UUID;

/**
 * This class represents a leaf of the tree data structure.
 * 
 * @implNote The instances of this class are immutable.
 * 
 * @author josumartinez
 *
 */
public final class Leaf extends Component {

    private final String id;

    private final String name;
    
    
    public Leaf(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Leaf) {
            return this.id.equals(((Leaf) object).id);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "LEAF - ID: " + this.id + ", Name: " + this.name; 
    }
    
}
