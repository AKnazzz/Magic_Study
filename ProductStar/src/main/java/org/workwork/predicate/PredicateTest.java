package org.workwork.predicate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    public static void main(String[] args) {


        /** 1. Пример 1: Фильтрация по условию */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Пример предиката: фильтрация только четных чисел
        Predicate<Integer> evenNumbers = num -> num % 2 == 0;

        List<Integer> evenList = numbers.stream()
                .filter(evenNumbers)
                .collect(Collectors.toList());

        System.out.println(evenList); // Выводит [2, 4, 6, 8, 10]


        /**2. Пример 2: Комбинирование предикатов */

        Predicate<String> startsWithA = str -> str.startsWith("A");
        Predicate<String> endsWithO = str -> str.endsWith("o");

        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Kiwi", "Orange");

        // Комбинирование предикатов с помощью метода and()
        List<String> filteredWords = words.stream()
                .filter(startsWithA.and(endsWithO))         // <--- and
                .collect(Collectors.toList());

        System.out.println(filteredWords);                  // Выводит [Avocado]


        /** 3. Пример 3: Использование negate() для инвертирования предиката */

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Kiwi");

        Predicate<String> notBanana = Predicate.not(str -> str.equals("Banana"));

        List<String> filteredFruits = fruits.stream()
                .filter(notBanana)
                .collect(Collectors.toList());

        System.out.println(filteredFruits); // Выводит [Apple, Orange, Kiwi]


        Predicate<String> banana = str -> str.equals("Banana");

        List<String> filteredFruits2 = fruits.stream()
                .filter(banana.negate())
                .toList();

        System.out.println("31 = " + filteredFruits); // Выводит [Apple, Orange, Kiwi]
        System.out.println("32 = " + filteredFruits2); // Выводит [Apple, Orange, Kiwi]


        /** 4. Пример 4 использования Predicate для фильтрации объектов по полю */

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));

        Predicate<Person> agePredicate = person -> person.getAge() > 25;

        // Фильтрация списка людей по предикату
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            if (agePredicate.test(person)) {
                filteredPeople.add(person);
            }
        }

        // Вывод результатов
        for (Person person : filteredPeople) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

        /** 5. Пример использования Predicate для фильтрации HashMap: */

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Predicate<Map.Entry<Integer, String>> keyPredicate = entry -> entry.getKey() > 1;

        // Фильтрация HashMap по предикату
        map.entrySet().removeIf(keyPredicate.negate());

        // Вывод результатов
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        /** 6. Запись в функцию */

        class PredicateInterfaceExample3 {
            static void pred(int number, Predicate<Integer> predicate) {
                if (predicate.test(number)) {
                    System.out.println("Number " + number);
                }
            }
        }

        PredicateInterfaceExample3.pred(10, (i) -> i > 7); // <--  main просто в аргумет вставляем нашу реализацию
        PredicateInterfaceExample3.pred(6, (i) -> i > 5);


        /** 7. Предикат ИЛИ */

        class PredicateInterfaceExample4 {
            public static Predicate<String> hasLengthOf10 = new Predicate<String>() {

                @Override
                public boolean test(String t) {
                    return t.length() > 10;
                }
            };

            public static void predicate_or() {

                Predicate<String> containsLetterA = p -> p.contains("A");
                // Predicate<String> hasLengthOf10 = t -> t.length() > 10;
                String containsA = "And";
                boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
                System.out.println(outcome);
            }

        }
        PredicateInterfaceExample4.predicate_or();


        /** 8. Предикат И */

        class PredicateInterfaceExample5 {
            public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
                @Override
                public boolean test(String t) {
                    return t.length() > 10;
                }
            };

            public static void predicate_and() {
                Predicate<String> nonNullPredicate = Objects::nonNull;

                String nullString = null;

                boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
                System.out.println(outcome);

                String lengthGTThan10 = "Welcome to the machine";
                boolean outcome2 = nonNullPredicate.and(hasLengthOf10).test(lengthGTThan10);
                System.out.println(outcome2);
            }


        }
        PredicateInterfaceExample5.predicate_and();


    }
}
