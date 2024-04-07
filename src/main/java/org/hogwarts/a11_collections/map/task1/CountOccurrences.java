package org.hogwarts.a11_collections.map.task1;

import java.util.HashMap;

/**
 * Вам дан массив, напишите алгоритм, который посчитает количества уникальных чисел используя HashMap.
 * В итоге должен получиться словарь [1->3, 2->2, 3->2, 4->2, 5]
 */


public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1, 3, 4, 5, 1};
        // Напишите свой код здесь
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(countMap);
    }
}