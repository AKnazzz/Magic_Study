package org.hogwarts.regEx.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1. Сгруппировать все слова по алфавиту (независимо от размера буквы)
 * 2. Отсутствовать дубликаты и символы
 */
public class TaskRegEx6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Андрей\\dev\\magic\\Magic\\textForRegEx.txt"));


        ArrayList<String> allWords = new ArrayList<>();

        String theBiggestWord = "";
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            String cleanString = word.replaceAll("(—|«|»|\\.|-|,|\\(|\\)|;)", "");
            String[] words = cleanString.split(" ");

            for (int i = 0; i < words.length; i++) {
                allWords.add(words[i]);
                if (words[i].length() > theBiggestWord.length()) {
                    theBiggestWord = words[i];
                }
            }
        }


        System.out.println("Самое длинное слово в тексте: " + theBiggestWord);
        System.out.println("========================================");
        System.out.println("Полный список слов в тексте" + allWords);

        // Сортировка всех слов по алфавиту независимо от регистра букв
        Collections.sort(allWords, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Сортировка всех слов по алфавиту: " + allWords);

        // Удаление дубликатов и символов, группировка по алфавиту
        Set<String> uniqueWords = new TreeSet<>();
        for (String word : allWords) {
            String cleanWord = word.replaceAll("[^а-яА-Я]+", ""); // удалить все символы
            if (!cleanWord.isEmpty()) { // проверить, что строка не пустая после удаления символов
                uniqueWords.add(cleanWord.toLowerCase()); // добавить в TreeSet, приведя к нижнему регистру
            }
        }
        List<String> result = new ArrayList<>(uniqueWords);
        System.out.println("Уникальные слова без символов и отсортированные по алфавиту: " + result);
    }
}
