package org.workwork.c_java_core_one.homework_c3.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Дан непустой массив целых чисел длиной n и число k (0 < k <= n).
 * Нужно вывести среднее значение для всех подмассивов длиной k, входящих в исходный массив.
 */

public class MainDZ {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 7, 9, 4, 3));
        int k = 4;

        List<Double> rollingAverages = getRollingAverage(arr, k);
        System.out.println(rollingAverages);
    }

    public static List<Double> getRollingAverage(List<Integer> arr, int k) {

        if (arr.size() < k || k == 0) {
            throw new IllegalArgumentException("Array size must be greater than or equal to k, and k must be non-zero.");
        }

        List<Double> result = new ArrayList<>();

        for (int i = 0; i <= arr.size() - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr.get(j);
            }
            double average = (double) sum / k;
            result.add(average);
        }
        return result;
    }

}