package org.example;

public class LeafNode extends Node {
    public LeafNode(String name) {
        super(name);
    }

    @Override
    String show(int level) {
        return name;
    }
}
