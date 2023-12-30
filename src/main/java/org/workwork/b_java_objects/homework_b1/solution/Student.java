package org.workwork.b_java_objects.homework_b1.solution;

public class Student extends Person {

    @Override
    public void sayHi() {
        System.out.println("Good morning, sir! My name is " + name + " and I'm a student");
    }

    public void haveAParty(){
        System.out.println("Party time! BYOB!");
    }
}