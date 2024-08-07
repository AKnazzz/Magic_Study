package org.workwork.b_java_objects.homework_b6.homework_b6_4.homework.task2;

public class StringAndRegex {
    public static void main(String[] args) {
        String regex = "^(\\+|00)[1-9][0-9 \\-\\(\\)\\.]{7,32}$";
        System.out.println("+892 123 456 123 45 67".matches(regex));
        System.out.println("+380 (12) 1234567".matches(regex));
        System.out.println("+7 (123) 1234567".matches(regex));
    }
}
