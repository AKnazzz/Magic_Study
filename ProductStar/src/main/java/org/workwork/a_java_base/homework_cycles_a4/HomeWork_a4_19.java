package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_19 {
    public static void main(String[] args) {
        int n = 15;
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        boolean wasFound = false;


        for (int i = 0; i < array.length; i++) {
            int numberFromArray = array[i];
            if (numberFromArray == 0) {
                System.out.println("0");
                continue;
            }
            if (array[i] % 15 == 0) {
                System.out.println("fizzbuzz");
                continue;
            }
            if (array[i] % 3 == 0) {
                System.out.println("fizz");
                continue;
            }
            if (array[i] % 5 == 0) {
                System.out.println("buzz");

            } else if (!wasFound) {
                System.out.println(array[i]);
            }


        }
    }
}


