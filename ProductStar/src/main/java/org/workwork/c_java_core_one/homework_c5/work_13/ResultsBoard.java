package org.workwork.c_java_core_one.homework_c5.work_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultsBoard {

    private TreeMap<Float, List<String>> studentScores;

    public ResultsBoard() {
        studentScores = new TreeMap<>();
    }

    public void addStudent(String name, Float score) {
        if (!studentScores.containsKey(score)) {
            studentScores.put(score, new ArrayList<>());
        }
        studentScores.get(score).add(name);
    }

    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();

        for (Map.Entry<Float, List<String>> entry : studentScores.descendingMap().entrySet()) {
            for (String student : entry.getValue()) {
                topStudents.add(student);
                if (topStudents.size() == 3) {
                    return topStudents;
                }
            }
        }

        return topStudents;
    }

    public static void main(String[] args) {
        ResultsBoard rb = new ResultsBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3()); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3());		// -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3());		// -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3());	// -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3());		// -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]

//        List<String> topStudents = rb.top3();
//        System.out.println("Топ-3 студента:");
//        for (String student : topStudents) {
//            System.out.println(student);
//        }
    }
}