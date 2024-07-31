package org.workwork.c_java_core_one.homework_c5.workshop;

public class Event implements Comparable<Event>{

    int start;
    int end;
    String name;

    @Override
    public int compareTo(Event o) {
        if(start == o.start){
            return Integer.compare(end,o.end);
        } else {
            return Integer.compare(start,o.start);
        }
    }


    @Override
    public String toString() {
        return "Event{" +
                "start=" + start +
                ", end=" + end +
                ", name='" + name + '\'' +
                '}';
    }
}