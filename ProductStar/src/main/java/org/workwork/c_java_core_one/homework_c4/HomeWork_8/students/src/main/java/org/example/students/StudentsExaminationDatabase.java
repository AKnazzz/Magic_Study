package org.workwork.c_java_core_one.homework_c4.HomeWork_8.students.src.main.java.org.example.students;

import Exceptions.ItemNotFoundException;

import java.util.*;

public class StudentsExaminationDatabase extends AverageScoresCache implements Examination{

    public static final int INITIAL_CAPACITY = 256;
    protected final Map<String, Score> studentsExaminationDatabase = new HashMap<>(INITIAL_CAPACITY);
    private final Set<String> multipleSubmissionsStudentNamesBase = new HashSet<>(INITIAL_CAPACITY);

    @Override
    public void addScore(Score score)  {
        studentsExaminationDatabase.put(score.name() + " " + score.subject(), score);
    }

    @Override
    public void addAllScores(List<Score> examinations) {
        for(Score examination : examinations) {
            if(studentsExaminationDatabase.containsKey(examination.name() + " " + examination.subject())) {
                multipleSubmissionsStudentNamesBase.add(examination.name());
            }
            addScore(examination);
        }
    }

    @Override
    public String getScore(String name, String subject) throws ItemNotFoundException {
        Score examinations = studentsExaminationDatabase.get(name + " " + subject);
        String studentName = examinations.name();
        String examinationSubject = examinations.subject();
        String examinationScore = String.valueOf(examinations.score());
        Score result = null;
        if(studentName.equals(name) &&  examinationSubject.equals(subject)) {
            result = examinations;
        } else {
            throw new ItemNotFoundException("The student's examination doesn't exist");
        }
        return "The " + studentName + "'s score in " + examinationSubject + " is " + examinationScore;
    }

    @Override
    public double getAverageForSubject(String subject) {
        double result = 0;
        int i = 0;

        for(Score actualSubject : studentsExaminationDatabase.values()) {
            if(actualSubject.subject().equals(subject)){
                result += actualSubject.score();
                i += 1;
            }
        }
        result /= i;

        averageScoresCache.put(subject, result);
//        System.out.println(result);
        return result;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        System.out.println(multipleSubmissionsStudentNamesBase);
        return multipleSubmissionsStudentNamesBase;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Set<String> lastFiveStudents = new HashSet<>();
        int i = 0;

        for(Score examination : studentsExaminationDatabase.values()) {
            if(i < studentsExaminationDatabase.size() -5) {
                i++;
            } else {
                if(examination.score() == 5) {
                    lastFiveStudents.add(examination.name());
                }
            }
        }

        System.out.println(lastFiveStudents);
        return lastFiveStudents;
    }

    @Override
    public Collection<String> getAllScores(String name) {
        Set<String> allScores = new HashSet<>();

        for(Score examination : studentsExaminationDatabase.values()) {
            if(examination.name().equals(name)) {
                allScores.add(examination.subject());
            }
        }
        System.out.println("Subjects that " + name + "'s passed: " + allScores);
        return allScores;
    }
}
