package org.workwork.c_java_core_one.homework_c3.work4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 4;

        getRollingAverage(arr, k);
    }

    private static void getRollingAverage(ArrayList<Integer> arr, int k) {

        List<List<Integer>> listOfSubLists = new LinkedList<>();

        for (int i = 0; i <= arr.size() - k; i++) {
            List<Integer> subList = new ArrayList<>(arr.subList(i, i + k));
            listOfSubLists.add(subList);
        }

        for (List<Integer> subList : listOfSubLists) {
            double sum = 0;
            for (int number : subList) {
                sum += number;
            }
            double avg = sum / 2;
            System.out.println(subList);
            System.out.println(avg);
        }
    }
}

