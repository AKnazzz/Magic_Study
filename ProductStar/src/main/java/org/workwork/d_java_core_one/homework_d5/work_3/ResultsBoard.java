package org.workwork.d_java_core_one.homework_d5.work_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class ResultsBoard {
    StudentComaparator sorting = new StudentComaparator();
    TreeMap<String, Float> nameAndScore = new TreeMap<>();
    TreeSet<Stud> allStudents = new TreeSet<>(sorting);

    public static void main(String[] args) {
        ResultsBoard rb = new ResultsBoard();


        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3Stud(3));        // -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3Stud(3));        // -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3Stud(3));        // -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3Stud(3));        // -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3Stud(3));        // -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]
    }

    public void addStudent(String name, Float grade) {
        Stud student = new Stud();
        student.name = name;
        student.grade = grade;
        nameAndScore.put(student.name, student.grade);
        allStudents.add(student);

    }

    List<String> top3Stud(int n) throws NullPointerException {
        if (n < 0) {
            throw new NegativeArraySizeException();
        }
        if (n > allStudents.size()) {
            n = allStudents.size();
        }
        List<Stud> sort = new ArrayList<>(allStudents);
        Collections.sort(sort, new StudentComaparator());

        List<String> topNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            topNames.add(sort.get(i).name);
        }

        return topNames;
    }
}

class Stud {
    String name;
    Float grade;

    public Stud(String name, Float grade) {
        this.name = name;
        this.grade = grade;
    }


    public Stud() {

    }

    @Override
    public String toString() {
        return "Student -" +
                "name -" + name +
                "- grade = " + grade;
    }


}

class StudentComaparator implements Comparator<Stud> {

    @Override
    public int compare(Stud st1, Stud st2) {
        int res = st1.grade.compareTo(st2.grade);

        if (res > 0) {
            return -1;
        } else if (st1.name.compareTo(st2.name) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}