package org.workwork.first_path_java_base.homework_4;

public class HomeWork2 {
    public static void main(String[] args) {
        int n = 0;

        for (int i = 0; i <= n; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.print("fizz");
            }
            if (i > 0 && i % 5 == 0) {
                System.out.print("buzz");
            }
            if (i == 0 || (i % 3 != 0 && i % 5 !=0)) {
                System.out.print(i);
            }
            System.out.print(" ");
        }

//        for (int i = 0; i <= n; i++) {
//            if (i == 0) {
//                System.out.print(i);
//            } else if (i % 3 == 0 && i % 5 == 0) {
//                System.out.print("fizzbuzz");
//            } else if (i % 3 == 0) {
//                System.out.print("fizz");
//            } else if (i % 5 == 0) {
//                System.out.print("buzz");
//            } else {
//                System.out.print(i);
//            }
//            System.out.print(" ");
//
//        }
    }
}
