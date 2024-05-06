package org.workwork.d_java_core_one.homework_d5.work_8;

import java.util.Comparator;
import java.util.TreeSet;

public class Students {

    TreeSet<ResultsBoard> studentsAvScore = new TreeSet<>();

    void addStudent(String name, Float score) {
        ResultsBoard student = new ResultsBoard();
        student.name = name;
        student.averageScore = score;
        studentsAvScore.add(student);

    }

    TreeSet<ResultsBoard> top3(int top) {

        TreeSet<ResultsBoard> result = new TreeSet<>(Comparator.reverseOrder());


        for (int i = 0; i < top; i++) {

            result.add(studentsAvScore.pollLast());

        }
        return result;
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.addStudent("Петров", 3.5f);
        students.addStudent("Иванов", 3.0f);
        students.addStudent("Сидоров", 3.2f);
        students.addStudent("Зайцев", 2.8f);
        students.addStudent("Васин", 3.5f);
        students.addStudent("Перов", 2.5f);
        students.addStudent("Афонин", 2.8f);
        students.addStudent("Борисов", 4.0f);
        students.addStudent("Ivan", 3.0f);
        students.addStudent("Maria", 4.2f);
        students.addStudent("Oleg", 4.5f);

        System.out.println("Cписок студентов и средний балл:\n " + students.studentsAvScore.toString());
        System.out.println("\n -------------------------------- \n");
        System.out.println("Три лучших студента:\n " + students.top3(3));
    }

}