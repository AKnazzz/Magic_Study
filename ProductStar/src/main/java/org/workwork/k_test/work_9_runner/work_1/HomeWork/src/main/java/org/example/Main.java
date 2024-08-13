package org.workwork.k_test.work_9_runner.work_1.HomeWork.src.main.java.org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Values values = new Values(23, "big", "no", 3);
        System.out.println(calculator.calculate(values));
    }
}