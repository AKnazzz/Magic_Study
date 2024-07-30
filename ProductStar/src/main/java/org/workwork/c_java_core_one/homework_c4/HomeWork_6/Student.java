package org.workwork.c_java_core_one.homework_c4.HomeWork_6;

public class Student {
    public final String name;
    public final String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString(){
        return name + " " + surname;
    }
}