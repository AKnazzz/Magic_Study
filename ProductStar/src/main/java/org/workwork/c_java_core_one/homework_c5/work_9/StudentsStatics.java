package org.workwork.c_java_core_one.homework_c5.work_9;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class StudentsStatics {
    static TreeSet<Student> studentsAvScore = new TreeSet<>();

    public static void main(String[] args) {
        StudentsStatics studentsStatics = new StudentsStatics();
        studentsStatics.addStudent("Петров", 3.5f);
        studentsStatics.addStudent("Иванов", 3.0f);
        studentsStatics.addStudent("Сидоров", 3.2f);
        studentsStatics.addStudent("Зайцев", 3.5f);
        studentsStatics.addStudent("Васин", 3.5f);
        studentsStatics.addStudent("Перов", 3.5f);
        studentsStatics.addStudent("Афонин", 2.8f);
        studentsStatics.addStudent("Борисов", 4.0f);

        System.out.println("Cписок студентов и средний балл:\n " + studentsStatics.studentsAvScore.toString());
        System.out.println("\n -------------------------------- \n");
        System.out.println("Три лучших студента:\n " + studentsStatics.top3(3));
    }

    void addStudent(String name, Float score) {
        Student student = new Student();
        student.name = name;
        student.averageScore = score;
        studentsAvScore.add(student);
    }

    TreeSet<Student> top3(int top) {

        TreeSet<Student> result = new TreeSet<>(Comparator.reverseOrder());

        List<Student> result1 = studentsAvScore.stream().toList();

        if (result1.size() > top) {
            result.add(result1.get(result1.size() - 1));
            result.add(result1.get(result1.size() - 2));
            result.add(result1.get(result1.size() - 3));
        } else {
            result.addAll(studentsAvScore);
        }

        return result;
    }

}