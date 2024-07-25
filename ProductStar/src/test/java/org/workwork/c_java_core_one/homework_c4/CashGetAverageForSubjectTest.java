package org.workwork.c_java_core_one.homework_c4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.Examination;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.ExaminationScore;
import org.workwork.c_java_core_one.homework_c4.HomeWork_2.Score;

import java.util.List;

public class CashGetAverageForSubjectTest {

    private Examination examination;
    
    @BeforeEach
     void setUp () {
        examination = new ExaminationScore();
     }
    @Test
    void GetAverageForSubject() {                

        Score score1 = new Score("Romanov", "Boilogy", 5);
        Score score2 = new Score("Petrov", "Physic", 3);
        Score score3 = new Score("Babay", "Okrugaika", 4);
        Score score4 = new Score("Super", "Fizra", 3);
        Score score5 = new Score("Sidorov", "Russki yazyk", 5);  
        
        List<Score> zachtenocash = List.of(score1, score2, score3, score4, score5);
        double averageScore = examination.getAverageForSubject(zachtenocash);
        Assertions.assertEquals(4, averageScore);

    }
}
