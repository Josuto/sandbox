package org.sandbox.patterns.iterator;

import java.util.List;

/**
 * This class represents a client in the realization of the Iterator design
 * pattern. It is completely ignorant of the actual container implementation
 * details of the aggregator data structure holding the values that it wants to
 * traverse. Hence, this client is decoupled from both from the aggregator data
 * structure and its natural traversing algorithm(s).
 * 
 * 
 * @author josumartinez
 *
 */
public final class IteratorClientMain {

    public static void main(String[] args) {
        Aggregate<String> aggregate = new ArrayAggregate<>(List.of("Peter", "Emma", "Maria"));
        
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
