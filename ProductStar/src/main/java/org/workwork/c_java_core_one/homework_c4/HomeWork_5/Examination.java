package org.workwork.c_java_core_one.homework_c4.HomeWork_5;

import java.util.Map;
import java.util.Set;

public interface Examination {

    void addScore(Score score);

    Score getScore(String name, String subject) throws ScoreNotFoundException;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Map<String, Score> getAllScores();
}
