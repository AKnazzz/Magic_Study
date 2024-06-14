package org.workwork.c_java_core_one.homework_c3.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Дан массив целых чисел длины n и число k.
 * Вывести все подмассивы длиной k, входящие в исходный массив.
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 3;

        printSubArray(list, k);

    }

    private static void printSubArray(List<Integer> arr, int k) {

        if (arr == null || k > arr.size()) {
            System.out.println("Ошибка: некорректные входные данные");
            return;
        }

        LinkedList<Integer> subList = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            subList.add(arr.get(i));
        }

        System.out.println(subList);

        for (int i = k; i < arr.size(); i++) {
            subList.removeFirst(); // удаляем первый элемент
            subList.add(arr.get(i)); // добавляем следующий элемент - подмассив как бы движется вправо по массиву
            System.out.println(subList);
        }
    }

}
