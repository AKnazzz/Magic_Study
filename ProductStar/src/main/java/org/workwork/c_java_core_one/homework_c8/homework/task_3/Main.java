package org.workwork.c_java_core_one.homework_c8.homework.task_3;

/*
Задание 3. Написать программу, которая будет добавлять разные типы лошадей в конюшню по отдельности,
в виде списка лошадей и в виде списка конкретных пород. Использовать PECS, чтобы обойти ошибки компиляции.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stable<Horse> stable = new Stable<>();

        Mustang mustang = new Mustang();
        stable.addHorse(mustang);

        Pony pony = new Pony();
        stable.addHorse(pony);

        List<Mustang> wildMustangs = new ArrayList<>();
        wildMustangs.add(new Mustang());
        wildMustangs.add(new Mustang());

        stable.addHorses(wildMustangs);
    }
}
