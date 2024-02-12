package org.workwork.d_java_core_one.homework_d5.solution;

import java.util.*;
import java.util.stream.Collectors;

class Student implements Comparable<Student> {
    String name;
    Float score;

    public int compareTo(Student other) {
        int scoreComp = other.score.compareTo(this.score);

        return scoreComp == 0 ? this.name.compareTo(other.name):scoreComp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class ResultsBoard {
    private TreeSet<Student> studentsSet;

    public ResultsBoard() {
        studentsSet = new TreeSet<>();
    }

    void addStudent(String name, Float score) {
        Student student = new Student();
        student.name = name;
        student.score = score;
        studentsSet.add(student);
    }

    List<Student> top3(int n) {
        return studentsSet.stream()
                .limit(3)
                .collect(Collectors.toList());

//        Student student = new Student();
//        student.score = (float) person;
//        NavigableSet<Student> best3 = studentsSet.descendingSet();
//        List<Student> result = new ArrayList<>(3);
//
//        for (int i = 0; i < 3; i++) {
//            if (!best3.isEmpty()) {
//                result.add(best3 .pollFirst());
//            }
//
//        }
        //  return result;


    }

    public static void main(String[] args) {
//        ResultsBoard board = new ResultsBoard();
//        board.addStudent("John", 4.5f);
//        board.addStudent("Mary", 5.0f);
//        board.addStudent("Bob", 4.2f);
//        board.addStudent("Alice", 4.8f);
//        board.addStudent("Tom", 4.9f);
//
//        List<String> top3 = board.top3();
//        System.out.println("Top 3 students:");
//        for (String name : top3) {
//            System.out.println(name);
//        }

        ResultsBoard rb = new ResultsBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3(5));        // -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3(5));        // -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3(5));        // -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3(5));        // -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3(5));        // -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]

    }
}
