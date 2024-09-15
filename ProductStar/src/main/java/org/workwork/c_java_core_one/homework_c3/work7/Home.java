package org.workwork.c_java_core_one.homework_c3.work7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home {
    public static void main(String[] args) {
 //       ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1 ,2 ,3, 5));
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(5);
        int k = 4;
        List<Double> res = getRollingAverage(arr, k);
        System.out.println(res);
    }

    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Double> result = new ArrayList<>();
        int n = arr.size();
        if (k > n || k <= 0) {
            throw new IllegalArgumentException("k должно быть в пределах от 1 до n");
        }
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr.get(i);
        }
        result.add(currentSum / k);
        for (int i = k; i < n; i++) {
            currentSum += arr.get(i) - arr.get(i - k);
            result.add(currentSum / k);
        }
        return result;
    }

}