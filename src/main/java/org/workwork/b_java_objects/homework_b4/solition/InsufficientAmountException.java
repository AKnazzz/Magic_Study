package org.workwork.b_java_objects.homework_b4.solition;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException() {
    }

    public InsufficientAmountException(String message) {
        super(message);
    }
}