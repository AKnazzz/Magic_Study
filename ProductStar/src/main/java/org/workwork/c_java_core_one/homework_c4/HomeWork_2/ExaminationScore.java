package org.workwork.c_java_core_one.homework_c4.HomeWork_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExaminationScore implements Examination {

    private final Map <String, Score> zachteno = new HashMap<>();


    @Override
    public void addScore(Score score) {
        zachteno.put(score.name(), score);
        
    }

    @Override
    public void getAllScores(List<Score> zachteno) {
        for (int i = 0; i < zachteno.size(); i ++) {
            System.out.println(zachteno.get(i));
        }
        
    }

    @Override
    public double getAverageForSubject(List<Score> zachteno) {
        
        double aver;
        int summ = 0;
        for (int i = 0; i < zachteno.size(); i++) {
            summ = summ + zachteno.get(i).score();
        }
        aver = summ/zachteno.size();
        System.out.println("Average " + aver);
        return aver;
        

    }

    @Override
    public Score getScore(String name) throws ItemNotFoundException {
        Score score = zachteno.get(name);
            if (score == null) {
                throw new ItemNotFoundException(name); 
            }
        return score;
    }

    @Override
    public List<String> lastFiveStudentsWithExcellentMarkOnAnySubject(List<Score> zachteno) {
        List<String> arr1 = new ArrayList<>();
        for (Score otlichno : zachteno) {
            if (otlichno.score() == 5) {
                arr1.add(otlichno.name());
                
            }
        }
        
        return arr1;
    }

    @Override
    public String multipleSubmissionsStudentNames(List<Score> zachteno) {

        String name = "";
        Set<Score> oneTime = new HashSet<>();
            for (Score score : zachteno) {
                if(!oneTime.add(score)) {
                    name = score.name();
                    System.out.println("more one times " + name);
                }
                
            }
        
        return name;
    }
    
}
