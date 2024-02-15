package org.ya.module_0.task_2_1_2;

/**
 * Выведите ответ (true или false) на вопрос «64 000 мегабайт больше или равно (>=) 64 гигабайтам?». При этом учтите следующие условия:
 * Для хранения количества мегабайт используйте переменную megabytes.
 * Для хранения количества гигабайт используйте переменную gigabytes.
 * Чтобы сравнить 64 000 мегабайт и 64 гигабайта, переведите гигабайты в мегабайты и сравните их.
 * Для хранения количества мегабайт в одном гигабайте используйте переменную megabytesPerGigabyte. Один гигабайт — это 1024 мегабайта.
 * Количество мегабайт в 64 гигабайтах сохраните в переменную gigabytesToMegabytes.
 * Выполните сравнение. Результат сравнения сохраните в булеву переменную isMbMore.
 * Выведите значение переменной на экран.
 */

class Practicum {
    public static void main(String[] args) {
        int megabytes = 64000;
        int gigabytes = 64;
        int megabytesPerGigabyte = 1024;
        int gigabytesToMegabytes = gigabytes * megabytesPerGigabyte;
        boolean isMbMore = megabytes >= gigabytesToMegabytes;
        System.out.println(isMbMore);
    }
}
