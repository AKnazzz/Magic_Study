package org.workwork.c_java_core_one.homework_c2.theory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {

        System.out.println("================== HashSet ==================");
        HashSet<String> countries = new HashSet<>();

        //добавляем элементы методом add()
        countries.add("China");
        countries.add("USA");
        countries.add("Japan");
        countries.add("China");

        //вывод элементов в консоль
        System.out.println(countries);
        System.out.println("countries contains China: " + countries.contains("China")); // проверка на наличие элемента

        //удаление элементов методом remove()
        countries.remove("Japan");
        System.out.println("countreies after remove Japan: " + countries);


        //вывод элементов в консоль
        System.out.println("Iterating over countries:");
        for (String country : countries) {
            {
                System.out.println(country);
            }
        }

        System.out.println("=============== LinkedHashSet =====================");

        //добавляем элементы методом add()
        LinkedHashSet<String> countries2 = new LinkedHashSet<>();
        countries2.add("China");
        countries2.add("USA");
        countries2.add("Japan");
        countries2.add("Russia");

        //явно получяем итератор
        Iterator<String> it = countries2.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }


        System.out.println("==================== TreeSet ======================");

        TreeSet<String> numbers = new TreeSet<>();

        //добавляем элементы методом add()
        numbers.add("10");
        numbers.add("-5");
        numbers.add("1");
        numbers.add("-2");
        numbers.add("-1002");
        numbers.add("565656");

        System.out.println("numbers: " + numbers);
        System.out.println(numbers.first()); // наименьший элемент
        System.out.println(numbers.last()); // наибольший элемент
    }
}
