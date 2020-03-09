package org.example;

public abstract class Node {

    protected String name;

    public Node(String name) {
        this.name = name;
    }

    abstract String show(int level);

}
