package org.workwork.c_java_core_one.homework_c4.HomeWork_1;

import org.workwork.c_java_core_one.homework_c4.HomeWork_1.exceptions.ScoreNotFoundException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CachedUniversityExamination implements Examination {
    public final UniversityExamination basicUniversity;

    private final Map<String, Double> cache = new LRUScoresCache<>(2);

    public CachedUniversityExamination(UniversityExamination basicUniversity) {
        this.basicUniversity = basicUniversity;
    }

    public int getAverageMarksCalls() {
        return basicUniversity.getAverageMarksCalls();
    }

    @Override
    public void addScore(Score score) {
        basicUniversity.addScore(score);
    }

    @Override
    public void addMultipleScores(List<Score> scores) {
        basicUniversity.addMultipleScores(scores);
    }

    @Override
    public Score getScore(String name, String subject) throws ScoreNotFoundException {
        return basicUniversity.getScore(name, subject);
    }

    @Override
    public double getAverageForSubject(String subject) {
        return cache.computeIfAbsent(subject, basicUniversity::getAverageForSubject);
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return basicUniversity.multipleSubmissionsStudentNames();
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return basicUniversity.lastFiveStudentsWithExcellentMarkOnAnySubject();
    }

    @Override
    public Collection<Score> getAllScores() {
        return basicUniversity.getAllScores();
    }
}

class LRUScoresCache<KEY, VALUE> extends LinkedHashMap<KEY, VALUE> {
    private final int capacity;

    public LRUScoresCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<KEY, VALUE> eldest) {
        return size() > capacity;
    }
}
