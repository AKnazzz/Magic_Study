package org.workwork.c_java_core_one.homework_c3.work_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MassVsMass {
    public static void main(String[] args) {
        initialData();
    }

    public static void initialData() {
        boolean exitE = false;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Введите в массив числа (для выхода введите \"Exit\" ): ");
        while (!exitE) {
            Scanner arr = new Scanner(System.in);
            String str = arr.nextLine();
            if (exitE = str.equals("Exit")) break;
            int numArr = Integer.parseInt(str);
            list.add(numArr);
        }
        int n = 0;
        while (n == 0 || n >= list.size()) {
            System.out.println("Введите число деления массива: ");
            Scanner k = new Scanner(System.in);
            String str2 = k.nextLine();
            int numK = Integer.parseInt(str2);
            if (numK == 0 || numK > list.size()) {
                n = numK;
                System.out.println("Введен ноль или число больше размера массива. Введите еще раз");
            } else {
                listQueue(list, numK);
                break;
            }

        }

    }

    public static void listQueue(ArrayList<Integer> MassVsMass, int k) {

        LinkedList<Integer> list = new LinkedList<>();

        double res = 0;
        for (int i = 0; i < k; i++) {
            list.add(MassVsMass.get(i));
        }
        System.out.println(list);
        for (int i = 1; i <= k; i++) {
            res = res + list.get(i - 1);
        }
        res = res / k;
        Queue<Double> queue = new LinkedList<>();
        queue.add(res);
        System.out.println(queue);
        for (int i = k; i < MassVsMass.size(); i++) {
            res = 0;
            list.add(MassVsMass.get(i));
            list.remove();
            System.out.println(list);
            for (int j = 1; j <= k; j++) {
                res = res + list.get(j - 1);
            }
            res = res / k;
            queue.clear();
            queue.add(res);
            System.out.println(queue);
        }
    }
}