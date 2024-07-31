package org.workwork.c_java_core_one.homework_c5.workshop;

import java.util.*;

public class Schedule {

    TreeSet<Event> eventTreeSet = new TreeSet<Event>(); // == для хранения/добавления событий в сортированном виде
    TreeMap<Integer, Integer> integerTreeMap = new TreeMap<>(); // для определения пересечения по времени событий


    void addEvent(int start, int end, String name) {
        Event event = new Event();
        event.start = start;
        event.end = end;
        event.name = name;
        eventTreeSet.add(event);

        integerTreeMap.put(start, integerTreeMap.getOrDefault(start, 0) + 1); // при начале события добавляем 1
        integerTreeMap.put(end, integerTreeMap.getOrDefault(end, 0) - 1);     // при конце отнимаем 1
    }

    List<Event> getNext3(int time) {
        Event o = new Event();
        o.start = time;

        NavigableSet<Event> tailSet = eventTreeSet.tailSet(o, true);
        List<Event> result = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            if (!tailSet.isEmpty()) {
                result.add(tailSet.pollFirst());
            }
        }
        return result;
    }

    //определяем пересечение по времени событий
    boolean hasOverlaps() {

        int cnt = 0; // счетчик

        for (Integer key : integerTreeMap.keySet()) {
            cnt += integerTreeMap.get(key);
            if (cnt > 1) { // если счетчик например 2, то значит два события пересеклись
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.addEvent(9, 10, "Daily Meeting");
        schedule.addEvent(11, 12, "1:1 with Ivan");
        schedule.addEvent(15, 16, "Sync - Big Bet Project");
        schedule.addEvent(17, 18, "Java community meeting");
        schedule.addEvent(19, 21, "Private appointment");

        System.out.println(schedule.getNext3(3));
        System.out.println(schedule.hasOverlaps());
    }

}
