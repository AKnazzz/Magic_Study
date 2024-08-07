package org.workwork.b_java_objects.homework_b6.homework_b6_4.homework.task1;

public class StringAndRegex {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        String text = "В тексте, который вы видите на этом изображении, " +
                "посчитайте количество букв 'е' в каждом слове";
        char symbol = 'е';

        String[] words = text.split(" ");
        for (String word : words) {
            word = replaceSymbol(word);
            int result = countLetter(word, symbol);
            System.out.println("------------------------------");
            printCountLetter(word, result, symbol);
        }
    }

    private static String replaceSymbol(String word) {
        word = word.replace(',', ' ');
        word = word.replace('\'', ' ');
        word = word.trim();
        return word;
    }

    private static void printCountLetter(String word, int result, char symbol) {
        StringBuilder sb = new StringBuilder();
        sb.append("В слове: ")
                .append(word)
                .append("  - ")
                .append(result)
                .append(" ")
                .append("букв ")
                .append("'")
                .append(symbol)
                .append("'");

        System.out.println(sb);
    }

    private static int countLetter(String word, char symbol) {
        int countLetter = 0;
        int indexSymbol = 0;
        int length = word.length();
        while (length > indexSymbol) {
            if (word.charAt(indexSymbol) == symbol) {
                countLetter++;
            }
            indexSymbol++;
        }
        return countLetter;
    }

}
