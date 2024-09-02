package org.db.students;

// Методы класса включают выполнение и отмену действий.
// Класс Action представляет собой действие, которое может быть выполнено в контексте управления студентами.

import java.util.Objects;
import java.util.stream.Stream;

//***********************************************************
// true - требуется ввод данных от пользователя
// false - не требуется ввод, только выводим данные

// Перечисление Action описывает различные действия, которые могут быть выполнены в программе.
public enum Action {
    EXIT (0, false),
    CREATE (1, true),
    UPDATE (2, true),
    DELETE (3, true),
    STATS_BY_COURSE (4, false),
    SHOW_ALL(5, false),
    SEARCH (6, true),
    STATS_BY_CITIES (7, false),
    ERROR (-1, false);

    // Код действия, связанный с конкретным действием
    private Integer code;
    // Флаг, указывающий, требуется ли для действия ввод дополнительных данных
    private boolean requireAdditionalData;

    // Конструктор для установки кода действия и флага дополнительных данных
    Action(Integer code, boolean requireAdditionalData) {
        this.code = code;
        this.requireAdditionalData = requireAdditionalData;
    }

    // Метод для получения кода действия
    public Integer getCode() {
        return code;
    }

    // Метод для проверки, требуется ли дополнительный ввод для действия
    public boolean isRequireAdditionalData() {
        return requireAdditionalData;
    }

    // Метод для получения действия на основе кода
    // Если код не соответствует ни одному действию, возвращается Action.ERROR
    public static Action fromCode (Integer code){
        Action res = Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код" + code);
                    return Action.ERROR;
                });
        return res;
    }
}
