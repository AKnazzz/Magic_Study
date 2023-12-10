package org.hogwarts.regEx.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1. Сгруппировать все слова по алфавиту (независимо от размера буквы)
 * 2. Отсутствовать дубликаты и символы
 */
public class TaskRegEx6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Андрей\\dev\\magic\\Magic\\textForRegEx.txt"));

        String theBiggestWord = "";
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            String cleanString = word.replaceAll("(—|«|»|\\.|-|,|\\(|\\)|;)", "");
            String[] words = cleanString.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > theBiggestWord.length()) {
                    theBiggestWord = words[i];
                }
            }
        }
        System.out.println(theBiggestWord);
    }
}
