package org.workwork.a_java_base.homework_cycles_a4;

import java.util.Scanner;

public class HomeWork_a4_5 {
    private static String FIZZ = "fizz ";
    private static String BUZZ = "buzz ";
    private static String FIZZ_BUZZ = "Solution_a4 ";

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer:");
            int number = scanner.nextInt();

            boolean negativeFlag = number < 0;
            number = negativeFlag ? -1 * number : number;

            System.out.print("0 ");
            for (int i = 1; i <= number; i++) {
                if (i % 15 == 0) {
                    System.out.print(FIZZ_BUZZ);
                } else if (i % 3 == 0) {
                    System.out.print(FIZZ);
                } else if (i % 5 == 0) {
                    System.out.print(BUZZ);
                } else {
                    System.out.print((negativeFlag ? "-" + i : i) + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getLocalizedMessage());
        }
    }
}
