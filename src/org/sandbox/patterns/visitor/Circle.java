package org.sandbox.patterns.visitor;

public final class Circle implements Shape {
    
    private int radius;
    

    public Circle(final int radius) {
        this.radius = radius;
    }
    
    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
    
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

}