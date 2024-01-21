package org.workwork.d_java_core_one.homework_d5.work_3;

import java.util.*;

public class ResultsBoard {


    TreeMap<String, Float> nameAndScore = new TreeMap<>();
    TreeSet<Students> allStudents = new TreeSet<>();

    public void addStudent(String name, Float grade){
        Students student = new Students();
        student.name = name;
        student.grade = grade;
        nameAndScore.put(student.name, student.grade);
        allStudents.add(student);

    }
    List<String> top3Stud(int n) throws NullPointerException{
        if (n < 0){
            throw new NegativeArraySizeException();
        }
        if(n > allStudents.size()){
            n = allStudents.size();
        }
        List<Students> sort = new ArrayList<>(allStudents);
        Collections.sort(sort, Collections.reverseOrder());

        List<String> topNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            topNames.add(sort.get(i).name);
        }

        return topNames;
    }

    public static void main(String[] args) {
        ResultsBoard rb = new ResultsBoard();


        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3Stud(6)); 		// -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3Stud(6)); 		// -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3Stud(6)); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3Stud(6)); 		// -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3Stud(6)); 		// -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]
    }
}

class Students implements Comparable<Students>{
    String name;
    Float grade;

    public Students(String name, Float grade) {
        this.name = name;
        this.grade = grade;
    }


    public Students() {

    }

    @Override
    public String toString() {
        return "Student -" +
                "name -" + name +
                "- grade = " + grade ;
    }


    @Override
    public int compareTo(Students o) {
        return this.grade.compareTo(o.grade);
    }
}