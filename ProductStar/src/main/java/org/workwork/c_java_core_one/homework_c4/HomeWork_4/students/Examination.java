package org.workwork.c_java_core_one.homework_c4.HomeWork_4.students;
import org.workwork.c_java_core_one.homework_c4.HomeWork_4.students.exceptions.ItemNotFoundException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Examination {

    void addScore(Score score);

    Score getScore(Student student, String subject) throws ItemNotFoundException;

    Double getAverageForSubject(String subject);

    Set<Student> multipleSubmissionsStudentNames();

    Set<Student> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Set<String> getAllSubject();

    Collection<Score> getAllScores();

    public Map<KeyStudentSubject, Score> getAllItems();
}
