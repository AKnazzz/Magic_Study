package org.workwork.c_java_core_one.homework_c3.work1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Double> arr = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 5.0));
        int k = 1;

        getRollingAverage(arr, k);

    }

    private static void getRollingAverage(ArrayList<Double> arr, int k) {

        List<List<Double>> listOfSubLists = new LinkedList<>();

        for (int i = 0; i <= arr.size() - k; i++) {
            List<Double> subList = new ArrayList<>(arr.subList(i, i + k));
            listOfSubLists.add(subList);
        }

        for (List<Double> subList : listOfSubLists) {
            double sum = 0;
            for (double number : subList) {
                sum += number;
            }
            double avg = sum / k;
            //System.out.println("Подмассив" + subList + ", Среднее значение " + avg);

            subList.clear();
            subList.add(avg);
            System.out.print(subList);
        }
    }
}

