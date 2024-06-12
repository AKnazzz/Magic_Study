package org.hogwarts.regEx.task;

import java.util.regex.Pattern;

/**
 * 1. Найти в тексте все слова с А или с а
 * 2. Все цифры в тексте заменить на символы #
 * 3. Проверить является ли строка URL
 */
public class TaskRegEx3 {
    public static void main(String[] args) {
        String url1 = "https://www.example.com";
        String url2 = "123https://www.example.com";
        String url3 = "https://example.com";

        TaskRegEx3 task = new TaskRegEx3();
        task.checkURL(url1);
        task.checkURL(url2);
        task.checkURL(url3);


    }

    void checkURL(String url) {
        String regEx = "\\bhttps?://www\\.[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*\\b";
        System.out.println(url + " is OK? " + Pattern.matches(regEx, url));
    }
}