package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_2 {
    public static void main(String[] args) {
        int n = 0;

        for (int i = 0; i <= n; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.print("fizz");
            }
            if (i > 0 && i % 5 == 0) {
                System.out.print("buzz");
            }
            if (i == 0 || (i % 3 != 0 && i % 5 != 0)) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
