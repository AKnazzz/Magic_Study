package org.workwork.c_java_core_one.homework_c4.HomeWork_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashGetAverageForSubject implements Examination {

    private final Map <String, Score> zachtenocash = new HashMap<>();

    
    public Map<String, Score> getZachtenocash() {
        return zachtenocash;
    }

    @Override
    public double getAverageForSubject(List<Score> zachtenocash) {

        double aver;
        int summ = 0;
        for (int i = 0; i < zachtenocash.size(); i++) {
            summ = summ + zachtenocash.get(i).score();
        }
        aver = summ/zachtenocash.size();
        
        return aver;
        
    }

    @Override
    public void addScore(Score score) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getAllScores(List<Score> zachteno) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Score getScore(String name) throws ItemNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> lastFiveStudentsWithExcellentMarkOnAnySubject(List<Score> zachteno) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String multipleSubmissionsStudentNames(List<Score> zachteno) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
