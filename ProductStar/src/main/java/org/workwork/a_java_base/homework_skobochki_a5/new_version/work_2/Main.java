package org.workwork.a_java_base.homework_skobochki_a5.new_version.work_2;

import java.util.Arrays;

public class Main {
    static int max_size = 2;
    static int size = 0;
    static int[] data = new int[max_size];

    public static void main(String[] args) {
        add(4);
        add(3);
        add(1);
        add(5);
        print(); // должно вывести 4,3,1,5
        sort();
        print(); // должно вывести 1,3,4,5
    }

    public static void sort() {
        for (int i = 0; i < data.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minElementIndex] > data[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = data[i];
                data[i] = data[minElementIndex];
                data[minElementIndex] = temp;
            }
        }
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }

    static void add(int value) {
        if (size >= data.length) {
            max_size *= 2;
            int[] temp = Arrays.copyOf(data, size);
            data = new int[max_size];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;
    }
}
