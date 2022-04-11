package org.sandbox.patterns.visitor;

import java.util.List;

public final class ClientMain {

    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(2), new Rectangle(3, 2));
        List<Visitor> algorithms = List.of(new CalculateArea(), new Persist());
        
        executeShapeAlgorithms(shapes, algorithms);
    }
    
    private static void executeShapeAlgorithms(
            final List<Shape> shapes,
            final List<Visitor> algorithms) {
        for (Shape shape: shapes) {
            for (Visitor algorithm : algorithms) {
                shape.accept(algorithm);
            }
        }
    }

}
