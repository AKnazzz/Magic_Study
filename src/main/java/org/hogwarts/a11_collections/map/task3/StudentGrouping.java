package org.hogwarts.a11_collections.map.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Student {
    String name;
    String faculty;
    int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(faculty,
                student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}

public class StudentGrouping {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Computer Science", 2));
        students.add(new Student("Bob", "Mathematics", 3));
        students.add(new Student("Charlie", "Computer Science", 1));
        students.add(new Student("David", "Physics", 2));

        HashMap<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(students);

        // Добавление нового студента
        students.add(new Student("Eve", "Mathematics", 1));

        // Удаление студента по имени, факультету и курсу
        removeStudent(students, "David", "Physics", 2);

        // Поиск всех студентов определённого факультета и курса
        List<Student> physicsStudents = groupedStudents.get("Physics-2");

        // Вывод списка всех студентов сгруппированных по факультетам и курсам
        for (String key : groupedStudents.keySet()) {
            System.out.println(key + ": " + groupedStudents.get(key));
        }
    }

    public static HashMap<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        HashMap<String, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            String key = student.faculty + "-" + student.year;
            if (!groupedStudents.containsKey(key)) {
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }

        return groupedStudents;
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.name.equals(name) && student.faculty.equals(faculty) && student.year == year);
    }
}
