package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_16 {
    public static void main(String[] args) {
        int a = 15;
        int b = 3;
        int c = 5;
        String str = "";
        String strB = "fizz";
        String strC = "buzz";
        System.out.print("0 ");
        for (int i = 1; i <= a; i++) {
            if (i % b == 0 && i % c == 0) {
                str += strB + strC + " ";
            } else if (i % b == 0) {
                str += strB + " ";
            } else if (i % c == 0) {
                str += strC + " ";
            } else {
                str += i + " ";
            }
        }
        System.out.println(str);
    }
}