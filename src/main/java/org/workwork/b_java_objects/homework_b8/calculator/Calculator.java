package org.workwork.b_java_objects.homework_b8.calculator;

import java.util.Scanner;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private static final Double[] results = new Double[10];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 0;

        for (; ; ) {

            System.out.printf("Память заполнена на %d / 9%n", i);

            if (i == 9) {
                print();
            }

            System.out.println("Введите 'выход' для завершения ");

            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("выход")) {
                print();
                break;
            } else {
                System.out.println("Тогда продолжаем");
            }
            
            double first = 0;
            double second = 0;
            boolean inputValid = false;

            while (!inputValid) {
                System.out.println("Введите 2 числа ");
                if (scanner.hasNextDouble()) {
                    first = scanner.nextDouble();
                    if (scanner.hasNextDouble()) {
                        second = scanner.nextDouble();
                        inputValid = true;
                    } else {
                        System.out.println("Ошибка: второе значение не является числом");
                        scanner.next();
                    }
                } else {
                    System.out.println("Ошибка: первое значение не является числом");
                    scanner.next();
                }
            }

            System.out.print("Введите оператор: (+, -, *, /): ");
            char operator = scanner.next().charAt(0);


            double result = 0.0;


            switch (operator) {
                case ADDITION:
                    result = first + second;
                    System.out.printf("%.1f %c %.1f = %.3f%n", first, operator, second, result);
                    i++;
                    results[i] = result;
                    break;

                case SUBTRACTION:
                    result = first - second;
                    System.out.printf("%.1f %c %.1f = %.3f%n", first, operator, second, result);
                    i++;
                    results[i] = result;
                    break;

                case MULTIPLICATION:
                    result = first * second;
                    System.out.printf("%.1f %c %.1f = %.3f%n", first, operator, second, result);
                    i++;
                    results[i] = result;
                    break;

                case DIVISION:
                    if (second == 0) {
                        throw new IllegalArgumentException("Деление на ноль!");
                    }
                    result = first / second;
                    System.out.printf("%.1f %c %.1f = %.3f%n", first, operator, second, result);
                    i++;
                    results[i] = result;
                    break;

                default:
                    throw new IllegalArgumentException("Введите корректный оператор");
            }
        }

    }

    private static void print() {
        for (Double result : results) {
            System.out.println(result);
        }
    }

}

/*
 *     ДЗ
 *     1. добавьте массив для сохранения результатов размерностью 10
 *     если результатов стало больше мы завершаем работы, информируя пользователя и распечатывая результаты
 *
 *     2. поместите код в цикл для возможности использования без постоянного запуска программы.
 *     Для выхода пусть буду слова "выход"
 *     T.е. пользователь ввел выход - мы просто выходим, сохраняя результат в массиве результатов и выводим массив на консоль.
 *
 *
 */