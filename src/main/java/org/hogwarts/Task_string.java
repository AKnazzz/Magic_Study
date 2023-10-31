package org.hogwarts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Реализовать метод, который принимает массив words и целое положительное число k.
 * Необходимо вернуть k наиболее часто встречающихся слов.
 * Результирующий массив должен быть отсортирован по убыванию частоты
 * встречаемого слова. В случае одинакового количества частоты для слов, то
 * отсортировать и выводить их по убыванию в лексикографическом порядке.
 */

public class Task_string {
    public static void main(String[] args) {

        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "day"};
        int k = 4;

        System.out.println(topString(words, k));


    }

    public static List<String> topString(String[] words, int k) {

        // Создаем словарь для подсчета частоты каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Создаем список из пар (слово, частота)
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCount.entrySet());

        // Сортируем список по значению (частоте) и алфавиту
        wordList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getKey().length(), a.getKey().length()); // изменение здесь
            } else {
                return b.getValue().compareTo(a.getValue()); // изменение здесь
            }
        });

        // Возвращаем только первые k слов
        return wordList.stream().map(Map.Entry::getKey).limit(k).toList();
    }
}