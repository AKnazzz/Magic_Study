package org.workwork.b_java_objects.homework_b6.solution;

/**
 * Задание 1. Заполните текст, используя независимо методы.
 * <p>
 * String.format.
 * Макет: Санкт-Петербург был основан в … году … . За свою историю он носил имена: . Сейчас многие зовут его просто “”.
 * <p>
 * Integer I = 1703
 * String a = Петром Первым
 * String[] arrayNames = {Санкт-Петербург, Петроград, Ленинград}
 * String b = Питер
 * <p>
 * На выходе должно быть:
 * <p>
 * Санкт-Петербург был основан в 1703 году Петром Первым. За свою историю он носил имена: Санкт-Петербург, Петроград, Ленинград. Сейчас многие зовут его просто “ Питер ”.
 */

public class Task1 {
    public static void main(String[] args) {
        Integer I = 1703;
        String a = "Петром Первым";
        String[] arrayNames = {"Санкт-Петербург", "Петроград", "Ленинград"};
        String b = "Питер";

        String result = String.format(
                "Санкт-Петербург был основан в %d году %s . За свою историю он носил имена: %s, %s, %s. Сейчас многие зовут его просто “%s”.",
                I, a, arrayNames[0], arrayNames[1], arrayNames[2], b);

        System.out.println(result);
    }
}
