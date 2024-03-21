package org.workwork;

import java.util.*;

public class ResultsBoard {
    static TreeSet<Students> StudentScore = new TreeSet<>();
    static TreeSet<Students2> StudentScore2 = new TreeSet<Students2>();

    public static void main(String[] args) {

        ResultsBoard resultsBoard = new ResultsBoard();
        String name;
        Float score;

        resultsBoard.addStudent("Ivan", 2.7f);
        resultsBoard.addStudent("Ilya", 3.7f);
        resultsBoard.addStudent("Ira", 4.7f);
        resultsBoard.addStudent("Yla", 5.7f);
        resultsBoard.addStudent("Pop", 1.7f);
        ResultsBoard();
        top3();
    }

    private static void top3() {

        List<String> NameScore3 = new ArrayList<>();
        int i = 0;

        for (Students2 students2:StudentScore2){

            NameScore3.add(students2.name);

            i++;
            if (i==3){
                System.out.println(NameScore3);

                break;
            }
        }
    }

    void addStudent(String name, Float score) {
        Students students = new Students();
        Students2 students2 = new Students2();

        students.name = name;
        students.score = score;

        StudentScore.add(students);

        students2.name = name;
        students2.score= score;

        StudentScore2.add(students2);
    }

    public static void ResultsBoard() {

        System.out.println(StudentScore);
    }

    class Students implements Comparable<Students> {
        String name;
        float score;

        @Override
        public int compareTo(Students o) {

            if (score == o.score) {
                return 0;
            } else if (score > o.score) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    class Students2 implements Comparable<Students2> {

        Float score;
        String name;

        @Override
        public int compareTo(Students2 o) {

            if (score == o.score) {
                return 0;
            } else if (score > o.score) {
                return -1;
            } else {
                return 1;
            }

        }

    }
}