package org.workwork.b_java_objects.homework_b6.homework_b6_2;

import java.util.*;
import java.lang.*;

public class Main {

    private static void letterFinder (String str, char letter) {
        String[] words = str.split(" ");
        int letterCount;
        String endLetter;
        for (int i = 0; i < words.length; i++) {
            letterCount = 0;
            words[i] = words[i].replaceAll("[\\n,0-9]", "");
            for (int j = 0; j < words[i].length(); j++) {if (words[i].charAt(j) == letter) {letterCount++;}}
            if ((letterCount == 0)||(letterCount > 4)) {endLetter = "";}
            else if (letterCount == 1) {endLetter = "а";}
            else endLetter = "ы";
            System.out.println("В слове '" + words[i] + "' " + letterCount + " букв" + endLetter + " '"+ letter + "'.");
        }
    }

    private static boolean checkIntPhoneNumber (String str) {
        String regex = "^[+]+[0-9]{10,15}$";
        return str.matches(regex);
    }

    private static String deleteLettersAndSpaces (String str) {
        String regex = "[a-zA-Zа-яёА-ЯЁ\\s]";
        return str.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yesOrNo;

        String s = "Домашнее задание\n" +
                "1 В тексте, который вы видите на этом слайде, посчитайте количество букв ‘е’ в каждом слове\n" +
                "2 Напишите регулярное выражение для проверки телефона в международном формате\n" +
                "3 С помощью регулярного выражения напишите функцию удаления всех букв и пробелов из текста";
        char letter = 'е';
        letterFinder(s, letter);

        do {
            System.out.println("Введите номер телефона в международном формате:");
            String phoneNumber = sc.nextLine();
            if (checkIntPhoneNumber(phoneNumber)) {System.out.println("Номер верен");}
            else {System.out.println("Номер неверен");}
            do {
                System.out.print("Повторить? (y/n)");
                yesOrNo = sc.nextLine();}
            while ((!yesOrNo.equals("y"))&&(!yesOrNo.equals("n")));}
        while (yesOrNo.equals("y"));

        do {
            System.out.println("Удаляем все буквы и пробелы из строки:");
            System.out.println(deleteLettersAndSpaces(s));
            do {
                System.out.print("Повторить? (y/n)");
                yesOrNo = sc.nextLine();}
            while ((!yesOrNo.equals("y"))&&(!yesOrNo.equals("n")));
            if (yesOrNo.equals("y")) {
                System.out.println("Введите новую строку:");
                s = sc.nextLine();}
        }
        while (yesOrNo.equals("y"));

        sc.close();
    }
}