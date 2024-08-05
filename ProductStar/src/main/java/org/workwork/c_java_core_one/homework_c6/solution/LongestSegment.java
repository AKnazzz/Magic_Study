package org.workwork.c_java_core_one.homework_c6.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class LongestSegment {

    public static void main(String[] args) {
        String filePath = "data2.txt"; // Укажите путь к вашему файлу

        try {
            // Читаем файл, превращаем его в поток строк, находим длину самого длинного отрезка
            double longestLength = Files.lines(Paths.get(filePath))
                    .map(line -> line.split("-")) // Разделяем строки по символу '-'
                    .flatMap(segment -> {
                        // Извлекаем координаты x и y для каждого конца отрезка
                        String[] start = segment[0].replace("(", "").replace(")", "").split(",");
                        String[] end = segment[1].replace("(", "").replace(")", "").split(",");

                        // Преобразуем строки в числа
                        double x1 = Double.parseDouble(start[0].split(":")[1]);
                        double y1 = Double.parseDouble(start[1].split(":")[1]);
                        double x2 = Double.parseDouble(end[0].split(":")[1]);
                        double y2 = Double.parseDouble(end[1].split(":")[1]);

                        // Вычисляем длину отрезка
                        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                        return Stream.of(length);
                    })
                    .max(Comparator.naturalOrder()) // Находим максимальную длину
                    .orElse(0.0); // Если нет отрезков, возвращаем 0

            // Выводим длину самого длинного отрезка
            System.out.println("Длина самого длинного отрезка: " + longestLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}