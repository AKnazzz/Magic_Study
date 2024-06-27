package org.workwork.d_java_core_two.homeWork_d1.work_1d;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileCommandHandler {

    public void processCommand(Command command) throws IOException {
        Action action = command.getAction();
        switch (action) {
            case SAVE -> {

                processCreateCommand(command);
                break;
            }

            case DELETE -> {
                prosessDeleteComand(command);
                break;
            }

            case SEARCH -> {
                processSearchCommand(command);
                break;
            }
            default -> System.out.println("Действие " + action + " не поддерживается!");
        }
    }

    private void processSearchCommand(Command command) throws IOException {
        String data = command.getData();
        String[] dataArray = data.split(",");

        //проверка общего формата ввода данных
        if (dataArray.length != 2) {
            System.out.println("Неверный формат ввода данных!");
            new Command(Action.ERROR);

            //проверка формата ввода данных файла
        } else if (!dataArray[0].matches("(\\w)*")) {
            System.out.println("Неверный формат ввода имени файла!");
            new Command(Action.ERROR);

            //проверка формата ввода данных пути дириктории
        } else if (!dataArray[1].matches("([A-Za-z]{1}+:{1}+\\\\{2})+(((\\w*)?+(\\\\{2})?)*)?")) {
            System.out.println("Неверный формат ввода директории!" + dataArray[1]);
            new Command(Action.ERROR);


        } else {
            File theDir = new File(dataArray[1] + dataArray[0] + ".txt");
            if (!theDir.exists()) {
                System.out.println("Файл не найден! Уточните директорию или имя файла.");
                new Command(Action.ERROR);
                //визуализация данных
            } else {
                System.out.println("Файл найден! Открыть файл - 0/ Вывести содержимое - 1");
                Scanner scanner = new Scanner(System.in);
                String code = scanner.nextLine();
                Integer actionCode = Integer.valueOf(code);
                if (actionCode == 0){
                    System.out.println("Открытие файла...");
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(theDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (actionCode == 1) {

                    BufferedReader br = new BufferedReader(new FileReader(theDir));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Текст из файла: " + line);
                    }
                } else {
                    System.out.println("Проблема обработки ввода.");
                    new Command(Action.ERROR);}
            }
        }
    }

    private void processCreateCommand(Command command) throws IOException {
        String data = command.getData();
        String[] dataArray = data.split(",");

        //проверка общего формата ввода данных
        if((dataArray.length < 2) && (dataArray.length > 3)){
            System.out.println("Неверный формат ввода данных!");
            new Command(Action.ERROR);

            //проверка формата ввода данных файла
        } else if (!dataArray[0].matches("(\\w)*")) {
            System.out.println("Неверный формат ввода имени файла!");
            new Command(Action.ERROR);

            //проверка формата ввода данных пути дириктории
        } else if (!dataArray[1].matches("([A-Za-z]{1}+:{1}+\\\\{2})+(((\\w*)?+(\\\\{2})?)*)?")) {
        System.out.println("Неверный формат ввода директории!" + dataArray[1]);
            new Command(Action.ERROR);

            //проверка пустого значения текста
        } else if (dataArray.length == 2) {

            System.out.println("Ваш файл пустой. Вы хотите его сохранить?(Да - 1/Нет - 0)");
            Scanner scanner = new Scanner(System.in);
                String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
                if (actionCode == 0){
                    new Command(Action.ERROR);
                } else if (actionCode == 1) {
                    System.out.println("Обработка команды сохранение файла...");
                    recFile1(dataArray);
                } else {
                    System.out.println("Проблема обработки ввода.");
                    new Command(Action.ERROR);}

            } else {
            System.out.println("Обработка команды сохранение файла...");
                recFile1(dataArray);
            }
        }


    //проверка наличия директорий, создание директорий
   private void recFile1(String[] dataArray) throws IOException {

       File fileDir = new File(dataArray[1]);
       if (!fileDir.exists()) {
           fileDir.mkdirs();}

       File file = new File(dataArray[1] + dataArray[0] + ".txt");

       if (!file.exists()) {
           recFile2(dataArray,file);
       } else {
           System.out.println("Файл уже существует. Вы хотите его перзаписать?(Да - 1/Нет - 0)");
           Scanner scanner = new Scanner(System.in);
           String code = scanner.nextLine();
           Integer actionCode = Integer.valueOf(code);
           if (actionCode == 0) {
               new Command(Action.ERROR);
           } else if (actionCode == 1) {
               System.out.println("Обработка команды сохранение файла...");
               recFile2(dataArray,file);
           }
       }
   }

   //метод записи/сохранения текста в файл и вывода информации
    private void recFile2(String[] dataArray, File file) throws IOException {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        if (dataArray.length == 3) {
            output.write(dataArray[2]);
        } else {
            output.write("");
        }
        output.close();

        System.out.println("Файл " + dataArray[0] + ".txt успешно записан.\n" +
                "Дата записи: " + date + ".\n" +
                "Время записи: " + String.format(time.format(formatter)) + ".\n" +
                "Размер файла: " + file.length() + "KB.");

    }

//метод удаления файла
   public void prosessDeleteComand(Command command){
       System.out.println("Алгоритм в разработке");
       new Command(Action.ERROR);
    }
}
