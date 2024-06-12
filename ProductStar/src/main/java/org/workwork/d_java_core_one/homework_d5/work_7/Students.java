package org.workwork.d_java_core_one.homework_d5.work_7;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Students {
    TreeSet<ResultsBoard> studentsAvScore = new TreeSet<ResultsBoard>();

    public static void main(String[] args) {
        Students students = new Students();
        students.addStudent("Петров", 3.5f);
        students.addStudent("Иванов", 3.0f);
        students.addStudent("СИдоров", 3.6f);
//        students.addStudent("Сидоров", 3.2f);
//        students.addStudent("Зайцев", 4.8f);
//        students.addStudent("Зайцев2", 4.8f);
//        students.addStudent("Васин", 3.5f);
//        students.addStudent("Перов", 4.5f);
//        students.addStudent("Афонин", 4.8f);
//        students.addStudent("Борисов", 3.6f);
        System.out.println("Cписок студентов и средний балл:\n " + students.studentsAvScore.toString());
        System.out.println("\n -------------------------------- \n");
        System.out.println("Три лучших студента:\n " + students.top3(3));
    }

    void addStudent(String name, Float score) {
        ResultsBoard student = new ResultsBoard();
        student.name = name;
        student.averageScore = score;
        studentsAvScore.add(student);
    }

    List<String> top3(int top) {

        List<String> result = new ArrayList<>(top);

        for (int i = 0; i < top; i++) {

            result.add(String.valueOf(studentsAvScore.pollLast().name));

        }
        return result;
    }

    class ResultsBoard implements Comparable<ResultsBoard> {

        float averageScore;
        String name;

        @Override
        public int compareTo(ResultsBoard o) {
            if (averageScore == o.averageScore) {
                return Float.compare(o.averageScore, averageScore);
            } else {
                return Float.compare(averageScore, o.averageScore);
            }
        }

        @Override
        public String toString() {
            return "[" + name + " - " + averageScore + "]";

        }
    }
}