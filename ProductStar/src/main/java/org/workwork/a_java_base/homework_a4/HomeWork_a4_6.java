package org.workwork.a_java_base.homework_a4;

public class HomeWork_a4_6 {
    public static void main(String[] args) {
        // int i;
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 15, 17, 20, 21};

        for (int i = 0; i <= 21; i++) {
            if (i % 3 == 0) {
                System.out.print("fizz");
            } else if (i % 5 == 0) {
                System.out.print("buzz ");
            } else if (i % 5 == 0 && i % 3 == 0) {
                System.out.print("fizz buzz ");
            }
        }
    }
}
