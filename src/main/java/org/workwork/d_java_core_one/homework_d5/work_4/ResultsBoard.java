package org.workwork.d_java_core_one.homework_d5.work_4;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class ResultsBoard {
    TreeSet<Student> studentsSet = new TreeSet<>();

    public ResultsBoard() {


    }

    void addStudent(String name, Float score) {
        Student student = new Student();
        student.name = name;
        student.score = score;
        studentsSet.add(student);
    }

    List<Student> top3(int person) {
        Student student = new Student();
        student.score = (float) person;
        NavigableSet<Student> best3 = studentsSet.descendingSet();
        List<Student> result = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            if (!best3.isEmpty()) {
                result.add(best3.pollFirst());
            }
        }
        return result;
    }





    public static void main(String[] args) {
//        ResultsBoard resultsBoard = new ResultsBoard();
//        resultsBoard.addStudent("Иван", 3.2f);
//        resultsBoard.addStudent("Саша", 1.2f);
//        resultsBoard.addStudent("Маша", 5.0f);
//        resultsBoard.addStudent("Наташа", 4.4f);
//        resultsBoard.addStudent("Сема", 2.7f);
//        resultsBoard.addStudent("Боря", 3.8f);
//        resultsBoard.addStudent("Атабек", 1.9f);
//        System.out.println(resultsBoard.studentsSet);
//        System.out.println(resultsBoard.top3(3));

        ResultsBoard rb = new ResultsBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        rb.addStudent("Oleg", 4.0f);
        System.out.println(rb.top3(5)); 		// -> [Maria, Ivan]
        System.out.println(rb.top3(5)); 		// -> [Maria, Ivan]
        System.out.println(rb.top3(5)); 		// -> [Maria, Ivan]
        System.out.println(rb.top3(5)); 		// -> [Maria, Ivan]
        System.out.println(rb.top3(5)); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3(5)); 		// -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3(5)); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3(5)); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3(5)); 		// -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]
    }


}

class Student implements Comparable<Student> {
    String name;
    Float score;

    @Override
    public int compareTo(Student student) {
        return Float.compare(score, student.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}