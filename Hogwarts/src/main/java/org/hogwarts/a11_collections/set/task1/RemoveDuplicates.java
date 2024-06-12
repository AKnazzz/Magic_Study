package org.hogwarts.a11_collections.set.task1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Вам дан список. С помощью Set удалите дубликаты из списка, и выведите на экран получившееся множество.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 3, 6, 7, 5);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        System.out.println("Уникальные числа:");
        for (int num : uniqueNumbers) {
            System.out.println(num);
        }
    }
}
