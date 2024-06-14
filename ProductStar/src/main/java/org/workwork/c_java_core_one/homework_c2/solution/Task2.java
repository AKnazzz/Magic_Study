package org.workwork.c_java_core_one.homework_c2.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Задание 2:
 * Реализуй метод, в котором создаются ArrayList, LinkedList и заполняются 1 000 000 случайными элементами одного и того же типа.
 * После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
 * Замерь время для ArrayList и LinkedList. Сравни результаты и предположи, почему они могут отличаться.
 */

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            int randomNumber = random.nextInt();
            arrayList.add(randomNumber);
            linkedList.add(randomNumber);
        }

        long arrayListTime = measureTime(arrayList);
        long linkedListTime = measureTime(linkedList);

        System.out.println("Time taken for ArrayList: " + arrayListTime + " milliseconds");
        System.out.println("Time taken for LinkedList: " + linkedListTime + " milliseconds");
    }


    // В этом коде создаются ArrayList и LinkedList, заполняются случайными элементами,
    // а затем для каждого из них вызывается метод measureTime, который выбирает элементы по случайному индексу 1000 раз
    // и замеряет время выполнения. Результаты времени выводятся на экран.

    public static long measureTime(java.util.List<Integer> list) {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(list.size());
            int element = list.get(randomIndex);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
