package org.hogwarts.types_of_variables;

/**
 * В методе main класса Main создайте 5 переменных типа String: dumbledore, mcgonagall, snape, lupin, hugrid.
 * Присвойте каждой переменной значение, соответствующее ее названию. Должны получиться поля, содержащие имена знаменитых волшебников.
 *
 * Затем создайте еще одну строку с названием teachers, содержащую текст: “School teachers:“.
 * Обратите внимание, в тексте содержится двоеточие.
 *
 * Выведите на экран сначала строку teachers, затем все 5 строк с именами преподавателей.
 * Должен получиться список учителей.
 */

public class TaskFromHogwarts1 {
    public static void main(String[] args) {

        String dumbledore = "Dumbledore";
        String mcgonagall = "Mcgonagall";
        String snape = "Snape";
        String lupin = "Lupin";
        String hugrid = "Hugrid";

        String teachers = "School teachers: ";

        System.out.println(teachers);
        System.out.println(dumbledore);
        System.out.println(mcgonagall);
        System.out.println(snape);
        System.out.println(lupin);
        System.out.println(hugrid);

    }
}
