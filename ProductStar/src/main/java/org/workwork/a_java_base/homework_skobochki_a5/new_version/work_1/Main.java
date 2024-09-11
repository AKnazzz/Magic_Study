package org.workwork.a_java_base.homework_skobochki_a5.new_version.work_1;

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
        print(); // должно вывести [ 4, 3, 1, 5 ]
        sort();
        print(); // должно вывести [ 1, 3, 4, 5 ]
    }

    static void sort() {
        for (int i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    static void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + data[i]);
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.println(" ]");
    }

    static void add(int value) {
        if (size >= data.length) {
            // Увеличиваем размер массива в два раза
            max_size *= 2;
            data = Arrays.copyOf(data, max_size);
        }
        data[size] = value;
        size++;
    }
}