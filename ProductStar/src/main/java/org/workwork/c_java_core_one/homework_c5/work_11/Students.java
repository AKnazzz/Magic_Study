package org.workwork.c_java_core_one.homework_c5.work_11;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;


public class Students {


    TreeSet<ResultsBoard> student = new TreeSet<>();


    public Students() {
        String name;
        String surname;
        double score;
    }


    void addStudent(String name, String surname, Double score) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.name = name;
        resultsBoard.surname = surname;
        resultsBoard.score = score;
        student.add(resultsBoard);

    }


    List<ResultsBoard> top3() {
        ResultsBoard o = new ResultsBoard();

        NavigableSet<ResultsBoard> top3SResultsBoards = student.tailSet(o, true);

        List<ResultsBoard> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            if (!top3SResultsBoards.isEmpty()) {
                result.add(top3SResultsBoards.pollLast());
            }
        }

        return result;

    }


    public static void main(String[] args) {

        Students students = new Students();
        students.addStudent("Ivanov", "Igor", 3.0);
        students.addStudent("Petrov", "Igor", 4.0);
        students.addStudent("Sidorov", "Igor", 5.0);
        students.addStudent("Nikiforov", "Igor", 2.0);
        students.addStudent("Petik", "Igor", 3.5);
        students.addStudent("Svetik", "Igor", 4.2);

        System.out.println(students.student);
        System.out.println("=================");
        System.out.println(students.top3());

    }

}

class ResultsBoard implements Comparable<ResultsBoard> {

    String name;
    String surname;
    double score;

    @Override
    public int compareTo(ResultsBoard o) {

        return Double.compare(score, o.score);
    }

    @Override
    public String toString() {

        return "[ " + name + " - " + surname + " - " + score + " ] ";
    }

}