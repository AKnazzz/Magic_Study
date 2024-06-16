package org.workwork.b_java_objects.homework_b6.solution;

public class Task_1_1 {
    public static void main(String[] args) {
        String text = "В тексте, который вы видите на этом слайде, посчитайте количество букв ‘е’ в каждом слове.";
        countLetterEInWords(text);
    }

    public static void countLetterEInWords(String text) {
        String[] words = text.split("\\s+");

        for (String word : words) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.toLowerCase(word.charAt(i)) == 'е') {
                    count++;
                }
            }
            System.out.println("Слово: " + word + ", количество букв 'е': " + count);
        }
    }
}
