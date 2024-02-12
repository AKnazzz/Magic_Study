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
        if (name != null && score != null) {
            Student student = new Student();
            student.name =name;
            student.score = score;
            studentsSet.add(student);
        } else {
            System.out.println("Name is null.");
        }
    }

//    List<Student> top3(int person) {
//        Student student = new Student();
//        student.score = (float) person;
        NavigableSet<Student> best3 = studentsSet.descendingSet();
//        List<Student> result = new ArrayList<>(3);
//
//        for (int i = 0; i < 3; i++) {
//            if (!best3.isEmpty()) {
//                result.add(best3 .pollFirst());
//            }
//
//        }
//        return result;
//    }





    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Иван", 3.2f);
        resultsBoard.addStudent("Саша", 1.2f);
        resultsBoard.addStudent("Маша", 5.0f);
        resultsBoard.addStudent("Наташа", 4.4f);
        resultsBoard.addStudent("Сема", 2.7f);
        resultsBoard.addStudent("Боря", 4.4f);
        resultsBoard.addStudent("Атабек", 1.9f);
        System.out.println(resultsBoard.studentsSet);
      //  System.out.println(resultsBoard.top3(0));
    }


}

class Student implements Comparable<Student> {
    String name;
    Float score;

    @Override
    public int compareTo(Student student) {

        int baliSravnen = Float.compare(score, student.score);
        if (baliSravnen != 0) {
            return baliSravnen;
        }else {
            return name.compareTo(student.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}