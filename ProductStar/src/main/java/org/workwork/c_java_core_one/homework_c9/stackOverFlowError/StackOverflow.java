package org.workwork.c_java_core_one.homework_c9.stackOverFlowError;

/*
⚒ Задание 1. Написать программу, которая вызывает java.lang.StackOverFlowError
 */
public class StackOverflow {
    public static void main(String[] args) {
        call();
    }

    private static void call(){
        call();
    }
}