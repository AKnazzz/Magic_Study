package org.workwork.d_java_core_one.homework_d3.work2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(99));
        int k = 1;
        System.out.println(getRollingAverage(arr, k));
    }

    static List<Float> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Float> res = new LinkedList<>();
        float sum = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            linkedList.add(arr.get(i));
            sum += arr.get(i);
        }
        res.add(sum / k);

        for (int i = k; i < arr.size(); i++) {
            linkedList.add(arr.get(i));
            sum += arr.get(i);
            sum -= linkedList.get(0);
            res.add(sum / k);
            linkedList.remove();
        }
        return res;
    }
}
