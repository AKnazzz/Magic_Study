package org.workwork.c_java_core_one.homework_c4.HomeWork_1;



import org.workwork.c_java_core_one.homework_c4.HomeWork_1.exceptions.ScoreNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Examination {
    void addScore(Score score);
    void  addMultipleScores(List<Score> scores);

    Score getScore(String name, String subject) throws ScoreNotFoundException;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
