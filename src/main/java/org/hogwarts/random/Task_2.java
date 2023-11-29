package org.hogwarts.random;

import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {

        int grade1 = new Random().nextInt(1, 10);
        int grade2 = new Random().nextInt(1, 10);

        System.out.println("grade1: " + grade1);
        System.out.println("grade2: " + grade2);

        boolean result = grade1 > 5 && grade2 > 5;
        double mid = (double) (grade1 + grade2) / 2;

        System.out.println("Оба числаб больше 5: " + result);
        System.out.println("средний балл: " + mid);
    }
}
