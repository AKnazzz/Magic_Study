package org.workwork.c_java_core_one.homework_c8.homework.task_1;

/*
 Задание 1. Написать реализацию списка, из которого нельзя удалить объект – конюшня.

Создать generic класс, у которого будут методы:

addAnimal – добавляет животное в конюшню и возвращает её же в return;
getAllAnimals – возвращает список всех животных в конюшне;
addAllAnimals – добавляет список животных в конюшню.
 */


import java.util.ArrayList;
import java.util.List;

public class Stable<T> {

    private List<T> horses = new ArrayList<>();

    public T addAnimal(T horse) {
        horses.add(horse);
        return horse;
    }

    public void addAllAnimals(List<T> horses) {
        horses.addAll(horses);
    }

    public int countHorses() {
        return horses.size();
    }

    public List<T> getHorses() {
        return horses;
    }
}
