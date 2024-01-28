package org.workwork.b_java_objects.homework_b7.phonebook;

import java.util.Scanner;

import static org.workwork.b_java_objects.homework_b7.phonebook.Person.findPerson;
import static org.workwork.b_java_objects.homework_b7.phonebook.Person.initBD;


public class PhoneBook {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        initBD();

        for (; ; ) {
            System.out.println("Введите 'выход' для завершения ");
            String s = in.nextLine();
            if (s.equalsIgnoreCase("выход")) {
                break;
            } else {
                System.out.println("Тогда продолжаем");
            }

            System.out.print("Для поиска по имени введите 1, по номеру 2, email 3: ");
            String searchType = in.nextLine();

            System.out.print("Введите поисковое значение: ");
            String searchString = in.nextLine();

            findPerson(searchType, searchString);
        }

    }
}

class Person {
    private String name;
    private String phone;
    private String email;
    private static Person[] persons = new Person[10];

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }

    public static void initBD() {
        persons[0] = new Person("Юля", "89210000000", "Julia@yandex.com");
        persons[1] = new Person("Сергей", "777777", "borya@yandex.com");
        persons[2] = new Person("Друган", "23566777", "univer@yandex.com");
        persons[3] = new Person("EvilBoss", "456546546", "boss@yandex.com");
        persons[4] = new Person("Anna", "+79216661666", "mylove@yandex.com");
    }

    public String toString() {
        return "\n\nName: " + this.getName() + "\nPhone number: " + this.getPhone() + "\nEmail: " +
                this.getEmail();
    }

    // поиск человека
    public static void findPerson(String searchType, String searchString) {

        switch (searchType) {
            case "1":
                //по имени
                System.out.println(findName(searchString, persons));
                break;
            case "2":
                //по телефону
                System.out.println(findPhone(searchString, persons));
                break;
            case "3":
                // по почте
                System.out.println(findEmail(searchString, persons));
                break;
            default:
                break;
        }
    }

    public static Person findName(String name, Person[] persons) {
        printEmptyException(name);
        for (Person person : persons) {
            if (person == null) continue;
            if (person.getName().equals(name)) {
                return person;
            }
        }
        System.out.println("нет такого человека");
        return null;
    }

    public static Person findPhone(String phone, Person[] persons) {
        printEmptyException(phone);
        for (Person person : persons) {
            if (person == null) continue;
            if (person.getPhone().equals(phone)) {
                return person;
            }
        }
        System.out.println("нет такого человека");
        return null;
    }

    public static Person findEmail(String email, Person[] persons) {
        printEmptyException(email);
        for (Person person : persons) {
            if (person == null) continue;
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        System.out.println("нет такого человека");
        return null;
    }

    private static void printEmptyException(String info) {
        if (info.isEmpty()) {
            System.out.println("Поиск по пустому значению невозможен");
            System.exit(0);
        }
    }

}

/*
 ДЗ
Дописать методы поиска для телефона и почты
Сделать так же выход
Продумать обработку исключений для поиска по пустым значениям

*/