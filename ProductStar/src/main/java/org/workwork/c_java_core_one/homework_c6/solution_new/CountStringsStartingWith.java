package org.workwork.c_java_core_one.homework_c6.solution_new;

import java.util.Arrays;
import java.util.List;

/*
Напишите подсчет количества строк в списке, которые начинаются с определенной буквы
 */

public class CountStringsStartingWith {
    public static void main(String[] args) {
        // Исходный список строк
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "berry", "cherry", "apricot");

        // Буква, с которой должны начинаться строки
        char startingLetter = 'a';

        // Подсчет количества строк, начинающихся с указанной буквы
        long count = strings.stream()
                .filter(s -> s.toLowerCase().startsWith(String.valueOf(startingLetter).toLowerCase()))
                .count();

        /*
        .filter(s -> s.startsWith(String.valueOf(letter)))
        .count();

         */

        // Вывод результата
        System.out.println("Количество строк, начинающихся с буквы '" + startingLetter + "': " + count);
    }
}

