/**
 * Малфой остался после уроков и получил задание: получить остатки от деления на 13, 14, 15, 16, 17, 19 числа 4199. Затем вычислить сумму остатков от деления.
 *
 * Давайте напишем код, который поможет ему это посчитать. Продолжаем работать в методe main.
 */
package org.hogwarts;

public class Task_3 {
    public static void main(String[] args) {
        int a = 4199;
        double b = (double) a%13;
        double c = (double) a%14;
        double d = (double) a%15;
        double e = (double) a%16;
        double g = (double) a%17;
        double h = (double) a%18;

        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(g);
        System.out.println(h);
    }}
