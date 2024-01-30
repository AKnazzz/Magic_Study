package org.workwork.l_tests.homework_l8;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Необходимо написать Unit тесты  на языке Java для предоставленного метода.
 * <p>
 * Метод проверяет, является ли переданное целочисленное число простым.
 * <p>
 * public static boolean isPrime(int n) {
 * if (n <= 1) {
 * return false;
 * }
 * for (int i = 2; i <= Math.sqrt(n); i++) {
 * if (n % i == 0) {
 * return false;
 * }
 * }
 * return true;
 * }
 */
public class Work1 {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testsForIsPrime() {
        assertTrue(Work1.isPrime(5));
        assertFalse(Work1.isPrime(4));
        assertFalse(Work1.isPrime(1));
        assertFalse(Work1.isPrime(-7));

        assertTrue(Work1.isPrime(2));
        assertTrue(Work1.isPrime(997));
        assertFalse(Work1.isPrime(1000));
        assertFalse(Work1.isPrime(0));
    }
}
