package org.workwork.c_java_core_one.homework_c4.HomeWork_8.students.src.main.java.org.example.students;

import Exceptions.ItemNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Examination {
    void addScore(Score score);
    void addAllScores(List<Score> examinations);

    String getScore(String name, String subject) throws ItemNotFoundException;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<String> getAllScores(String name);
}
