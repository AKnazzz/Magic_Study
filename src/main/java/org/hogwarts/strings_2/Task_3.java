/**
 * Малфой остался после уроков и получил задание: получить остатки от деления на 13, 14, 15, 16, 17, 19 числа 4199. Затем вычислить сумму остатков от деления.
 * <p>
 * Давайте напишем код, который поможет ему это посчитать. Продолжаем работать в методe main.
 */
package org.hogwarts.strings_2;

public class Task_3 {
    public static void main(String[] args) {
        int a = 4199;
        int b = a % 13;
        int c = a % 14;
        int d = a % 15;
        int e = a % 16;
        int g = a % 17;
        int h = a % 19;

        String lines = """
                			Protego Maxima!
                			Repello Inimicum!
                			Fianto Duri!
                """;

        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(g);
        System.out.println(h);
        System.out.println(a + b + c + d + e + g + h);

        System.out.println(lines);
    }
}
