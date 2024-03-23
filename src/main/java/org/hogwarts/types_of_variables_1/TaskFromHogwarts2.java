package org.hogwarts.types_of_variables_1;

/**
 * Малфой остался после уроков и получил задание: получить остатки от деления на 13, 14, 15, 16, 17, 19 числа 4199.
 * Затем вычислить сумму остатков от деления.
 * <p>
 * Давайте напишем код, который поможет ему это посчитать. Продолжаем работать в методe main.
 */
public class TaskFromHogwarts2 {
    public static void main(String[] args) {

        int ostatokOne = 4199 % 13;
        int ostatokTwo = 4199 % 14;
        int ostatokThree = 4199 % 15;
        int ostatokFour = 4199 % 16;
        int ostatokFive = 4199 % 17;
        int ostatokSix = 4199 % 19;

        int sumOstatkov = ostatokOne + ostatokTwo + ostatokThree + ostatokFour + ostatokFive + ostatokSix;

        System.out.println("Остаток от деления числа 4199 на 13: "  + ostatokOne);
        System.out.println("Остаток от деления числа 4199 на 14: "  + ostatokTwo);
        System.out.println("Остаток от деления числа 4199 на 15: "  + ostatokThree);
        System.out.println("Остаток от деления числа 4199 на 16: "  + ostatokFour);
        System.out.println("Остаток от деления числа 4199 на 17: "  + ostatokFive);
        System.out.println("Остаток от деления числа 4199 на 19: "  + ostatokSix);
        System.out.println("Сумма остаток от деления: "  + sumOstatkov);
        System.out.println("Это магия, детка!");


    }
}
