package org.workwork.first_path_java_base.homework_4;

import java.util.Scanner;

public class HW4ConditionalStatements {
    public static void main (String[] args) {
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String fizz = "fizz";
        String buzz = "buzz";
        String finalLetter = "";
        for (int i = 0; number >= i; i++) {
            if (i == 0) finalLetter += "0";
            else {
                if (i % 3 == 0) finalLetter += fizz;
                if (i % 5 == 0) finalLetter += buzz;
                if ((i % 3 != 0) && (i % 5 != 0)) finalLetter += i;
            }
            if (number != i) finalLetter += " ";
        }
        System.out.println(finalLetter);
    }
}