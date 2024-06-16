package org.workwork.a_java_base.homework_a4;

import java.util.Scanner;

public class HomeWork_a4_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        int n = scanner.nextInt();
        System.out.print(0 + " ");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) System.out.print("fizz");
            if (i % 5 == 0) System.out.print("buzz");
            if ((i % 3 != 0) && (i % 5 != 0)) System.out.print(i);
            System.out.print(" ");
        }
        scanner.close();
    }
}