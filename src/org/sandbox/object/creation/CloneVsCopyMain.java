package org.sandbox.object.creation;

import java.util.List;

/**
 * Example that shows that the {@link Population#newInstance(Population)}
 * factory copy performs a deep copy of the list specified in the given
 * {@link Population} input parameter before assigning it to the instance field
 * whereas a simple implementation for the {@link Population#clone()} method
 * performs a shallow copy of such instance field.
 * 
 * @author josumartinez
 *
 */
public final class CloneVsCopyMain {

    public static void main(String[] args) {
        Population population = new Population(List.of(
                new Person("John", 39, new Address("St. Germain", 2)), 
                new Person("Hanna", 43, new Address("Torremolinos", 73))));
        System.out.println("Content of original list object: " + population.getPeople());
//        Arrays.stream(population.getPeople().toArray()).forEach(System.out::println);

        Population copy = Population.newInstance(population);
        copy.addPerson(new Person("Robert", 25, new Address("Euralia", 6)));
        System.out.println("Content of copied list object: " + copy.getPeople());
        System.out.println("Content of original list object: " + population.getPeople());
        
        Population clone = population.clone();
        clone.addPerson(new Person("Julia", 30, new Address("Hollywood", 1)));
        System.out.println("Content of cloned list object: " + clone.getPeople());
        System.out.println("Content of original list object: " + population.getPeople());
    }

}
