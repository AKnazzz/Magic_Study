package org.workwork.c_java_core_one.homework_c3.work6.src;

import java.util.ArrayList;
import java.util.LinkedList;

// Класс для обработки подмассивов
public class SubArrayHandler {
    private SubArrayProcessor processor;

    // Конструктор с параметром processor
    public SubArrayHandler(SubArrayProcessor processor) {
        this.processor = processor;
    }

    // Метод для печати и вычисления подмассивов
    public void printSubArray(ArrayList<Integer> asList, int k) {
        validateInput(asList, k);

        LinkedList<Integer> subArray = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            subArray.add(asList.get(i));
        }

        printAndCompute(subArray, k);

        for (int i = k; i < asList.size(); i++) {
            subArray.add(asList.get(i));
            subArray.remove();
            printAndCompute(subArray, k);
        }
    }

    // Приватный метод для проверки входных данных
    private void validateInput(ArrayList<Integer> asList, int k) {
        if (asList.isEmpty()) {
            throw new IllegalArgumentException("Массив значений пуст");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("Значение k меньше или равно нулю");
        }
        if (k > asList.size()) {
            throw new IllegalArgumentException("Значение k больше размера массива");
        }
    }

    // Приватный метод для печати и вычисления результатов
    private void printAndCompute(LinkedList<Integer> subArray, int k) {
        System.out.println("SubArray: " + subArray);
        double result = processor.processSubArray(subArray, k);
        System.out.println("Result: " + result);
    }
}
