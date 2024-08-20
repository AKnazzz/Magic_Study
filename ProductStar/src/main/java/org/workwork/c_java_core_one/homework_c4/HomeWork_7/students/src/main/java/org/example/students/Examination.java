package org.example.students;

import org.example.students.exceptions.ItemNotFoundException;
import java.util.*;


record NameAndSubject(String name, String subject) {}


public interface Examination {

    void addScore(Score score);

    Score getScore(String name, String subject) throws ItemNotFoundException;

    void putAllItems(List<Score> items);

    Score removeItem(String name, String subject) throws ItemNotFoundException;

    boolean containsItem(Score score);

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Map<NameAndSubject, Integer> getAllItems();

    Collection<Score> getAllScores();
}
