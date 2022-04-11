package org.sandbox.patterns.visitor;

public final class Rectangle implements Shape {
    
    private int length, width;
    
    
    public Rectangle(final int length, final int width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double area() {
        return length * width;
    }
    
}
