package org.sandbox.patterns.visitor;

public final class Persist implements Visitor {

    @Override
    public void visit(Circle circle) {
        System.out.println("Circle data stored");

    }

    @Override
    public void visit(Rectangle square) {
        System.out.println("Square data stored");

    }

}
