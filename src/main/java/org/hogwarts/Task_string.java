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

//          1. Убрать дубликаты
//           TreeSet<String> uniqWords = new TreeSet<>(Arrays.asList(words)); // !!!
//           System.out.println(uniqWords);

        // Создаем словарь для подсчета частоты каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

//        for (int i = 0; i < words.length; i++) {
//            if (wordCount.containsKey(words[i])) {
//                wordCount.put(words[i], wordCount.get(words[i]) + 1);
//            } else {
//                wordCount.put(words[i], 1);
//            }
//        }



        // Создаем список из пар (слово, частота)
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCount.entrySet());

        // Сортируем список по значению (частоте) и алфавиту
        wordList.sort((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return entry2.getKey().compareTo(entry1.getKey()); // изменение здесь
            } else {
                return entry2.getValue().compareTo(entry1.getValue()); // изменение здесь
            }
        });
        // Возвращаем только первые k слов
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(wordList.get(i).getKey());
        }

        return result;
    }
}