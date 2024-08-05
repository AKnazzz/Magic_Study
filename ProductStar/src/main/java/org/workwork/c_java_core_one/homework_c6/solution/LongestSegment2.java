package org.workwork.c_java_core_one.homework_c6.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestSegment2 {

    public static void main(String[] args) {
        String filePath = "data2.txt"; // Укажите путь к вашему файлу
        double longestLength = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Разделяем строку по символу '-'
                String[] segment = line.split("-");
                if (segment.length == 2) {
                    // Извлекаем координаты x и y для каждого конца отрезка
                    String[] start = segment[0].replace("(", "").replace(")", "").split(",");
                    String[] end = segment[1].replace("(", "").replace(")", "").split(",");

                    // Преобразуем строки в числа
                    double x1 = Double.parseDouble(start[0].split(":")[1].trim());
                    double y1 = Double.parseDouble(start[1].split(":")[1].trim());
                    double x2 = Double.parseDouble(end[0].split(":")[1].trim());
                    double y2 = Double.parseDouble(end[1].split(":")[1].trim());

                    // Вычисляем длину отрезка
                    double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                    // Сравниваем с текущей максимальной длиной
                    if (length > longestLength) {
                        longestLength = length;
                    }
                }
            }

            // Выводим длину самого длинного отрезка
            System.out.println("Длина самого длинного отрезка: " + longestLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}