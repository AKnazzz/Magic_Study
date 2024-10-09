package org.workwork.c_java_core_one.homework_c4.HomeWork_8.students.src.main.java.org.example.students;

import java.util.HashMap;
import java.util.Map;

public class AverageScoresCache implements StudentsSubjectsAverageCache {

    public static final int INITIAL_CAPACITY = 256;
    protected final Map<String, Double> averageScoresCache = new HashMap<>(INITIAL_CAPACITY);

    @Override
    public double getAverageScoreForSubjectFromCache(String subject) {

        double averageScore = 0;

        for(String actualSubject : averageScoresCache.keySet()) {
            if(actualSubject.equals(subject)) {
                averageScore = averageScoresCache.get(actualSubject);
            }
        }


        System.out.println(averageScore);
        return averageScore;
    }
}
