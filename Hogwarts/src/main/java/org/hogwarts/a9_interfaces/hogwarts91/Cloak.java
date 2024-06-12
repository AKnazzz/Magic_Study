package org.hogwarts.a9_interfaces.hogwarts91;

public class Cloak implements Invisible {
    private int capacity;
    private int weight;

    public Cloak(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    @Override
    public void becomeInvisible() {
        System.out.println("People under the cloak are now invisible.");
    }

    @Override
    public void becomeVisible() {
        System.out.println("People under the cloak are now visible.");
    }
}