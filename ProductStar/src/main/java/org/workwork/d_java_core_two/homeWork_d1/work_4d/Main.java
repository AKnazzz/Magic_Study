package org.workwork.d_java_core_two.homeWork_d1.work_4d;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = creatingFileAndWriting();//Создаем директорию, файл и записываем данные
        lengthOfFile(file);//Получаем размер файла и время изменения
        reading(file);//Читаем файл
        File fileWithNewData = rewriting(file);//Перезаписываем файл, добавляя новые данные
        reading(fileWithNewData);//Читаем перезарисанный файл
    }


    public static File creatingFileAndWriting() throws IOException {//создание файла и запись
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nВведите директорию для сохранения файла формата \n Диск:\\директория\\...");
        File dir = new File(scanner.nextLine());
        dir.mkdirs();

        System.out.println("Введите имя файла");
        File file = new File(dir, scanner.nextLine() + ".txt");
        file.createNewFile();

        System.out.println("\nВведите текст для сохранения");
        String text = scanner.nextLine();

        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
        return file;

    }
    public static void lengthOfFile (File file) {//размер файла и время последнего изменения
        long length = file.length();
        long lastModified = file.lastModified();
        Date dt = new Date(lastModified);
        System.out.println("Размер файла составляет " + length + " байт " +
                "\nПоследний раз изменен " + dt);

    }
    public static File rewriting(File file) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дополнительный текст");
        String text = scanner.nextLine();
        writer.append("\n"+text);
        writer.close();
        scanner.close();
        return file;
    }
    public static void reading (File file) throws IOException {
        BufferedReader reader  = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            System.out.println(reader.readLine());

        }
        reader.close();
    }
}


