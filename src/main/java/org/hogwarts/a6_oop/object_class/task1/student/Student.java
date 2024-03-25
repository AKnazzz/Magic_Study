package org.hogwarts.a6_oop.object_class.task1.student;

public class Student {
    private String name;
    private String faculty;
    private int age;
    private String [] ability = new String[3];


    public Student(String name, String faculty, int age, String[] ability) {
        this.name = name;
        this.faculty = faculty;
        this.age = age;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getAbility() {
        return ability;
    }

    public void setAbility(String[] ability) {
        this.ability = ability;
    }
}
