package org.workwork.d_java_core_one.homework_d5.work_9;

public class Student implements Comparable<Student> {

    float averageScore;
    String name;


    @Override
    public String toString(){
        return "[" + name + " - " + averageScore + "]";
    }


    @Override
    public int compareTo(Student o) {
        int res = 0;
        if(o.name.compareToIgnoreCase(name) == 0){
            res = 0;
        } else if(o.averageScore > averageScore){
            res = -1;}
        else {
            res = 1;
        }
        return res;
    }
}