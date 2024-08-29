package org.workwork.c_java_core_one.homework_c6.solution_new;

/*
●	Напишите удаление всех повторяющихся элементов из списка
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Исходный список с дубликатами
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 1, 5, 6, 5);

        // Удаление дубликатов с использованием distinct()
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Вывод результата
        System.out.println("Список без дубликатов: " + uniqueNumbers);
    }
}
