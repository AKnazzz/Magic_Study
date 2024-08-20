package org.workwork.a_java_base.homework_cycles_a4;

import java.util.Scanner;

public class HomeWork_a4_11 {
    public static void main(String[] args) {

        int x = new Scanner(System.in).nextInt();

        for (int i = 0; i <= x; i++) {

            if ((i % 3 == 0) && (i % 5 == 0) && (i != 0)) {
                System.out.print("Solution_a4 ");
            } else if ((i % 5 == 0) && (i != 0)) {
                System.out.print("buzz ");
            } else if ((i % 3 == 0) && (i != 0)) {
                System.out.print("fizz ");
            } else System.out.print(i + " ");

        }
    }
}
