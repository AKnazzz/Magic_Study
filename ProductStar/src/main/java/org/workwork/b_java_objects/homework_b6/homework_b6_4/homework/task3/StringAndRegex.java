package org.workwork.b_java_objects.homework_b6.homework_b6_4.homework.task3;

public class StringAndRegex {
    public static void main(String[] args) {
        String regex = "[а-яА-Я ]+";
        String text = "1В тексте , который вы видите на этом изображении №2, " +
                "посчитайте() количество букв 'е' в каждом слове+";

        String result = matches(text, regex);
        print(result);
    }

    private static void print(String result) {
        System.out.println(result);
    }

    private static String matches(String text, String regex) {
        return text.replaceAll(regex, "");
    }
}
