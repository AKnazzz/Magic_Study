package org.db.students;

// Класс Main является точкой входа в программу, содержащей метод main.
// Метод main инициализирует обработку команд и запускает приложение.

import java.util.Scanner;

public class Main {

    // Создание статического экземпляра класса StudentCommandHandler, который будет обрабатывать команды.
    private static StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    // Метод main - точка входа в приложение.
    public static void main(String[] args) {
        while (true) {
            // Выводит сообщение с возможными командами на экран.
            printMessage();

            // Считывает команду, введенную пользователем, и возвращает объект Command.
            Command command = readCommand();

            // Проверяет, является ли команда командой выхода.
            if (command.getAction() == Action.EXIT) {
                return; // Завершает работу программы, если введена команда выхода.
            } else if (command.getAction() == Action.ERROR) {
                continue; // Если введена некорректная команда, цикл продолжается, игнорируя ошибку.
            } else {
                // Если команда корректная, она передается обработчику команд для выполнения.
                STUDENT_COMMAND_HANDLER.processCommand(command);
            }
        }
    }

    // Метод readCommand считывает код команды и дополнительные данные от пользователя.
    private static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите код команды: ");
            String code = scanner.nextLine(); // Считывает код команды, введенный пользователем.
            Integer actionCode = Integer.valueOf(code); // Преобразует введенный код в число.
            Action action = Action.fromCode(actionCode); // Определяет, какую команду выбрал пользователь.

            // Проверяет, требуется ли ввод дополнительных данных для выбранной команды.
            if (action.isRequireAdditionalData()) {
                System.out.println("Введите необходимые данные: ");
                String data = scanner.nextLine(); // Считывает дополнительные данные.

                // Дополнительная проверка на пустой ввод данных.
                if (data.isEmpty()) {
                    System.out.println("Ошибка: данные не могут быть пустыми.");
                    return new Command(Action.ERROR); // Возвращает ошибку, если данные пустые.
                }

                // Возвращает команду с дополнительными данными.
                return new Command(action, data);
            } else {
                // Возвращает команду без дополнительных данных.
                return new Command(action);
            }
        } catch (NumberFormatException ex) {
            // Обработка ошибки, если пользователь ввел некорректный код команды.
            System.out.println("Ошибка: некорректный ввод. Введите числовой код команды.");
            return new Command(Action.ERROR);
        } catch (Exception ex) {
            // Обработка всех остальных ошибок ввода.
            System.out.println("Ошибка ввода: " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    // Метод printMessage выводит на экран список доступных команд.
    private static void printMessage() {
        System.out.println("+-------------------------------------+");
        System.out.println("|          БАЗА ДАННЫХ СТУДЕНТОВ      |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 0. Выход                            |");
        System.out.println("| 1. Создать нового студента          |");
        System.out.println("| 2. Обновить данные студента         |");
        System.out.println("| 3. Удалить студента                 |");
        System.out.println("| 4. Показать статистику по курсам    |");
        System.out.println("| 5. Показать всех студентов          |");
        System.out.println("| 6. Поиск по фамилии                 |");
        System.out.println("| 7. Показать статистику по городам   |");
        System.out.println("+-------------------------------------+");
    }

}
