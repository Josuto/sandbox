package org.sandbox.patterns.visitor;

public interface Shape {
    
    public void accept(final Visitor visitor);
    
    public double area();
    
}
