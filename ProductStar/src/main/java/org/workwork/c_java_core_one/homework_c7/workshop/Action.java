package org.workwork.c_java_core_one.homework_c7.workshop;

import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Представляет вариант выбранный пользователем
 */

public enum Action {
    EXIT(0, false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSES(4, false),
    STATS_BY_CITIES(5, false),
    SEARCH(6, true),
    ERROR(-1, false);

    @Getter
    private Integer code;

    @Getter
    private boolean requiredAdditionalData;

    Action(Integer code, boolean requiredAdditionalData) {
        this.code = code;
        this.requiredAdditionalData = requiredAdditionalData;
    }

    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия.");
                    return Action.ERROR;
                });
    }
}