package org.sandbox.patterns.visitor;

public final class CalculateArea implements Visitor {

    @Override
    public void visit(final Circle circle) {
        System.out.println("I am a circle and my area is: " + circle.area());
    }

    @Override
    public void visit(final Rectangle rectangle) {
        System.out.println("I am a square and my area is: " + rectangle.area());
    }

}
