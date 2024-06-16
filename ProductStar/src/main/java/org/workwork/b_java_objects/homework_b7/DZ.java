package org.workwork.b_java_objects.homework_b7;

import java.util.regex.Pattern;

/**
 * Задание:
 *
 * Напишите программу «Налог».
 * На вход программы поступает массив с ценниками.
 *
 * Вам нужно рассчитать налог исходя из диапазона цены.
 * Вывести налоги в консоль.
 *
 *      А. Проверять входной ценник по регулярному выражению, что это число и оно больше 0.
 *
 *      В. Если нет ценников с диапазоном 1,2,3 то и выводить такие данные не нужно.
 *
 * Учтите:
 *
 * Ценники больше 10000 не обрабатывать.
 * Ценники могут быть дробными.
 */

public class DZ {
    private static final String[] prise = {"10.2", "0", "-33.9", "777.9", "36.2", "100000000.0", "372.9", "100"};
    private static final Integer TAX_10 = 10;
    private static final Integer TAX_20 = 20;
    private static final Integer TAX_30 = 30;
    private static final String PATTERN = "^[+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$";

    public static void main(String[] args) {

        printTax(prise);
    }

    private static void printTax(String[] prise) {
        for (String s : prise) {
            if (Pattern.matches(PATTERN, s)) {
                Double aDouble = Double.valueOf(s);
                if (0 < aDouble && aDouble <= 100) {
                    System.out.println(calcTax(aDouble, TAX_10));
                    continue;
                }
                if (100 < aDouble && aDouble <= 1000) {
                    System.out.println(calcTax(aDouble, TAX_20));
                    continue;
                }
                if (1000 < aDouble && aDouble <= 10000) {
                    System.out.println(calcTax(aDouble, TAX_30));
                }
            }
        }
    }
    private static Double calcTax(Double aDouble, Integer tax) {
        return aDouble * tax / 100;
    }
}