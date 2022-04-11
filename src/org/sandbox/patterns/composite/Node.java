package org.sandbox.patterns.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Node extends Component {

    List<Component> components = new ArrayList<>();
    
    
    public Node() { }
    
    public Node(final Collection<Component> components) {
        this.components.addAll(components);
    }
    
    @Override
    public boolean addComponent(final Component component) {
        return this.components.add(component);
    }
    
    @Override
    public boolean removeComponent(final Component component) {
        return this.components.remove(component);
    }
    
    @Override
    public int hashCode() {
        return this.components.hashCode();
    }
    
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Node) {
            return this.components.equals(((Node) object).components);
        }
        return false;
    }
    
    /**
     * Returns a String representation of the {@link Node}.
     * 
     * @implNote This method returns a <i>plain</i> String representation of the
     *           {@link Node}. For cooler node representations, we may need to
     *           implement the Visitor design pattern, as mentioned at
     *           https://www.baeldung.com/java-print-binary-tree-diagram.
     */
    @Override
    public String toString() {
        String result = "NODE\n";
        Iterator<Component> iterator = this.components.iterator();

        while (iterator.hasNext()) {
            Component component = iterator.next();
            result += component.toString();
            if (iterator.hasNext()) {
                result += "\n";
            }
        }
        return result; 
    }
    
}
