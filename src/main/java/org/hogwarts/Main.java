package org.hogwarts;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Oh, you’re a magician, friend! Welcome to Hogwarts!");

        AtomicInteger counter = new AtomicInteger(0);
        int currentValue = counter.get();
        System.out.println("Current value: " + currentValue);

        int newValue = counter.incrementAndGet();
        System.out.println("New value: " + newValue);

        Thread thread = new Thread(() -> {
            System.out.print("Hello, world!");
        });
        thread.start();
    }
}