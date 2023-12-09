package org.hogwarts.regEx.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Найти в тексте все слова с А или с а
 * 2. Все цифры в тексте заменить на символы #
 * 3. Проверить является ли строка URL
 *
 */

//           \\d  - одна цифра
//           \\D  - одна НЕ цифра
//           \\w  - одна буква, цифра или "_"
//           \\W  - одна НЕ буква, НЕ цифра и НЕ "_"
//           \\s  - один пробел
//           \\S  - один НЕ пробел
//
//           \\A  - выражение в начале Stringa
//           \\Z  - выражение в конце Stringa
//           \\b  - граница слова или числа
//           \\B  - граница НЕ слова и НЕ числа
//           +    - один или более (\\d+ - одно или более цифр)
//           *    - ноль или более (\\d* - ноль или более цифр)  положительных!
//           -    - если минус перед выражением - указывает что отрицательное
//           ?    - ноль или один символов до (-?\\d* - значит символ минус "-" может как быть так и не быть)
//           {n}  - n повторений
//           {m,n}  - от m до n повторений
//           {n,}   - n и более повторений
public class TaskRegEx1 {

    public static void main(String[] args) {
        String text = "Anna and Alexey like to eat apples, but Alice prefers oranges.";
//      String text = "Анна и Алексей любят есть яблоки, но Алиса предпочитает апельсины.";
        Pattern pattern = Pattern.compile("\\b\\w*[aA]\\w*\\b");
//      Pattern pattern2 = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }

}
