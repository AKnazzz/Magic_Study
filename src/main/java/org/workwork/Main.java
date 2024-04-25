package org.workwork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Double> listInteger = new ArrayList<>(Arrays.asList(1.0, 7.0, 9.0, 4.0, 3.0));
//        int number = 4;
//        System.out.println(getRollingAverage(listInteger, number));

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1 ,2 ,3, 5));
        int k = 1;
        searchForTheAverage(arr, k);
    }

    private static void searchForTheAverage(ArrayList<Integer> arr, int k) {

        LinkedList<Double> average = new LinkedList<>();

        double av = 0;
        for (int i = 0; i < k; i++) {
            av = av + arr.get(i);
        }
        average.add(av / k);

        int j = k-1;
        for (int i = k; i < arr.size(); i++, j++) {
            av = 0;
            av = arr.get(j) + arr.get(i);
            average.add(av/k);
        }
        System.out.println("Исходный массив:" + arr);
        System.out.println("Массив из средних значений исходного:" + average);
    }
//    public static void printSubbary(ArrayList<Integer> list, int number){
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        ArrayList<Double> resultList = new ArrayList<>();
//        double result;
//        for(int i = 0; i < number; i++){
//            linkedList.add(list.get(i));
//        }
//        result = (linkedList.get(0) + linkedList.get(1)) / 2.0;
//        resultList.add(result);
//
//
//        for(int i = number; i < list.size(); i++ ){
//            linkedList.add(list.get(i));
//            linkedList.remove();
//            result = (linkedList.get(0) + linkedList.get(1)) / 2.0;
//            resultList.add(result);
//
//        }
//        System.out.println(resultList);
//    }

    public static List<Double> getRollingAverage(ArrayList<Double> arr, int k) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i <= arr.size() - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr.get(j);
            }
            result.add(sum / k);
        }
        return result;
    }
}