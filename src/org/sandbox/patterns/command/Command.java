package org.sandbox.patterns.command;

import java.util.function.IntFunction;

/**
 * Command interface synonymous of {@link IntFunction}, but we decided to create
 * it so that it can be included in the UML representation of the Command design
 * pattern.
 * 
 * @author josumartinez
 *
 */
@FunctionalInterface
public interface Command {
    
    int execute(final int number);
    
}
