package org.workwork.d_java_core_one.homework_d5.work_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ResultBoard3 {
    TreeSet<Student> board = new TreeSet<>();

    public ResultBoard3() {
    }

    public static void main(String[] args) {
//        ResultBoard3 resultBoard3 = new ResultBoard3();
//        resultBoard3.addStudent("Ivan", 3.823F);
//        resultBoard3.addStudent("Petr", 3.225F);
//        resultBoard3.addStudent("Anton", 3.369F);
//        resultBoard3.addStudent("Sidor", 3.169F);
//        resultBoard3.addStudent("Alfred", 3.369F);
//
//
//        System.out.println(resultBoard3.board);
//
//
//        List<Student> top3 = resultBoard3.top3();
//        System.out.println("Three best students:");
//        for (Student student : top3) {
//            System.out.print(student.name + "; ");
//        }


        ResultBoard3 rb = new ResultBoard3();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3());        // -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3());        // -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3());        // -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3());        // -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3());        // -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]
    }

    void addStudent(String name, Float score) {
        Student student = new Student();
        student.name = name;
        student.score = score;
        board.add(student);
    }

    public List<Student> top3() {
        List<Student> uspeh = new ArrayList<>();
        Iterator<Student> iterator = board.descendingIterator();
        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            uspeh.add(iterator.next());
        }
        return uspeh;
    }
}

class Student implements Comparable<Student> {

    String name;
    Float score;

    @Override
    public int compareTo(Student o) {
        //return CharSequence.compare(name, o.name);
        String str1 = Float.toString(score) + name;
        String str2 = Float.toString(o.score) + o.name;

        return CharSequence.compare(str1, str2);

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

//class Student implements Comparable<Student>{
//
//    String name;
//    Float score;

//    @Override
//    public int compareTo(Student o) {
//        int scoreComparison = Float.compare(o.score, this.score);
//        if (scoreComparison != 0) {
//            return scoreComparison;
//        }
//        return this.name.compareTo(o.name);
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", score=" + score +
//                '}';
//    }
//}
