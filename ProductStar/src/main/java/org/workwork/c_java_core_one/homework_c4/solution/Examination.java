package org.workwork.c_java_core_one.homework_c4.solution;

import java.util.Collection;
import java.util.Set;

public interface Examination {
    void addScore(Score score);

    Score getScore(String name, String subject);

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
