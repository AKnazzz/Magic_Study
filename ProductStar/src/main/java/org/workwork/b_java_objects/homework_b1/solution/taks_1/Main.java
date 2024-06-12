package org.workwork.b_java_objects.homework_b1.solution.taks_1;

public class Main {
    public static void main(String[] args) {
        SimpleStudent vasily = new SimpleStudent();
        vasily.height = 180;
        vasily.name = "Vasily";
        vasily.age = 20;
        vasily.department = "IT";


        SimpleDocent docent = new SimpleDocent();
        docent.name = "Petr Alexeevich";
        docent.height = 160;
        docent.department = "IT";
        docent.age = 44;

        vasily.sayHi();
        vasily.haveAParty();

        docent.sayHi();
        docent.makeStudentsSuffer();
    }
}
