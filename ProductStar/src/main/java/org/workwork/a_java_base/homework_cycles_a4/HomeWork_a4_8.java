package org.workwork.a_java_base.homework_cycles_a4;

import java.util.Scanner;

public class HomeWork_a4_8 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number");
        int numbers = sc.nextInt();
        int[] array = new int[numbers];
        for (int i = 0; i <= array.length; i++) {
            if (i == 0) {
                System.out.print("0 ");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("Solution_a4 ");
            } else if (i % 5 == 0) {
                System.out.print("buzz ");
            } else if (i % 3 == 0) {
                System.out.print("fizz ");
            } else {
                System.out.print(i + " ");
            }
            sc.close();
        }
    }

}
