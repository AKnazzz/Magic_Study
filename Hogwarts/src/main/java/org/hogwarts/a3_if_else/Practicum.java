package org.hogwarts.a3_if_else;

import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Объявите переменные и сразу присвойте им значение:
        - rateUSD (курс доллара)
        - rateEUR (курс евро)
        - rateCNY (курс юаня)
         */
        double rateUSD = 73.50; // курс доллара
        double rateEUR = 89.20; // курс евро
        double rateCNY = 11.30; // курс юаня

        //NumberReader.getInteger();

        System.out.println("Введите сумму рублей для конвертации:");
        /* Ввод суммы рублей для конвертации
           Сохраните введённое значение в переменную "roubles"
         */
        double roubles = scanner.nextDouble(); // Пример введенной суммы в рублях

        System.out.println("Введите номер валюты, в какую перевести рубли:");
        System.out.println("1 – доллары;");
        System.out.println("2 – евро;");
        System.out.println("3 – юани;");


        /* Ввод номера команды
           Сохраните введенное значение в переменную "command" */

        int command = scanner.nextInt();

        double result;

        if (command == 1) {
            result = roubles / rateUSD;
            if (result < 0) {
                System.out.println("Ошибка: некорректные значения.");
            } else {
                System.out.println("Было введено " + roubles + ", в долларах это " + result);
            }
        } else if (command == 2) {
            result = roubles / rateEUR;
            if (result < 0) {
                System.out.println("Ошибка: некорректные значения.");
            } else {
                System.out.println("Было введено " + roubles + ", в евро это " + result);
            }
        } else if (command == 3) {
            result = roubles / rateCNY;
            if (result < 0) {
                System.out.println("Ошибка: некорректные значения.");
            } else {
                System.out.println("Было введено " + roubles + ", в юани это " + result);
            }
        } else {
            System.out.println("Такой команды нет.");
        }

        System.out.println("Работа с программой завершена.");
    }
    // Вывод сообщения о завершении работы программы
}