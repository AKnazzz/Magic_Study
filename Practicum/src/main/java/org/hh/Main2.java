package org.hh;

public class Main2 {
    public static void main(String[] args) {
        int a = 10;
        change(a);
        change2(a);
    }

    static void change(int a) {
        a = 20;
    }

    static void change2(int a) {
        System.out.println(a);
    }
}
