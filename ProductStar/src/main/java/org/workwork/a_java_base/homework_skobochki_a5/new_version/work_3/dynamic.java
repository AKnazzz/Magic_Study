package org.workwork.a_java_base.homework_skobochki_a5.new_version.work_3;

import java.util.Arrays;


public class dynamic {

    static int max_size = 2;
    static int size = 0;
    static int[] data = new int[max_size];

    public static void main(String[] args) {
        add(4);
        add(3);
        add(1);
        add(5);
        add(2);
        add(7);
        add(1);
        add(5);
        add(2);
        print(); // должно вывести 4,3,1,5
        sort();
        print(); // должно вывести 1,3,4,5
    }

    static void sort() {
        for (int m = 0; m < data.length-1; m++){
            for (int n = 0; n < data.length - 1; n++){
                int temp = data[n];
                if (temp > data[n + 1]) {
                    data[n] = data[n + 1];
                    data[n + 1] = temp;
                }
                for (int k = 1; k < data.length-1 ; k++){
                    int temp0 = data[k];
                    if(temp0 == 0){
                        data[k]=data[k+1];
                        data[k+1]=temp0;
                    }
                }
            }
        }
    }
    static void print() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++){
            System.out.print(" " + data[i]);
        }
        System.out.println(" ]");
    }static void add(int value) {
        if (size >= data.length) {
            max_size *= 2;
            int[] temp = Arrays.copyOf(data, size);
            data = new int[max_size];
            for (int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
        data[size] = value;
        size++;
    }
}