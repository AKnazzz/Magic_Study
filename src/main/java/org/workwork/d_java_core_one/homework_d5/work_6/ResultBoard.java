package org.workwork.d_java_core_one.homework_d5.work_6;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ResultBoard {
    private TreeSet<Student> students = new TreeSet<Student>();

    public void addStudent(String name, Float score) throws NullPointerException {
        if (name == null || score == null)
            throw new NullPointerException("Имя или средний балл не должны быть null!");
        students.add(new Student(name, score));
    }

    public List<String> top3() {
//        int cap = Math.min(students.size(), 3);
//        List<String> result = new ArrayList<>(cap);
//        if (cap == 0) {
//            return null;
//        } else {
//            Student stud = students.pollLast();
//            String res;
//            for (int i = 0; i < cap; i++) {
//                res = stud.name;
//                result.add(res);
//                stud = students.pollLast();
//
//            }
//            return result;
//        }
 //       public List<String> top3() {
            int cap = Math.min(students.size(), 3);
            List<String> result = new ArrayList<>(cap);

            if (cap == 0) {
                return null;
            } else {
                Student stud = students.last();
                String res;
                for (int i = 0; i < cap; i++) {
                    res = stud.name;
                    result.add(res);
                    Student prev = stud;
                    while (students.lower(stud) != null && students.lower(stud).score == prev.score) {
                        prev = stud;
                        stud = students.lower(stud);
                    }
                    stud = students.lower(stud);
                }

                return result;
            }
        }

    }


class Student implements Comparable<Student> {
    String name;
    Float score;

    public Student(String name, Float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Студент " + this.name + " со средним баллом " + this.score;
    }

    @Override
    public int compareTo(Student o) {
        if (score == o.score) {
            return 0;
        }
        if (score > o.score) {
            return 1;
        } else {
            return -1;
        }
    }
}
