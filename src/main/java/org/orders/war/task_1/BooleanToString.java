package org.orders.war.task_1;

/**
 * Реализуйте функцию, которая преобразует данное логическое значение в его строковое представление.
 */
public class BooleanToString {
    public static String convert(boolean b) {
        if (b) {
            return "true";
        } else
            return "false";
    }
}

// return Boolean.toString(b);
