package org.workwork.d_java_core_two.work_1_adapter.solution;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileUploader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine().trim();

        System.out.print("Введите директорию: ");
        String directory = scanner.nextLine().trim();

        System.out.print("Введите текст для сохранения: ");
        String content = scanner.nextLine();

        // Валидация входных данных
        if (!isValidFileName(fileName)) {
            System.out.println("Ошибка: Неверное имя файла.");
            return;
        }
        if (!isValidDirectory(directory)) {
            System.out.println("Ошибка: Неверная директория.");
            return;
        }

        // Сохранение файла
        try {
            long startTime = System.currentTimeMillis();
            saveFile(directory, fileName, content);
            long endTime = System.currentTimeMillis();

            File savedFile = new File(directory, fileName);
            System.out.println("Файл успешно сохранен.");
            System.out.println("Размер файла: " + savedFile.length() + " байт");
            System.out.println("Время записи: " + (endTime - startTime) + " мс");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }

        // Поиск файла
        System.out.print("Хотите найти файл? (да/нет): ");
        String searchResponse = scanner.nextLine().trim().toLowerCase();
        if (searchResponse.equals("да")) {
            System.out.print("Введите имя файла для поиска: ");
            String searchFileName = scanner.nextLine().trim();
            searchFile(directory, searchFileName);
        }

        scanner.close();
    }

    private static boolean isValidFileName(String fileName) {
        return fileName != null && !fileName.isEmpty() && !fileName.contains("/");
    }

    private static boolean isValidDirectory(String directory) {
        File dir = new File(directory);
        return dir.exists() && dir.isDirectory();
    }

    private static void saveFile(String directory, String fileName, String content) throws IOException {
        File file = new File(directory, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    private static void searchFile(String directory, String fileName) {
        File file = new File(directory, fileName);
        if (file.exists()) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                System.out.println("Содержимое файла:");
                System.out.println(content);
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
            }
        } else {
            System.out.println("Файл не найден.");
        }
    }
}

