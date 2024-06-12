package org.ya.module_0.task_2_3_2;

/**
 * Исправьте программу так, чтобы рекомендация по покупке долларов печаталась, только если курс меньше 70.
 * Не забудьте проверить, что всё работает — поменяйте значение курса и убедитесь, что программа может дать вам совет.
 */

class Praktikum {
    public static void main(String[] args) {

        double rateUSD = 78.5;
        double rubles = 14356.5;

        if (rateUSD < 70) {
            System.out.println("Отличный курс доллара — рекомендую купить!");
        }

        System.out.println("Ваши сбережения в долларах: " + rubles / rateUSD);
    }
}