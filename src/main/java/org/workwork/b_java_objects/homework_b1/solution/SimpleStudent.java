package org.workwork.b_java_objects.homework_b1.solution;

public class SimpleStudent {
    String name;
    int age;
    int height;
    String department;

    public void sayHi() {
        System.out.println("Good morning, sir! My name is " + name + " and I'm a student");
    }

    public void haveAParty(){
        System.out.println("Party time! BYOB!");
    }

    public void describePerson(){
        System.out.println(
                name + " is " + age + " old and is " + height + " tall. " +
                        "Works in " + department + " department"
        );
    }

}