package org.workwork.c_java_core_one.homework_c3.work5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1 ,2 ,3, 5));
        int k = 1;

        System.out.println(outputElementsMiddleValue(arr, k));
    }

    private static LinkedList<Float> outputElementsMiddleValue(ArrayList<Integer> arr, int k) {

        LinkedList<Float> newArrayList = new LinkedList<>();

        for(int i = 0; i < arr.size() - (k - 1); i++) {
            int tempIndex = i;
            float middleValueSum = 0;
            float middleValue = 0;

            for(int j = 0; j < k; j++) {
                middleValueSum += arr.get(tempIndex);
                middleValue = middleValueSum / k;
                tempIndex++;
            }

            newArrayList.add(middleValue);

        }

        return newArrayList;
    }
}