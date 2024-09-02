package org.db.students;

// Класс Command представляет собой команду, которая может быть выполнена в контексте управления студентами.

public class Command {
    // Поле для хранения действия, связанного с данной командой
    private Action action;
    // Поле для хранения дополнительных данных, необходимых для выполнения команды
    private String data;

    // Конструктор для создания команды с действием и дополнительными данными
    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }

    // Конструктор для создания команды только с действием
    public Command(Action action) {
        this.action = action;
    }

    // Метод для получения действия, связанного с данной командой
    public Action getAction() {
        return action;
    }

    // Метод для получения дополнительных данных команды
    public String getData() {
        return data;
    }
}
