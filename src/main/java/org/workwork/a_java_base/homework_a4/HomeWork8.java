package org.workwork.a_java_base.homework_a4;

import java.util.Scanner;

public class HomeWork8 {

    public static void main(String[] args) {
        System.out.println("Enter any number");

        Scanner scanner =new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            if (i % 15 == 0) {
                System.out.print(" FizzBuzz ");
            } else if (i % 5 == 0) {
                System.out.print(" Buzz ");
            } else if (i % 3 == 0) {
                System.out.print(" Fizz ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        scanner.close();
    }

}
