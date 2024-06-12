package org.hogwarts.algoritm.workshop;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int arraySize = 1000;
        int[] array = new int[arraySize];
        generate(array, arraySize);
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays.sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Insert sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        SelectSort.selectSortAscending(array);
        endTime = System.currentTimeMillis();
        System.out.println("Select sort time =" + (endTime - startTime));
    }

    public static int[] generate(int[] array, int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            array[i] = new Random().nextInt(100) + 300;
        }
        return array;
    }
}