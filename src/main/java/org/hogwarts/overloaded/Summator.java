package org.hogwarts.overloaded;

public class Summator {

    int summator() {
        int summ = 0;
        System.out.println("Summ is: " + summ);
        return summ;
    }

    int summator(int a) {
        int summ = 0;
        summ = summ + a;
        System.out.println("Lets summ components: " + a);
        System.out.println("Summ is: " + summ);
        return summ;
    }

    int summator(int a, int b) {
        int summ = 0;
        summ = summ + a + b;
        System.out.println("Lets summ components: " + a + ", " + b);
        System.out.println("Summ is: " + summ);
        return summ;
    }

    int summator(int a, int b, int c) {
        int summ = 0;
        summ = summ + a + b + c;
        System.out.println("Lets summ components: " + a + ", " + b + ", " + c);
        System.out.println("Summ is: " + summ);
        return summ;
    }

    int summator(int a, int b, int c, int d) {
        int summ = 0;
        summ = summ + a + b + c + d;
        System.out.println("Lets summ components: " + a + ", " + b + ", " + c + ", " + d);
        System.out.println("Summ is: " + summ);
        return summ;
    }
}


class SummatorTest{
    public static void main(String[] args) {
        Summator summator = new Summator();

        summator.summator();
        summator.summator(1);
        summator.summator(1,2);
        summator.summator(1,1,2);
        summator.summator(1,2,1,1);
    }
}