package org.workwork.c_java_core_one.homework_c6.solution;

import java.io.*;

public class SegmentLength {
    public static void main(String[] args) {

        String filename = "segments.txt";

        // 1. Создание файла с отрезками
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("(x:1,y:5)-(x:2,y:6)\n");
            writer.write("(x:3,y:1)-(x:7,y:4)\n");
            writer.write("(x:0,y:0)-(x:3,y:4)\n");
            writer.write("(x:5,y:5)-(x:5,y:10)\n");
            writer.write("(x:1,y:1)-(x:4,y:1)\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Чтение файла
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // 3. Превращаем его в поток строк и находим длину самого длинного отрезка
            double longestSegmentLength = reader.lines()
                    .mapToDouble(SegmentLength::calculateSegmentLength)
                    .max()
                    .orElse(0);

            // 5. Вывод длины в поток вывода
            System.out.println("Длина самого длинного отрезка: " + longestSegmentLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для вычисления длины отрезка
    private static double calculateSegmentLength(String segment) {
        String[] points = segment.replaceAll("[()]", "").split("-");
        String[] start = points[0].split(",");
        String[] end = points[1].split(",");

        double x1 = Double.parseDouble(start[0].split(":")[1]);
        double y1 = Double.parseDouble(start[1].split(":")[1]);
        double x2 = Double.parseDouble(end[0].split(":")[1]);
        double y2 = Double.parseDouble(end[1].split(":")[1]);

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}