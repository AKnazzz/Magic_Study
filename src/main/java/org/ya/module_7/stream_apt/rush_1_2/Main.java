package org.ya.module_7.stream_apt.rush_1_2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задача 2. Догадаться, как переписать решение задачи 1 через лямбды (в крайнем случае, попросите IntelliJ IDEA превратить ваш анонимный класс в лямбду).
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

//        arrays.sort(new Comparator<>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return o1.length - o2.length;
//            }
//        });

        /**
         * решение
         */

        arrays.sort((o1, o2) -> o1.length - o2.length);


        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(arrays.get(i)));
        }

    }
}