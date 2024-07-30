package org.workwork.c_java_core_one.homework_c4.solution;

import java.util.HashMap;
import java.util.Map;

public class GradeCache {
    private Map<String, Double> averageCache = new HashMap<>();

    public Double getAverage(String subject) {
        return averageCache.get(subject);
    }

    public void setAverage(String subject, Double average) {
        averageCache.put(subject, average);
    }

    public boolean isCached(String subject) {
        return averageCache.containsKey(subject);
    }
}
