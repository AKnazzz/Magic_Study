package org.hogwarts.strings;

import java.util.Random;

/**
 * 1. Создайте строку из 5 случайных чисел new Random().nextInt().
 * 2. Замените все единицы на символ ‘i’.
 * 3. У получившейся строки уберите все символы ‘-’
 * 4. У получившейся строки замените все нули на символ ‘o’.
 * 5. У получившейся строки замените все шестерки на символ ‘b’.
 * 6. Выведите результат в консоль.
 * 7. Узнайте, содержится ли подстрока “23” у получившейся строки.
 * 8. Узнайте индекс подстроки “ob”.
 */

public class Task_String_1 {
    public static void main(String[] args) {

        //Создайте строку из 5 случайных чисел new Random().nextInt().

        int[] randomNumbers = new int[5];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt();
            sb.append(randomNumbers[i]);
        }
        String randomNumbersString = sb.toString();
        System.out.println(randomNumbersString);

        //Замените все единицы на символ ‘i’.
        randomNumbersString = randomNumbersString.replaceAll("1", "i");
        System.out.println(randomNumbersString);

        //У получившейся строки уберите все символы ‘-’
        randomNumbersString = randomNumbersString.replaceAll("-", "");
        System.out.println(randomNumbersString);

        //У получившейся строки замените все нули на символ ‘o’.
        randomNumbersString = randomNumbersString.replaceAll("0", "o");
        System.out.println(randomNumbersString);

        //У получившейся строки замените все шестерки на символ ‘b’.
        randomNumbersString = randomNumbersString.replaceAll("6", "b");
        System.out.println(randomNumbersString);

        //Узнайте, содержится ли подстрока “23” у получившейся строки.
        if (randomNumbersString.contains("23")) {
            System.out.println("Строка содержит подстроку '23'");
        } else {
            System.out.println("Строка не содержит подстроку '23'");
        }

        //Узнайте индекс подстроки “ob”.
        int index = randomNumbersString.indexOf("ob");
        System.out.println("Индекс подстроки 'ob' равен " + index);
    }
}
