package org.hogwarts.test;

public class B {

    B b = new B();

    public int show() {
        return true ? null : 0;
    }

    public static void main(String[] args) {
        B b = new B();
        if(b.show() != 0) {
            System.out.println("Значение NULL");
        } else {
            System.out.println("Значение 0");
        }
    }
}
