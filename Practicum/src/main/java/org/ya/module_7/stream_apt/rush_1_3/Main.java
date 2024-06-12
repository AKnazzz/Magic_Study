package org.ya.module_7.stream_apt.rush_1_3;

/**
 * Задача 3. Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
 * Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число делится без остатка на 13.
 */

public class Main {
    public static void main(String[] args) {

        NumberChecker checker = (number) -> number % 13 == 0;

        System.out.println(checker.check(26)); // Выведет false
        System.out.println(checker.check(39)); // Выведет true


        // =================================

/**
 * Задача 4. Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
 * Написать реализацию такого интерфейса в виде лямбды, которая возвращает ту строку, которая длиннее.
 */

        StringProcessor stringLengthComparator = (str1, str2) -> {
            if (str1.length() > str2.length()) {
                return str1;
            } else {
                return str2;
            }
        };

        String result = stringLengthComparator.processStrings("Hello", "Java");
        System.out.println("Большая строка: " + result); // Выведет "Большая строка: Hello"

        //================================================================

/**
 Задача 5. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c
 и возвращает тоже дробное число. Написать реализацию такого интерфейса в виде лямбда-выражения,
 которое возвращает дискриминант. Кто забыл, D = b^2 — 4ac.
 */

        DiscriminantCalculator discriminantCalculator = (a, b, c) -> {
            return b * b - 4 * a * c;
        };

        double a = 1.0;
        double b = -3.0;
        double c = 2.0;

        double discriminant = discriminantCalculator.calculateDiscriminant(a, b, c);
        System.out.println("Дискриминант: " + discriminant); // Выведет "Дискриминант: 1.0"

        //================================================================

/**
 * Задача 6. Используя функциональный интерфейс из задачи 5 написать лямбда-выражение, которое возвращает результат операции a * b^c.
 */

        PowerOperation powerOperation = (a2, b2, c2) -> {
            return a2 * Math.pow(b2, c2);
        };

        double a2 = 2.0;
        double b2 = 3.0;
        double c2 = 2.0;

        double result2 = powerOperation.calculatePower(a2, b2, c2);
        System.out.println("Результат операции a * b^c: " + result2); // Выведет "Результат операции a * b^c: 18.0"

    }
}
