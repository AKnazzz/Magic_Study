package org.workwork.c_java_core_one.homework_c2.work_1.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, 1_000_000);

        LinkedList<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, 1_000_000);

        long startTimeArrayList = System.nanoTime();
        selectElementsRandomly(arrayList, 1000);
        long endTimeArrayList = System.nanoTime();
        long durationArrayList = (endTimeArrayList - startTimeArrayList) / 1_000_000; // в миллисекундах

        long startTimeLinkedList = System.nanoTime();
        selectElementsRandomly(linkedList, 1000);
        long endTimeLinkedList = System.nanoTime();
        long durationLinkedList = (endTimeLinkedList - startTimeLinkedList) / 1_000_000; // в миллисекундах

        System.out.println("Time taken to select elements from ArrayList: " + durationArrayList + " milliseconds");
        System.out.println("Time taken to select elements from LinkedList: " + durationLinkedList + " milliseconds");
    }

    private static void fillList(ArrayList<Integer> list, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
    }

    private static void selectElementsRandomly(ArrayList<Integer> list, int times) {
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            int index = random.nextInt(list.size());
            Integer element = list.get(index);
        }
    }

    private static void fillList(LinkedList<Integer> list, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
    }

    private static void selectElementsRandomly(LinkedList<Integer> list, int times) {
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            int index = random.nextInt(list.size());
            Integer element = list.get(index);
        }
    }
}