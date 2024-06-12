package org.workwork.d_java_core_one.homework_d5.work_8;

public class ResultsBoard implements Comparable<ResultsBoard> {

    float averageScore;
    String name;


    @Override
    public String toString() {
        return "[" + name + " - " + averageScore + "]";
    }

    /*public int compareToIgnoreCase(String name) {
        if(name.equals(name1)){
            return compareToIgnoreCase(name);}
        else {return compareToIgnoreCase(name1);}
    }*/

    @Override
    public int compareTo(ResultsBoard o) {
        int res = 0;
        if (o.name.compareToIgnoreCase(name) == 0) {
            res = 0;
        } else if (o.averageScore > averageScore) {
            res = -1;
        } else {
            res = 1;
        }
        return res;
    }
}
