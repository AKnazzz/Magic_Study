package org.workwork.a_java_base.homework_a4;

public class HomeWork7 {
    public static void main(String[] args) {
        int[] array = new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number % 3 == 0 & number % 5 == 0) {
                System.out.print("fizzbuzz");
            } else if (number % 5 == 0) {
                System.out.print("buzz");
            } else if (number% 3 == 0) {
                System.out.print("fizz");
            } else {
                System.out.print(i);
            }
        }
    }
}
