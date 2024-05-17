package org.workwork.d_java_core_one.homework_d2.solution;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Задание 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты,
 * не используя метод contains().
 * Можно использовать другие коллекции, которые были изучены на уроке.
 */

public class Task3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");
        list.add("banana");

        System.out.println("Original ArrayList: " + list);

        removeDuplicates(list);

        System.out.println("ArrayList after removing duplicates: " + list);
    }

    public static void removeDuplicates(ArrayList<String> list) {
        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < list.size(); i++) {
//            if (!set.contains(list.get(i))) {
//                set.add(list.get(i));
//            }
//        }
        set.addAll(list);

        list.clear();
        list.addAll(set);
    }
}
