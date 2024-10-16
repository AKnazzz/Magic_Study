package org.workwork.a_java_base.homework_cycles_a4;

import java.util.Scanner;

public class HomeWork_a4_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Запрос числа у пользователя
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

// Перебор чисел от 0 до введенного числа включительно
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("fizzbuzz ");
            } else if (i % 3 == 0) {
                System.out.print("fizz ");
            } else if (i % 5 == 0) {
                System.out.print("buzz ");
            } else {
                System.out.print(i + " ");
            }
        }

// Закрываем сканер
        scanner.close();
    }
}



