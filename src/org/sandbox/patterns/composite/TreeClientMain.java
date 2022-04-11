package org.sandbox.patterns.composite;

import java.util.List;

public final class TreeClientMain {

    public static void main(String[] args) {
        Leaf level1Leaf = new Leaf("Tony");
        Leaf level2Leaf1 = new Leaf("Esther");
        Leaf level2Leaf2 = new Leaf("John");
        Node level1Node = new Node(List.of(level2Leaf1, level2Leaf2));
        Node root = new Node(List.of(level1Leaf, level1Node));
        
        root.print();
    }

}
