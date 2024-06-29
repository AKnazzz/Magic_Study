package org.workwork.d_java_core_two.homeWork_d1.work_1d;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static FileCommandHandler FILE_COMMAND_HANDLER
            = new FileCommandHandler();
    public static void main(String[] args) throws IOException {

        while (true) {
            printMessage();
            Command command = readCommand();
            if (command.getAction() == Action.EXIT) {
                return;
            } else if (command.getAction() == Action.ERROR) {
                continue;
            } else {
                FILE_COMMAND_HANDLER.processCommand(command);
            }
        }
    }
    private static Command readCommand(){
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if (actionCode == 1) {
                System.out.println("Введите имя файла, директорию в виде \"C:\\\\temp\\\\\" и текст через запятую.");
            }
            if (actionCode == 3) {
                System.out.println("Введите имя файла и директорию в виде \"C:\\\\temp\\\\\"  через запятую.");
                //text,D:\\test\\,123321   например.
            }
            if (action.isRequireAdditionalData()) {
                String data = scanner.nextLine();
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        }catch (Exception ex) {
            System.out.println("Проблема обработки ввода. " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("-------------------------------");
        System.out.println("0. Выход");
        System.out.println("1. Сохранение файла ");
        System.out.println("2. Удаление файла");
        System.out.println("3. Поиск файла");
        System.out.println("-------------------------------");
    }

}
