package org.hogwarts.a11_collections.task;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20, "Magic", new String[]{"Flying", "Invisibility"}));
        students.add(new Student("Bob", 22, "Alchemy", new String[]{"Transmutation", "Potions"}));
        students.add(new Student("Charlie", 18, "Divination", new String[]{"Prophecy", "Tarot"}));

        System.out.println("Сортировка по возрасту:");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }

        System.out.println("\nСортировка по имени:");
        Collections.sort(students, new NameComparator());
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getFaculty());
        }

        System.out.println("\nСортировка по факультету (по убыванию):");
        Collections.sort(students, new FacultyComparator());
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getFaculty());
        }
    }
}