package org.workwork.a_java_base.homework_a4;

import java.util.Scanner;

public class HomeWork_a4_4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number!");
        int anyNumber = input.nextInt();

        for (int i = 0; i <= anyNumber; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i > 0) {
                System.out.print("Solution_a4 ");
            } else if (i % 3 == 0 && i > 0) {
                System.out.print("fizz ");
            } else if (i % 5 == 0 && i > 0) {
                System.out.print("buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
