package org.workwork.c_java_core_one.homework_c4.HomeWork_9;

public class Submission {
    private String firstName;
    private String lastName;
    private String subject;
    private int grade;

    public Submission(String firstName, String lastName, String subject, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.grade = grade;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }
}