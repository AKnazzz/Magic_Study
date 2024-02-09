package org.workwork.a_java_base.homework_a4;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {


        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        for (int i = 0; i <= N; i++) {

            if (i != 0 & i % 3 == 0 & i % 5 == 0) {
                System.out.print("fizz buzz" + " ");

            } else if (i != 0 & i % 3 == 0) {
                System.out.print("fizz" + " ");

            } else if (i != 0 & i % 5 == 0) {
                System.out.print("buzz" + " ");

            } else {
                System.out.print(i + " ");
            }
        }
    }
}
