package org.workwork.c_java_core_one.homework_c4.HomeWork_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExaminationImpl implements Examination {
    private Map<String, Submission> submissions = new HashMap<>();
    private Map<String, List<Submission>> submissionHistory = new HashMap<>();

    @Override
    public void addSubmission(String firstName, String lastName, String subject, int grade) {
        String key = firstName + " " + lastName + " " + subject;
        Submission submission = new Submission(firstName, lastName, subject, grade);
        submissions.put(key, submission);
        submissionHistory.putIfAbsent(key, new ArrayList<>());
        submissionHistory.get(key).add(submission);
    }

    @Override
    public Submission getSubmission(String firstName, String lastName, String subject) {
        return submissions.get(firstName + " " + lastName + " " + subject);
    }

    @Override
    public double getAverageGrade(String subject) {
        Map<Student, List<Integer>> studentGrades = new HashMap<>();

        for (Submission submission : submissions.values()) {
            if (submission.getSubject().equals(subject)) {
                Student student = new Student(submission.getFirstName(), submission.getLastName());
                studentGrades.putIfAbsent(student, new ArrayList<>());
                studentGrades.get(student).add(submission.getGrade());
            }
        }

        return studentGrades.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .mapToDouble(e -> e.getValue().stream().mapToInt(i -> i).average().orElse(0))
                .average().orElse(0);
    }

    @Override
    public List<Student> getTopStudents() {
        List<Student> topStudents = new ArrayList<>();

        for (Submission submission : submissions.values()) {
            if (submission.getGrade() == 5) {
                topStudents.add(new Student(submission.getFirstName(), submission.getLastName()));
            }
        }

        return topStudents.size() > 5 ? topStudents.subList(0, 5) : topStudents;
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return new ArrayList<>(submissions.values());
    }
}
