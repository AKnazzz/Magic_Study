package org.workwork.c_java_core_one.homework_c3.work6.src;

import java.util.ArrayList;
import java.util.Arrays;

// Основной класс программы
public class Main {
    public static void main(String[] args) {
        int k = 4;
        ArrayList<Integer> asList = new ArrayList<>(Arrays.asList(1, 7, 9, 4, 3));

        // Создание экземпляров классов
        SubArrayProcessor processor = new AverageProcessor();
        SubArrayHandler handler = new SubArrayHandler(processor);

        try {
            // Вызов метода для обработки подмассивов
            handler.printSubArray(asList, k);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
