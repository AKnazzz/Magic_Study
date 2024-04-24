package org.ya.module_7.stream_apt.task_2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UniversityExample {

    public static void main(String[] args) {
        //множество студентов, успешно сдавших экзамен
        Set<String> examPassedNames = new HashSet<>();
        examPassedNames.add("Иванов Иван");
        examPassedNames.add("Практикумова Яна");

        //соответствие года поступления и названия группы
        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2020, "2020-ГР1");
        groupNames.put(2021, "2021-ГР0");

        //список с адресами email выпускников
        List<String> graduatesClub = new ArrayList<>();

        //студенты, планирующие завершить обучение
        List<Student> students = new ArrayList<>();
        students.add(new Student("Практикумова", "Яна", "yana@yandex.ru", 2021));
        students.add(new Student("Иванов", "Иван", "ivan_ivanov@mail.ru", 2020));
        students.add(new Student("Сергеев", "Дмитрий", "iamdmitry@gmail.com", 2021));

        // операция peek выполняет над элементом действие и передаёт далее тот же элемент

        List<Student> graduatedStudents = students.stream()
                .filter((student) -> examPassedNames.contains(student.surname + " " + student.name))  // проверка, что студент успешно сдал экзамен
                .peek((student) -> student.groupName = groupNames.get(student.entranceYear)) // заполнение названия группы студента
                .peek((student) -> graduatesClub.add(student.email)) // добавление студента в клуб выпускников
                .collect(Collectors.toList());

        for (Student student : graduatedStudents) {
            System.out.println(student);
        }

        for (String email : graduatesClub) {
            System.out.println(email);
        }


        List<Integer> inputNumbers = List.of(2, 5, 4, 2, 3, 8);
        List<Integer> evenNumbers = inputNumbers.stream()
                .filter((number) -> number % 2 == 0)
                .collect(Collectors.toList());

        for (Integer number : inputNumbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

    }
}

class Student {
    String surname;
    String name;
    String email;
    int entranceYear;
    String groupName;

    public Student(String surname, String name, String email, int entranceYear) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", entranceYear=" + entranceYear +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}