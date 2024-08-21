package org.workwork.test;

public class Main {
    public static void main(String[] args) {
        A obj = new B();
        obj.display();

        int i = 5;
        do {
            System.out.println(i + " ");
            i++;
        } while (i < 5);


        int[][] matrix = new int[3][3];
        int[][] matrix2 = {{1,2},{3,4},{4,4}};


        try {
            System.out.println("try");
            int[] ints = {1,2,3};
            System.out.println(ints[3]);
            System.out.println("try 2");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Исключение перехвачено в блоке катч");
        } finally {
            System.out.println("finnaly");
        }
        System.out.println("после finnaly");

    }
}

class A {
    public void display() {
        System.out.println("AAAA");
    }
}

class B extends A {
    public void display() {
        System.out.println("BBBBBB");
    }
}
