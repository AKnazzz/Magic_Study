package org.workwork.c_java_core_one.homework_c4.HomeWork_9;

import java.util.List;

public interface Examination {
    void addSubmission(String firstName, String lastName, String subject, int grade);

    Submission getSubmission(String firstName, String lastName, String subject);

    double getAverageGrade(String subject);

    List<Student> getTopStudents();

    List<Submission> getAllSubmissions();
}