package org.workwork.c_java_core_one.homework_c4.HomeWork_2;

import java.util.List;

public interface Examination {
    void addScore(Score score); //добавить сдачу студента 
    //(в зачет идет только последняя сдача, хранить все сдачи студента по одному и тому же предмету не нужно)

    Score getScore(String name) throws ItemNotFoundException; //получить сдачу студента по имени и фамилии и предмету

    double getAverageForSubject(List<Score> zachteno); //вывод средней оценки по предмету

    String multipleSubmissionsStudentNames(List<Score> zachteno); //вывод студентов кто сдавал более одного раза

    List<String> lastFiveStudentsWithExcellentMarkOnAnySubject(List<Score> zachteno); //вывод последних пяти студентов сдавших на отлично по любому предмету

    void getAllScores(List<Score> zachteno); //вывод всех сданных предметов
}
