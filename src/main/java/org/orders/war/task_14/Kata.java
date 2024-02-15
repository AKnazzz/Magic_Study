package org.orders.war.task_14;

import java.util.ArrayList;

/**
 * Учитывая случайное неотрицательное число, вы должны вернуть цифры этого числа в массиве в обратном порядке.
 */
public class Kata {
    public static int[] digitize(long n) {

        //   int sizeOfThisBoi = ("" + n).length();
        //    int[] arr = new int[sizeOfThisBoi];
        //    for(int i = 0; i < sizeOfThisBoi; i++) {
        //      arr[i] = (int) (n % 10);
        //      n = n / 10;
        //    }
        //  return arr

        if (n == 0) {
            return new int[]{0};
        }

        ArrayList<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add((int) (n % 10)); //Внутри цикла добавляем остаток от деления числа n на 10 (последнюю цифру n)
            n /= 10;
        }

        int[] reversedArray = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            reversedArray[i] = digits.get(i);
        }

        return reversedArray;
    }
}
