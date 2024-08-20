package org.workwork.a_java_base.homework_cycles_a4;

import java.util.Scanner;

public class HomeWork_a4_3 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Введите число:");
            int n = input.nextInt();
            String three = "fizz";
            String five = "buzz";

            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                    System.out.print(three + five + " ");
                } else if (i % 3 == 0 && i != 0) {
                    System.out.print(three + " ");
                } else if (i % 5 == 0 && i != 0) {
                    System.out.print(five + " ");
                } else {
                    System.out.print(i + " ");
                }
            }
        }
    }
}