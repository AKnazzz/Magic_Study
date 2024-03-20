package org.workwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,3,5,3,3,6,9,6,0,1));
        int k = 2;

        getRollingAverage(arr, k);
    }

    private static void getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Float> sublist = new LinkedList<>();

        for (int i = 1; i < k; i++) {
            float x = arr.get(i);
            float y = arr.get(i - 1);
            float z = (x + y)/2;

            sublist.add(z);
        }

        System.out.println(sublist);

        for (int i = k; i <arr.size(); i++) {
            float x = arr.get(i);
            float y = arr.get(i - 1);
            float z = (x + y)/2;

            sublist.add(z);
            sublist.remove();
            System.out.println(sublist);
        }

    }
}