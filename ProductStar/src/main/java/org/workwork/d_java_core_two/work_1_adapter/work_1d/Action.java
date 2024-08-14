package org.workwork.d_java_core_two.work_1_adapter.work_1d;

import java.util.Objects;
import java.util.stream.Stream;

public enum Action {
    EXIT(0, false),
    SAVE(1, true),
    DELETE(2,true),
    SEARCH(3,true),
    ERROR(-1, false);

    private Integer code;

    private boolean requireAdditionalData;

    public Integer getCode() {
        return code;
    }

    public boolean isRequireAdditionalData() {
        return requireAdditionalData;
    }
    public static Action fromCode(Integer code) {

        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия :" + code);
                    return Action.ERROR;});
    }
    Action(Integer code, boolean requireAdditionalData) {
        this.code = code;
        this.requireAdditionalData = requireAdditionalData;
    }
}
