package org.workwork.c_java_core_one.homework_c4.HomeWork_3.students;
import org.workwork.c_java_core_one.homework_c4.HomeWork_3.students.exceptions.ItemNotFoundException;

import java.util.Collection;
import java.util.Set;

public interface Examination {

    void addScore(Score score);

    Score getScore(String name, String subject) throws ItemNotFoundException;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
