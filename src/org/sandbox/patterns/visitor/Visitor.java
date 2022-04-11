package org.sandbox.patterns.visitor;

/**
 * A {@link Visitor} is a Domain Service in DDD.
 * 
 * @author josumartinez
 *
 */
public interface Visitor {

    public void visit(final Circle circle);
    
    public void visit(final Rectangle square);
    
}
