package org.hogwarts.a11_collections.list.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите метод public static List<String> transform(List<String> words), который удалит у переданного списка все пустые слова,
 * т.е. те слова, для которых words.get(i).equals(””) вернёт true.
 *
 * Вам пригодятся все знания, полученные на прошлых уроках. Циклы, сравнения, методы коллекций — пригодится все.
 * Здесь придется подумать. В случае затруднения, попробуйте порисовать ручкой на бумаге, чтобы понять, что нужно сделать, чтобы решить эту задачу.
 */


public class Transformer {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("", "a", "b", "ab", "ba", "z", "h", "", "heh", "")
        );

        System.out.println(transform(list)); // [a, b, ab, ba, z, h, heh]
    }

    public static List<String> transform(List<String> words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (!word.equals("")) {
                result.add(word);
            }
        }

        return result;
    }
}
