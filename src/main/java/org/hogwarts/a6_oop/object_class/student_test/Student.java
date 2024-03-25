package org.hogwarts.a6_oop.object_class.student_test;

public class Student {
    int studentId;
    String name;
    String surname;
    int course;
    double mathAverageGrade;
    double economicsAverageGrade;
    double englishAverageGrade;

    public Student(int studentId, String name, String surname, int course, double mathAverageGrade, double economicsAverageGrade, double englishAverageGrade) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.mathAverageGrade = mathAverageGrade;
        this.economicsAverageGrade = economicsAverageGrade;
        this.englishAverageGrade = englishAverageGrade;
    }

    public Student(int studentId, String name, String surname, int course) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public Student() {
    }
}

class StudentTest {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.studentId = 1;
        student1.name = "Boris";
        student1.surname = "Ivanov";
        student1.course = 4;
        student1.mathAverageGrade = 8.8;
        student1.economicsAverageGrade = 9.9;
        student1.englishAverageGrade = 7.7;

        Student student2 = new Student();
        student2.studentId = 2;
        student2.name = "Alexey";
        student2.surname = "Sidorov";
        student2.course = 6;
        student2.mathAverageGrade = 8.4;
        student2.economicsAverageGrade = 7.5;
        student2.englishAverageGrade = 9.7;

        Student student3 = new Student();
        student3.studentId = 3;
        student3.name = "Petr";
        student3.surname = "Belov";
        student3.course = 3;
        student3.mathAverageGrade = 9.4;
        student3.economicsAverageGrade = 8.5;
        student3.englishAverageGrade = 8.7;

        System.out.println(
                "Средняя арифметическая оценка студента " + student1.name + " " + student1.surname + " = " + (
                        student1.mathAverageGrade + student1.economicsAverageGrade + student1.englishAverageGrade) / 3);

        System.out.println(
                "Средняя арифметическая оценка студента " + student2.name + " " + student2.surname + " = " + (
                        student2.mathAverageGrade + student2.economicsAverageGrade + student2.englishAverageGrade) / 3);

        System.out.println(
                "Средняя арифметическая оценка студента " + student3.name + " " + student3.surname + " = " + (
                        student3.mathAverageGrade + student3.economicsAverageGrade + student3.englishAverageGrade) / 3);

        System.out.println();
        sredOcenkaForStudent(student1);
        sredOcenkaForStudent(student2);
        sredOcenkaForStudent(student3);

        Student student4 = new Student();
        Student student5 = new Student(4, "Ivan", "Popov", 1);
        Student student6 = new Student(5, "Oleg", "Rusov", 2, 7.7,7,8);

    }

    static double sredOcenkaForStudent (Student student){
        double sredOcenka = (student.mathAverageGrade + student.economicsAverageGrade + student.englishAverageGrade)/3;
        System.out.println("Средняя арифметическая оценка студента " + student.name + " " + student.surname + " = " + sredOcenka);
        return sredOcenka;
    }
}
