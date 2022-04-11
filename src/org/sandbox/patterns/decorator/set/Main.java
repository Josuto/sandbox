package org.sandbox.patterns.decorator.set;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InstrumentedSet<String> decoratedSet = new InstrumentedSet<>(new HashSet<>(List.of("mate", "pepe", "hello")));
        decoratedSet.addAll(List.of("green", "blue", "green"));
        System.out.println(decoratedSet);
        System.out.println(decoratedSet.getAddCount());
    }

}
