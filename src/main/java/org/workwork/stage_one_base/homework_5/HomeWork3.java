package org.workwork.stage_one_base.homework_5;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = input.nextInt();
        int[] Array = new int[]{n};
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0) {
                System.out.print("fizz ");
            }
            if (i % 5 == 0) {
                System.out.print("buzz ");
            }
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("fizzbuzz ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
    }
}
