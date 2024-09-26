package org.workwork.c_java_core_one.homework_c4.HomeWork_9;

import java.util.HashMap;
import java.util.Map;

public class GradeCache {
    private Map<String, Double> cache = new HashMap<>();

    public double getAverageGrade(Examination examination, String subject) {
        if (cache.containsKey(subject)) {
            return cache.get(subject);
        } else {
            double average = examination.getAverageGrade(subject);
            cache.put(subject, average);
            return average;
        }
    }
}