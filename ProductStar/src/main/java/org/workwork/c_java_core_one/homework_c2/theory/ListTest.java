package org.workwork.c_java_core_one.homework_c2.theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> surnames = new ArrayList<>();
        surnames.add("Иванов");
        surnames.add("Петров");
        surnames.add("Яров");
        surnames.add("Жуков");
        surnames.add("Андреев");

        System.out.println("Неотсортированный список фамилий: " + surnames);

        Collections.sort(surnames);
        System.out.println("Отсортированный список фамилий: " + surnames);

        surnames.remove(1);
        System.out.println("Список фамилий после удаления 1й фамилии: " + surnames);


        System.out.println("==============================");

        String stt1 = "Привет";
        String stt2 = "Меня зовут Андрей";
        String stt3 = "Я изучаю Java";

        LinkedList<String> intro = new LinkedList<>();
        intro.add(stt1);
        intro.add(stt2);
        intro.add(stt3);

        System.out.println(intro);


    }
}
