package org.workwork.c_java_core_one.homework_c2.solution;

import java.util.HashMap;

/**
 * Задание 1: Реализуй метод, который поменяет ключи и значения в HashMap местами.
 * На вход в метод поступает HashMap<Interger, String>, надо вернуть HashMap<String, Integer>. Выведи результат.
 */
public class Task1 {
    public static void main(String[] args) {
        HashMap<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "One");
        originalMap.put(2, "Two");
        originalMap.put(3, "Three");

        HashMap<String, Integer> swappedMap = swapKeysAndValues(originalMap);
        System.out.println("Swapped Map: " + swappedMap);
    }

    public static HashMap<String, Integer> swapKeysAndValues(HashMap<Integer, String> originalMap) {
        HashMap<String, Integer> swappedMap = new HashMap<>();
        for (Integer key : originalMap.keySet()) {
            String value = originalMap.get(key);
            swappedMap.put(value, key);
        }
        return swappedMap;
    }
}
