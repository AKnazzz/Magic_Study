package org.workwork.b_java_objects.homework_b7.calculator;

import java.util.Scanner;

public class Calculator {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    public static void main(String[] args) {

        double[] numbers = new double[10];

        System.out.println("Введите 2 числа ");
        double first = readNumber();
        double second = readNumber();

        System.out.print("Введите оператор: (+, -, *, /): ");
        char operator = readOperator();

        double result = calculation(first, second, operator);
        System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result);

    }

    public static double readNumber() {
        try (Scanner reader = new Scanner(System.in)) {
            return reader.nextDouble();
        }
    }

    public static char readOperator() {
        try (Scanner reader = new Scanner(System.in)) {
            return reader.next().charAt(0);
        }
    }

    public static double calculation(double first, double second, char operator) {
        switch (operator) {
            case ADDITION:
                return first + second;

            case SUBTRACTION:
                return first - second;

            case MULTIPLICATION:
                return first * second;

            case DIVISION:
                if (second == 0) {
                    throw new IllegalArgumentException("Деление на ноль!");
                }
                return first / second;

            default:
                throw new IllegalArgumentException("Введите корректный оператор");
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