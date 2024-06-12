package org.workwork.b_java_objects.homework_b1.solution.taks_1;

public class SimpleDocent {
    String name;
    int age;
    int height;
    String department;

    public void sayHi() {
        System.out.println("Yo, mate! I'm a docent. Respect my authority!");
    }

    public void makeStudentsSuffer() {
        System.out.println("You shall not pass!");
    }

    public void describePerson() {
        System.out.println(
                name + " is " + age + " old and is " + height + " tall. " +
                        "Works in " + department + " department"
        );
    }

}