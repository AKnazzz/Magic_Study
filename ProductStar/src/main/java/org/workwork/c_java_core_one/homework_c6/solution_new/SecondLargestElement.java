package org.workwork.c_java_core_one.homework_c6.solution_new;

/*
●	Используя оператор findFirst напишите поиск второго по величине элемента в списке целых чисел
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondLargestElement {
    public static void main(String[] args) {
        // Исходный список целых чисел
        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 9, 7, 3, 8);

        // Поиск второго по величине элемента
        Optional<Integer> secondLargest = numbers.stream()
                .distinct() // Удаляем дубликаты
                .sorted((a, b) -> b - a) // Сортируем по убыванию
                .skip(1) // Пропускаем первый элемент (наибольший)
                .findFirst(); // Находим первый элемент после пропуска

        // Вывод результата
        if (secondLargest.isPresent()) {
            System.out.println("Второй по величине элемент: " + secondLargest.get());
        } else {
            System.out.println("Нет второго по величине элемента.");
        }
    }
}
