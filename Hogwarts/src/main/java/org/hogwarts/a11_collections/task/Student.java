package org.hogwarts.a11_collections.task;

public class Student implements Comparable<Student> {
    String name;
    int age;
    String faculty;
    String[] abilities;

    public Student(String name, int age, String faculty, String[] abilities) {
        this.name = name;
        this.age = age;
        this.faculty = faculty;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFaculty() {
        return faculty;
    }

    public String[] getAbilities() {
        return abilities;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.age, otherStudent.age);
    }
}

