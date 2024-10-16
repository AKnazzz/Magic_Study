package org.workwork.c_java_core_one.homework_c3.work_9;

import java.util.ArrayList;
import java.util.List;

public class Homework3_3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);

        int k = 2;

        List<Double> startMassive = getStartMassive(arr, k);
        for (double massive : startMassive) {
            System.out.println("res= " + massive);
        }
    }
    public static List<Double> getStartMassive(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        List<Double> massives = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr.get(i + j);
            }
            massives.add(sum / k);
        }
        return massives;

    }
}