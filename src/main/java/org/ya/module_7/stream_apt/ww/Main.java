package org.ya.module_7.stream_apt.ww;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //посчитать сумму
        int summa = numbers.stream()
                .mapToInt(a -> a.intValue())
                .sum();

        //умоножить на 2 каждый
        List<Integer> numbers2 = numbers.stream()
                .sorted((a, b) -> {
                    boolean aBul = (a % 2 == 0);
                    boolean bBul = (b % 2 == 0);

                    if (aBul && bBul) {
                        return b - a;
                    } else if (!aBul && !bBul) {
                        return b - a;
                    } else if (aBul && !bBul) {
                        return b - a;
                    } else {
                        return a - b;
                    }
                })
                .map(a -> a * 2)
                .toList();

        System.out.println(numbers2);

        //сортировать по четному
        List<Integer> numbers3 = numbers2.stream()
                .filter(a -> a < 10)
                .toList();

        System.out.println(numbers3);

        List<String> strings = numbers3.stream()
                .map(String::valueOf)
                .toList();

        System.out.println(strings);

    }

}

