package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_9 {
    public static void main(String[] args) {
        int n = 15;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("0");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.print(" Solution_a4 ");
            } else if (i % 3 == 0) {
                System.out.print(" fizz ");
            } else if (i % 5 == 0) {
                System.out.print(" buzz ");
            } else {
                System.out.print(i);
            }
        }
    }
}
