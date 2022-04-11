package org.sandbox.patterns.composite;

import java.util.Iterator;

public abstract class Component {

    /**
     * Operation only supported by a tree {@link Node}.
     */
    public boolean addComponent(final Component component) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Operation only supported by a tree {@link Node}.
     */
    public boolean removeComponent(final Component component) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Operation only supported by a tree {@link Leaf}.
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }

    /**
     * Example of Internal Iteration i.e., this method traverses the tree structure.
     */
    public void print() {
        System.out.println(this.toString());
    }
    
    /**
     * Example of External Iteration i.e., the tree client can traverse the tree
     * structure via the returned {@link Iterator}.
     */
    public Iterator<Leaf> iterator() {
        return null;
    }
    
}
