package org.let.task_faang_2;

/**
 * Вторая задача — Максимальное среднее значение
 * <p>
 * Дан целочисленный массив nums, состоящий из n элементов, и целое число k.
 * Найдите непрерывный подмассив длиной k, имеющий максимальное среднее значение, и верните это значение.
 * Подмассив — это последовательность чисел без изменения порядка или пропуска элементов исходного массива.
 */

public class MaxAverageSubarray {

    // префиксные суммы
    public double findMaxAverage(int[] nums, int k) {
        int[] sums = new int[nums.length]; // массив сумм для каждого элемента
        sums[0] = nums[0]; // первый элемент массива ПРЕФИКСНЫЕ суммы
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i]; // сумма элементов массива
        }

        double res = sums[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sums[i] - sums[i - k]) * 1.0 / k);
        }
        return res;
    }
    /*
    Оценка сложности:
    Time complexity:   O(n+n) = O(n)
    Space complexity: O(n)
     */



    // плавающее окно

    public double findMaxAverage2(int[] nums, int k) {
        double sum = 0;  //сумма элементов массива
        for (int i = 0; i < k; i++) {
            sum += nums[i]; //сумма элементов массива
        }
        double result = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            result = Math.max(sum, result);
        }
        return result / k;
    }

        /*
    Оценка сложности:
    Time complexity:  O(n)
    Space complexity: O(1)
     */

}
