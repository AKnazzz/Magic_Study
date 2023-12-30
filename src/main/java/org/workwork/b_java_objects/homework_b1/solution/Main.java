package org.workwork.b_java_objects.homework_b1.solution;

public class Main {
    public static void main(String[] args) {

        Student vasiliy = new Student();
        vasiliy.name = "Vasiliy";
        vasiliy.age = 21;
        vasiliy.department = "Year 3";
        vasiliy.height = 178;

        Docent alexandrPetrovich = new Docent();
        alexandrPetrovich.name = "Alexandr Petrovich";
        alexandrPetrovich.age = 38;
        alexandrPetrovich.height = 172;
        alexandrPetrovich.department = "Kafedra OOP";

        vasiliy.sayHi();
        vasiliy.haveAParty();

        alexandrPetrovich.sayHi();
        alexandrPetrovich.makeStudentsSuffer();
    }
}