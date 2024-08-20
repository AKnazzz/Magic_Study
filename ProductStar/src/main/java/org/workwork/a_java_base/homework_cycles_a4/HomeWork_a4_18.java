package org.workwork.a_java_base.homework_cycles_a4;

public class HomeWork_a4_18 {
    public static void main(String[] args) {
        int n = 30;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                result.append(" ");
            }

            if(i==0){result.append(0);}
            else if (i % 3 == 0 && i % 5 == 0) {
                result.append("fizzbuzz");
            } else if (i % 5 == 0) {
                result.append("buzz");
            } else if (i % 3 == 0) {
                result.append("fizz");
            } else {
                result.append(i);
            }
        }
        System.out.println(result);
    }
}