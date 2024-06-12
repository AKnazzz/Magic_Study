package org.ya.module_7.stream_apt.task_client;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class TestNumbers {
    public static void main(String[] args) {

        /**
         * получить квадратный корень максимального числа или ноль
         */

        List<Integer> numbers = List.of(5, 15, 25, 56, 78, 90, 100, 110, 120, 130, 140);
        OptionalDouble maxNumber = numbers.stream()
                .mapToInt(a -> a)
                .mapToDouble(Math::sqrt)
                .max();

        System.out.println(maxNumber);

        /**
         *  разделить по пробелу на слова
         *  отфильтровать слова по длине <= 6
         *  сделать вывод в верхнем регистре
         */

        String s
                = "Минобороны по    поручению деда проведет учения, в ходе которых будет отработано применение    тактического ядерного оружия. Это обещают сделать «в ответ на провокационные заявления и угрозы со стороны Запада».";

        Arrays.stream(s.split("\\s+"))
                .filter(a -> a.length() <= 6)
                .map(String::toUpperCase)
                .sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);

    }
}
