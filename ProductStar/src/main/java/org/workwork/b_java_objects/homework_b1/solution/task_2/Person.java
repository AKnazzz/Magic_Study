package org.workwork.b_java_objects.homework_b1.solution.task_2;

public abstract class Person {

    String name;
    int age;
    int height;
    String department;

    public abstract void sayHi();

    public void describePerson() {
        System.out.println(
                name + " is " + age + " old and is " + height + " tall. " +
                        "Works in " + department + " department"
        );
    }

}