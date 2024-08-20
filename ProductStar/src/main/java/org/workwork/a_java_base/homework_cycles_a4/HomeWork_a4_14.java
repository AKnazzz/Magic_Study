package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_14 {
    public static void main(String[] args) {
        int a = 15;
        int b = 3;
        int c = 5;
        int step = 2;
        int k = 0;
        String str = "";
        String strB = "fizz";
        String strC = "buzz";
        System.out.print(0);
        for (int i = 1; i <= a; i++) {
            System.out.print(" ");
            str = strB;
            for (int j = b; j <= c; j += step) {
                switch (i % j) {
                    case 0:
                        System.out.print(str);
                        k = 1;
                }
                str = strC;
            }
            if (k == 0) {
                System.out.print(i);
            }
            k = 0;
        }
    }
}