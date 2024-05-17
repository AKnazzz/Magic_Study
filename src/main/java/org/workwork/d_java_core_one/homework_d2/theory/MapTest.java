package org.workwork.d_java_core_one.homework_d2.theory;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {
    public static void main(String[] args) {
        // ключ - это называние главы из книги
        // значение - это номер страницы
        HashMap<String, Integer> chaptersAndPages = new HashMap<>();

        // добавляем данные
        chaptersAndPages.put("Chapter 1", 1);
        chaptersAndPages.put("Chapter 2", 2);
        chaptersAndPages.put("Chapter 3", 3);

        // выводим данные
        System.out.println("HashMap: " + chaptersAndPages);

        // проверяем наличие ключа
        System.out.println(chaptersAndPages.containsKey("Chapter 1"));

        // проверяем наличие значения
        System.out.println(chaptersAndPages.containsValue(2));

        // выводим количество записей
        System.out.println(chaptersAndPages.size());

        // проверяем есть ли элементы в коллекции
        System.out.println(chaptersAndPages.isEmpty());


        System.out.println("====================================");

        LinkedHashMap<String, Integer> chaptersAndPages2 = new LinkedHashMap<>();

        chaptersAndPages2.put("Chapter 3", 3);
        chaptersAndPages2.put("Chapter 1", 1);
        chaptersAndPages2.put("Chapter 2", 2);

        // данные выведутся в порядке добавления
        System.out.println("LinkedHashMap: " + chaptersAndPages2);
    }

}
