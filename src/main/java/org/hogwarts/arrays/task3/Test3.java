package org.hogwarts.arrays.task3;

import java.util.Arrays;
import java.util.Random;

/**
 * Попробуем написать небольшой алгоритм. Все необходимые инструменты мы уже прошли. За подсказками попробуйте обратиться к предыдущим урокам.
 * <p>
 * Создайте массив из 5 целых чисел. Напишите код для нахождения наименьшего и наибольшего элемента в массиве. Выведите эти элементы в консол
 */
public class Test3 {
    public static void main(String[] args) {

        Random random = new Random();

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(0, 101);
        }

        System.out.println(Arrays.toString(numbers));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min){
                min = number;
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);


    }
}
