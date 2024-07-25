package org.workwork.c_java_core_one.homework_c4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.Examination;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.ExaminationScore;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.ItemNotFoundException;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExaminationTest {

    private Examination examination;

    @BeforeEach
     void setUp () {
        examination = new ExaminationScore();
     }

    @Test
    void AddScore() throws ItemNotFoundException {
        Score score = new Score("Petrova", "biology", 5);
        examination.addScore(score);
        Score actual = examination.getScore(score.name());

        Assertions.assertEquals(score, actual);

    }

    @Test
    void GetAllScores() {
        Score score1 = new Score("Romanov", "Boilogy", 5);
        Score score2 = new Score("Petrov", "Physic", 3);
        Score score3 = new Score("Babay", "Okrugaika", 4);
        Score score4 = new Score("Super", "Fizra", 5);
        Score score5 = new Score("Sidorov", "Russki yazyk", 5);
        Score score6 = new Score("Super", "Fizra", 4);
        Score score7 = new Score("Romanov", "Boilogy", 5);
        Score score8 = new Score("Petrov", "Physic", 5);

        List<Score> zachteno = List.of(score1, score2, score3, score4, score5, score6, score7, score8);
        examination.getAllScores(zachteno);
        Assertions.assertEquals(8, zachteno.size());


    }

    @Test
    void GetAverageForSubject() {
        
        Score score1 = new Score("Romanov", "Boilogy", 5);
        Score score2 = new Score("Petrov", "Physic", 3);
        Score score3 = new Score("Babay", "Okrugaika", 4);
        Score score4 = new Score("Super", "Fizra", 3);
        Score score5 = new Score("Sidorov", "Russki yazyk", 5);

        List<Score> zachteno = List.of(score1, score2, score3, score4, score5);
        double averageScore = examination.getAverageForSubject(zachteno);
        Assertions.assertEquals(4, averageScore);

    }

    @Test
    void GetScore() throws ItemNotFoundException {
        Score score1 = new Score("Ivanova", "Physic", 5);
        Map<String, Score> zachteno = new HashMap<>();
        zachteno.put(score1.name(), score1);

        Score scoreActual = zachteno.get(score1.name());
        Assertions.assertEquals(score1, scoreActual);
        Assertions.assertThrows(ItemNotFoundException.class, ()-> examination.getScore("2"));
    }

    @Test
    void LastFiveStudentsWithExcellentMarkOnAnySubject() {

        Score score1 = new Score("Romanov", "Boilogy", 5);
        Score score2 = new Score("Petrov", "Physic", 3);
        Score score3 = new Score("Babay", "Okrugaika", 4);
        Score score4 = new Score("Super", "Fizra", 5);
        Score score5 = new Score("Sidorov", "Russki yazyk", 5);
        Score score6 = new Score("Super", "Fizra", 4);
        Score score7 = new Score("Romanov", "Boilogy", 5);
        Score score8 = new Score("Petrov", "Physic", 5);
        Score score9 = new Score("Babay", "Okrugaika", 4);
        Score score10 = new Score("Super", "Fizra", 3);
        Score score11 = new Score("Sidorov", "Russki yazyk", 3);
        Score score12 = new Score("Super", "Fizra", 4);
        
        List<Score> zachteno = List.of(score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, 
        score11, score12);

        List<String> arr = new ArrayList<>();
        List<String> arr1 = examination.lastFiveStudentsWithExcellentMarkOnAnySubject(zachteno);
        Assertions.assertEquals(List.of("Romanov", "Super", "Sidorov", "Romanov", "Petrov"), arr1);        

    }

    @Test
    void MultipleSubmissionsStudentNames() {
        Score score1 = new Score("Romanov", "Boilogy", 5);
        Score score2 = new Score("Petrov", "Physic", 3);
        Score score3 = new Score("Babay", "Okrugaika", 4);
        Score score4 = new Score("Super", "Fizra", 3);
        Score score5 = new Score("Sidorov", "Russki yazyk", 5);
        Score score6 = new Score("Super", "Fizra", 4);
        List<Score> zachteno = List.of(score1, score2, score3, score4, score5, score6);

        examination.multipleSubmissionsStudentNames(zachteno);
        Assertions.assertEquals("Super", score4.name());
        
    }
}
