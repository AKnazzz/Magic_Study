package org.workwork.c_java_core_one.homework_c8.homework.task_4;

/*
⚒ Задание 4. Написать статический метод, который будет перегонять лошадей из одной конюшни в другую - более общую,
параметризованную интерфейсом Животное, а не классом лошади.
 */


public class Main {

    public static void main(String[] args) {
        Stable<Horse> stable = new Stable<>();
        Stable<Animal> animalsStable = new Stable<>();
        moveHorses(stable, animalsStable);
    }

    public static <T> void moveHorses(Stable<? extends T> source, Stable<? super T> destination){
        destination.addHorses(source.getHorses());
    }
}
