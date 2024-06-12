package org.hogwarts.a3_if_else;

import java.util.Random;

/**
 * В методе main c помощью new Random().nextInt() сгенерируйте 2 случайных целых числа.
 * Если оба числа чётные, разделите каждое число на 2 и выведите в консоль сумму.
 * Иначе если только первое число делится на 2, разделите только первое число на 2 и выведите в консоль сумму полученного числа и второго числа.
 * Иначе, если только второе число делится на 2, разделите только второе число на 2 и выведите результат вычисления в консоль.
 * Иначе (если никакое число не делится на 2) просто выведите в консоль сумму этих чисел.
 */
public class Hogwarts31 {
    public static void main(String[] args) {
        int a = new Random().nextInt(0, 11);
        int b = new Random().nextInt(0, 11);
        System.out.println("Получено два числа: " + a + " и " + b);
        if (a % 2 == 0 && b % 2 == 0) {
            int c = (a / 2);
            int d = (b / 2);
            int e = c + d;
            System.out.println("Оба числа четные. Разделим их на 2 получаем: " + c + " и " + d);
            System.out.println("Сумма " + c + " + " + d + " = " + e);
        } else if (a % 2 == 0) {
            int c = (a / 2);
            int e = c + b;
            System.out.println("Только первое число четное. Разделим его на 2 получаем: " + c);
            System.out.println("Сумма " + c + " + " + b + " = " + e);
        } else if (b % 2 == 0) {
            int c = (b / 2);
            int e = c + a;
            System.out.println("Только второе число четное. Разделим его на 2 получаем: " + c);
            System.out.println("Сумма " + c + " + " + a + " = " + e);
        } else {
            int c = a + b;
            System.out.println("Оба числа нечетные, их сумма: " + c);
        }
    }
}
