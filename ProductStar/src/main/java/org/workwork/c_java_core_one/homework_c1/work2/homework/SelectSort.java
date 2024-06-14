package org.workwork.c_java_core_one.homework_c1.work2.homework;

public class SelectSort {
    //сложность алгоритма O(n^2)
    public static int[] selectSortAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
        return arr;
    }
}