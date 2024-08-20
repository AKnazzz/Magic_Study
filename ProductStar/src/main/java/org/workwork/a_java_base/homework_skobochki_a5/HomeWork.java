package org.workwork.a_java_base.homework_skobochki_a5;

import java.util.Stack;

/**
 * Задача 1: Реализовать алгоритм reverse (перевернуть) для строки.
 * Выполни задачу и проверь, что она проходит тесты, на сайте. На проверку пришли скрин выполненного задания.
 * <p>
 * Задача 2: Дана строка S, содержащая только символы '(', ')', '{', '}', '[' и ']'. Определи, является ли ‘правильной’ строка.
 * <p>
 * Входная строка действительна, если выполняются следующие условия:
 * <p>
 * • Открытые скобки должны быть закрыты однотипными скобками.
 * • Открытые скобки должны быть закрыты в правильном порядке.
 * • Каждой закрывающей скобке соответствует открытая скобка того же типа.
 * Выполни задачу на сайте. На проверку пришли скрин выполненного задания.
 */
public class HomeWork {
    public static void main(String[] args) {
        String input = "({[]})";
        String reverced = reverseString(input);
        System.out.println(reverced);
        System.out.println(reverseString2(input));
    }

    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static String reverseString2(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
