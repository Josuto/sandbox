package org.sandbox.object.creation;

import java.util.ArrayList;
import java.util.List;

public final class Population implements Cloneable {

    private List<Person> people;
    
    
    private Population() { }
    
    public Population(final List<Person> other) {
        this.people = new ArrayList<>(other);
    }
    
    /**
     * Returns a shallow copy of this object.
     */
    public Population clone() {
        try {
            // List does not specify clone(); we cannot perform a recursive copy of this object
            // i.e., we cannot implement population.people = this.people.clone();
            // We could if people was an array of Person, though
            return (Population) super.clone();
        } 
        catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
    
    /**
     * Returns a deep copy of this object. This means that the references to
     * {@code this.people} and {@code other.people} are not the same, but its
     * contents are.
     * 
     * @param other the given {@link Population} instance to copy.
     * @return a deep copy of this object.
     */
    public static Population newInstance(final Population other) {
        Population population = new Population();
        population.people = new ArrayList<>(other.people); 
        return population;
    }

    public List<Person> getPeople() {
        return this.people;
    }
    
    public boolean addPerson(final Person person) {
        return this.people.add(person);
    }
    
}
