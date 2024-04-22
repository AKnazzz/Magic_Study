package org.workwork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> listInteger = new ArrayList<>(Arrays.asList(1.0, 7.0, 9.0, 4.0, 3.0));
        int number = 4;
        System.out.println(getRollingAverage(listInteger, number));
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