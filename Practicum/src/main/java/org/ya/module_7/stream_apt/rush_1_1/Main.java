package org.ya.module_7.stream_apt.rush_1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://javarush.com/groups/posts/lambda-vihrazhenija-v-java-chast-1?post=full#discussion
 * https://javarush.com/groups/posts/lambda-vihrazhenija-v-java-chast-2
 * https://javarush.com/groups/posts/495-ljambdih-i-strimih-toljhko-praktika-teorii-ne-budet
 * https://javarush.com/groups/posts/845-lambda-vihrazhenija-na-primerakh
 * https://habr.com/ru/articles/224593/
 */


public class Main {
    public static void main(String[] args) {
        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "java"};
        String[] array3 = {"мир", "труд", "май"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        arrays.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });


        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(arrays.get(i)));
        }

    }
}
