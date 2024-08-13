package org.workwork.c_java_core_one.homework_c5.work_12;

import java.util.*;

/**1. Написать программу для отслеживания успеваемости студентов.

 a. Каждая запись содержит имя студента и его средний балл.

 b. Реализовать структуру, которая хранит записи в порядке возрастания среднего балла.

 c. Вывести имена 3-х самых успешных студентов в порядке убывания среднего балла.*/

public class ResultsBoard {

    TreeSet<Results> student = new TreeSet<Results>();


    public ResultsBoard() {
        String name;
        Float score;
    }


    void addStudent(String name, Float score) {
        Results resultsBoard = new Results();
        resultsBoard.name = name;
        resultsBoard.score = score;
        student.add(resultsBoard);

    }

    public List<Results> top3 (){

        NavigableSet<Results> top3Results = student.tailSet(new Results(), true);
        List <Results> result = new ArrayList<>();

        Iterator<Results> descendingIterator = top3Results.descendingIterator();
        while (result.size() < 3 && descendingIterator.hasNext()) {
            result.add(descendingIterator.next());


        }

        return result;

    }


    public static void main(String[] args) {
        ResultsBoard rb = new ResultsBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3()); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3()); 		// -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3()); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3()); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3()); 		// -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]

    }

}

class Results implements Comparable<Results>{

    String name;
    double score;

    @Override
    public int compareTo(Results o) {

        return Double.compare(score, o.score);
    }

    @Override
    public String toString(){

        return "[ " + name + " - " + score + " ] " ;
    }

}