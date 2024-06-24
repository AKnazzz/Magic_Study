package org.workwork.a_java_base.homework_a4;

public class HomeWork_a4_17 {
    public static void main(String[] args) {
        int[] numbers = new int[21];
        for (int n = 0; n<numbers.length; n++) {
            numbers[n] = n * 1;
        }
        for (int n = 0; n<numbers.length; n++) {
            if (numbers[n] % 3 == 0 && numbers[n] % 5 == 0 && numbers[n] > 0) {
                System.out.print(" fizzbuzz, ");
            } else if (numbers[n] % 3 == 0 && numbers[n] > 0) {
                System.out.print(" fizz, ");
            } else if (numbers[n] % 5 == 0 && numbers[n] > 0) {
                System.out.print(" buzz, ");
            } else {
                System.out.print(numbers[n]);
                System.out.print(","+" ");

            }

        }
    }
}