package org.workwork.c_java_core_one.homework_c8.homework.task_4;

import java.util.ArrayList;
import java.util.List;

/*
⚒ Задание 2. Создать иерархию классов породистых лошадей – интерфейс животного -> базовый класс лошади -> 2-3 породы скакунов.
 */
public class Stable<T> {

    private List<T> horses = new ArrayList<>();

    public T addHorse(T horse) {
        horses.add(horse);
        return horse;
    }

    public void addHorses(List<? extends T> horsesToAdd) {
        horses.addAll(horsesToAdd);
    }

    public int countHorses() {
        return horses.size();
    }

    public List<T> getHorses() {
        return horses;
    }
}