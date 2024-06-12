package org.workwork.d_java_core_one.homework_d3.work3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 1;

        getRollingAverage(arr, k);
    }

    private static void getRollingAverage(ArrayList<Integer> arr, int k) {
        if (arr.size() < k) {
            throw new RuntimeException("Окно больше выборки !!!");
        }
        float sumSubArray = 0;
        for (int i = 0; i < k; i++) {
            sumSubArray = sumSubArray + arr.get(i);
        }
        System.out.println(sumSubArray / k);
        for (int i = k; i < arr.size(); i++) {
            sumSubArray = sumSubArray + arr.get(i) - arr.get(i - k);
            System.out.println(sumSubArray / k);
        }
    }
}