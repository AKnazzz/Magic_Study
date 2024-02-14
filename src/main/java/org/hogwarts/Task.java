package org.hogwarts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Task {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Андрей\\dev\\magic\\Magic\\textForRegEx.txt")));
//        TreeMap<Character, Integer> letter = new TreeMap<>();
//
//        while (br.ready()) {
//            String words = br.readLine().toLowerCase();
//            for (int i = 0; i < words.length(); i++) {
//                char ch = words.charAt(i);
//                letter.put(ch, letter.getOrDefault(ch, 0) + 1);
//            }
//        }
//        letter.entrySet().forEach(System.out::println);

        for (int i = 'а'; i <= 'я' ; i++) {
            System.out.println(i + " " + (char)i);
        }
        System.out.println();
        System.out.println((int)'ё');
    }
}
