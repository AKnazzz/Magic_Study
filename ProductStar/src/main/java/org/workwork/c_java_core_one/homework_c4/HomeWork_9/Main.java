package org.workwork.c_java_core_one.homework_c4.HomeWork_9;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Examination examination = new Examination() {
            @Override
            public void addSubmission(String firstName, String lastName, String subject, int grade) {

            }

            @Override
            public Submission getSubmission(String firstName, String lastName, String subject) {
                return null;
            }

            @Override
            public double getAverageGrade(String subject) {
                return 0;
            }

            @Override
            public List<Student> getTopStudents() {
                return List.of();
            }

            @Override
            public List<Submission> getAllSubmissions() {
                return List.of();
            }
        };
        examination.addSubmission("Иван", "Иванов", "Математика", 4);
        examination.addSubmission("Иван", "Иванов", "Математика", 5);
        examination.addSubmission("Петр", "Петров", "История", 3);
        examination.addSubmission("Иван", "Иванов", "Физика", 5);
        examination.addSubmission("Андрей", "Андреев", "Математика", 5);
        examination.addSubmission("Константин", "Константинов", "Математика", 4);


        GradeCache cache;
        cache = new GradeCache();
        System.out.println("Средняя оценка по математике: " + cache.getAverageGrade(examination, "Математика"));

        System.out.println("Студенты, сдавшие на отлично: " + examination.getTopStudents());
    }
}