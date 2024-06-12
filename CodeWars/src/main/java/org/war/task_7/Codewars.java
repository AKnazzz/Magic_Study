package org.war.task_7;

/**
 * Given a list of integers, determine whether the sum of its elements is odd or even.
 * <p>
 * Give your answer as a string matching "odd" or "even".
 * <p>
 * If the input array is empty consider it as: [0] (array with a zero).
 */
public class Codewars {
    public static String oddOrEven(int[] array) {
        int sumArray = 0;

        for (int i : array) {
            sumArray += i;
        }

        if (sumArray % 2 == 0 || sumArray == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}