package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_17 {
    public static void main(String[] args) {

        for (int i = 0; i <= 20; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i > 0) {
                System.out.print("fizzbuzz ");
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


