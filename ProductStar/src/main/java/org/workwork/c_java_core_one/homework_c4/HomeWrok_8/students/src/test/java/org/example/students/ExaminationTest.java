package org.example.students;

import Exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExaminationTest extends AverageScoresCache {

    private StudentsExaminationDatabase studentsExaminationDatabase;

    @BeforeEach
    void setUp() {
        studentsExaminationDatabase = new StudentsExaminationDatabase();
    }

    @Test
    void addScore() throws ItemNotFoundException {
        Score score = new Score("Misha Simonian", "math", 4);

        studentsExaminationDatabase.addScore(score);


    }

    @Test
    void addAllScores() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination5 = new Score("Misha Simonian", "biology", 5);
        Score examination3 = new Score("Eva Smith", "biology", 4);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4,examination5));
    }

    @Test
    void getScore() throws ItemNotFoundException {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        Score examination5 = new Score("Eva Smith", "biology", 4);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5));
        System.out.println(studentsExaminationDatabase.getScore("Misha Simonian", "math"));
        System.out.println(studentsExaminationDatabase.getScore("Eva Smith", "biology"));
    }

    @Test
    void getAverageForSubject() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "math", 3);
        Score examination5 = new Score("Eva Smith", "math", 4);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5));

        studentsExaminationDatabase.getAverageForSubject("math");
    }

    @Test
    void multipleSubmissionsStudentNames() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        Score examination5 = new Score("Eva Smith", "biology", 4);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5));

        studentsExaminationDatabase.multipleSubmissionsStudentNames();
    }

    @Test
    void lustFiveStudentsWithExcellentMarkOnAnySubjects() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        Score examination5 = new Score("Eva Smith", "biology", 4);
        Score examination6 = new Score("Mariia Simonian", "math", 3);
        Score examination7 = new Score("Mariia Simonian", "math", 5);
        Score examination8 = new Score("Jon Snow", "chemistry", 5);
        Score examination9 = new Score("Vanesa Shmidt", "biology", 3);
        Score examination10 = new Score("Jon Brown", "biology", 4);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5, examination6, examination7, examination8, examination9, examination10));

        studentsExaminationDatabase.lastFiveStudentsWithExcellentMarkOnAnySubject();
    }

    @Test
    void getAllScores() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        Score examination5 = new Score("Eva Smith", "biology", 4);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5));

        studentsExaminationDatabase.getAllScores("Eva Smith");
    }

    @Test
    void getAverageScoreForSubjectFromCache() {
        Score examination1 = new Score("Misha Simonian", "math", 3);
        Score examination2 = new Score("Misha Simonian", "math", 5);
        Score examination3 = new Score("Misha Simonian", "chemistry", 5);
        Score examination4 = new Score("Eva Smith", "biology", 3);
        Score examination5 = new Score("Eva Smith", "biology", 4);
        Score examination6 = new Score("Eva Smith", "chemistry", 3);
        Score examination7 = new Score("Eva Smith", "biology", 4);
        Score examination8 = new Score("Eva Smith", "chemistry", 2);
        Score examination9 = new Score("Eva Smith", "biology", 5);
        Score examination10 = new Score("Eva Smith", "chemistry", 3);
        studentsExaminationDatabase.addAllScores(List.of(examination1, examination2, examination3, examination4, examination5, examination6, examination7, examination8, examination9, examination10));

        studentsExaminationDatabase.getAverageForSubject("math");
        studentsExaminationDatabase.getAverageForSubject("chemistry");
        studentsExaminationDatabase.getAverageForSubject("biology");

        studentsExaminationDatabase.getAverageScoreForSubjectFromCache("math");
        studentsExaminationDatabase.getAverageScoreForSubjectFromCache("chemistry");
        studentsExaminationDatabase.getAverageScoreForSubjectFromCache("biology");
    }
}
