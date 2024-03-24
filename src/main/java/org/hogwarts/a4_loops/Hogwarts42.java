package org.hogwarts.a4_loops;

/**
 * Используя цикл, вычислите сумму всех чётных чисел от 222 до 444 включительно. Результат выведите в консоль.
 * В консоли должно появиться одно число, которое является суммой.
 */
public class Hogwarts42 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 222; i <= 444; i++) {
            if (i % 2 == 0){
                sum +=i;
            }
        }
        System.out.println("Cумма всех чётных чисел от 222 до 444 = " + sum);
    }
}
